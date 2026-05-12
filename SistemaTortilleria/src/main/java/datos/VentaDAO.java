/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import Infraestructura.ConexionDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dtos.DetalleVentaDTO;
import dtos.VentaDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/** 
 *
 * @author MoriTejo
 */
public class VentaDAO implements  IVentaDAO{
    private MongoCollection<Document> collection;

    public VentaDAO() {
        this.collection = ConexionDB.getInstance().getDatabase().getCollection("ventas");
    }

    @Override
    public boolean guardarVenta(VentaDTO venta) {
        try {
            List<Document> productos = new ArrayList<>();
            for (DetalleVentaDTO detalle : venta.getProductos()) {
                productos.add(new Document("nombreProducto", detalle.getNombreProducto())
                        .append("cantidadKilos", detalle.getCantidadKilos())
                        .append("subtotal", detalle.getSubtotal()));
            }

            Document docVenta = new Document("idVenta", venta.getIdVenta())
                    .append("montoTotal", venta.getMontoTotal())
                    .append("metodoPago", venta.getMetodoPago())
                    .append("fecha", venta.getFechaHora()) 
                    .append("productos", productos);

            if (venta.getCliente() != null) {
                Document docDireccion = new Document("calle", venta.getCliente().getDireccion().getCalle())
                        .append("colonia", venta.getCliente().getDireccion().getColonia())
                        .append("numero", venta.getCliente().getDireccion().getNumero());

                Document docCliente = new Document("nombre", venta.getCliente().getNombre())
                        .append("telefono", venta.getCliente().getTelefono())
                        .append("direccion", docDireccion); 

                docVenta.append("cliente", docCliente); 
            }

            collection.insertOne(docVenta);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<VentaDTO> ventasPorFecha(LocalDate inicio, LocalDate fin) {
        Date fechaInicio = Date.from(inicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(fin.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        var filtro = new Document("fecha", new Document("$gte", fechaInicio).append("$lte", fechaFin));
        var resultados = collection.find(filtro);

        List<VentaDTO> lista = new ArrayList<>();
        for (Document doc : resultados) {
            Number totalNum = (Number) doc.get("montoTotal");
            double total = totalNum != null ? totalNum.doubleValue() : 0.0;
            String metodo = doc.getString("metodoPago") != null ? doc.getString("metodoPago") : "Efectivo";
            
            lista.add(new VentaDTO(doc.getInteger("idVenta", 0), new ArrayList<>(), null, total, metodo));
        }
        return lista;
    }
}

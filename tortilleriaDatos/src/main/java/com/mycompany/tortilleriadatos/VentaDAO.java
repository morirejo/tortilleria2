/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tortilleriadatos;

import com.mongodb.client.MongoCollection;
import com.mycompany.tortilleriadtos.DetalleVentaDTO;
import com.mycompany.tortilleriadtos.VentaDTO;
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
            Date fecha = doc.getDate("fecha");
            
            lista.add(new VentaDTO(doc.getInteger("idVenta", 0), new ArrayList<>(), total, metodo, fecha));
        }
        return lista;
    }
    
    @Override
public List<VentaDTO> obtenerTodasLasVentas() {
    List<VentaDTO> lista = new ArrayList<>();
    for (Document doc : collection.find()) {
        Number totalNum = (Number) doc.get("montoTotal");
        double total = totalNum != null ? totalNum.doubleValue() : 0.0;
        String metodo = doc.getString("metodoPago") != null ? doc.getString("metodoPago") : "Efectivo";
        Date fecha = new Date(); 
        Object fechaObjeto = doc.get("fecha");
        if (fechaObjeto instanceof java.util.Date) {
            fecha = (java.util.Date) fechaObjeto; 
        } else if (fechaObjeto instanceof Long) {
            fecha = new Date((Long) fechaObjeto); 
        }
        int id = doc.getInteger("idVenta", 0);

        List<DetalleVentaDTO> productos = new ArrayList<>();
        List<Document> prods = (List<Document>) doc.get("productos");
        if (prods != null) {
            for (Document p : prods) {
                Number kilos = (Number) p.get("cantidadKilos");
                Number subtotal = (Number) p.get("subtotal");
                productos.add(new DetalleVentaDTO(
                    p.getString("nombreProducto"),
                    kilos != null ? kilos.doubleValue() : 0,
                    subtotal != null ? subtotal.doubleValue() : 0
                ));
            }
        }
        lista.add(new VentaDTO(id, productos, total, metodo, fecha));
    }
    return lista;
}

@Override
public boolean cancelarVenta(int idVenta) {
    try {
        collection.deleteOne(new Document("idVenta", idVenta));
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.ventas;

import java.util.GregorianCalendar;
import dtos.VentaDTO;
import datos.IVentaDAO;
import datos.VentaDAO;
import datos.VentaDAOMock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private IVentaDAO ventaDAO = new VentaDAO();
    private final double PRECIO_KG = 27.00;

    @Override
    public double calcularTotal(double kilos) { 
        return kilos * PRECIO_KG; 
    }

    @Override
    public boolean procesarVenta(List<dtos.DetalleVentaDTO> carrito, dtos.ClienteDTO cliente, double efectivoRecibido, String metodoPago) {
        double total = carrito.stream().mapToDouble(dtos.DetalleVentaDTO::getSubtotal).sum();
        if (efectivoRecibido >= total) {
            int folioVenta = (int) (Math.random() * 900000) + 100000;
            VentaDTO venta = new VentaDTO(folioVenta, carrito, cliente, total, metodoPago);
            return ventaDAO.guardarVenta(venta); 
        }
        return false; 
    }
    
    @Override
    public double calcularTotaldeVentas(List<VentaDTO> ventas) {
        double sumaTotal = 0.0;
        for (VentaDTO venta : ventas) {
            sumaTotal += venta.getMontoTotal();
        }
        return sumaTotal;
    }

    @Override
    public double calcularKilosTotales(List<VentaDTO> ventas) {
        double totalKilos = 0.0;
        for (VentaDTO venta : ventas) {
            if (venta.getProductos() != null) {
                for (dtos.DetalleVentaDTO producto : venta.getProductos()) {
                    totalKilos += producto.getCantidadKilos();
                }
            }
        }
        return totalKilos;
    }
}

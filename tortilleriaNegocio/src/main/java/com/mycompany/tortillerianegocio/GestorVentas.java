/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tortillerianegocio;

import com.mycompany.tortilleriadtos.DetalleVentaDTO;
import com.mycompany.tortilleriadtos.VentaDTO;
import java.util.Date;
import java.util.List;

/**
 * @author MoriTejo
 */
public class GestorVentas implements IGestorVentas{
    private final double PRECIO_KG = 27.00;

    public GestorVentas() {
    }
    
    @Override
    public double calcularTotal(double kilos) { 
        return kilos * PRECIO_KG; 
    }

    @Override
    public VentaDTO generarVenta(List<DetalleVentaDTO> carrito, double efectivoRecibido, String metodoPago) {
    double total = carrito.stream().mapToDouble(DetalleVentaDTO::getSubtotal).sum();
    int folioVenta = (int) (Math.random() * 900000) + 100000;
    Date fechaActual = new Date();
    return new VentaDTO(folioVenta, carrito, total, metodoPago, fechaActual);
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
                for (DetalleVentaDTO producto : venta.getProductos()) {
                    totalKilos += producto.getCantidadKilos();
                }
            }
        }
        return totalKilos;
    }
}

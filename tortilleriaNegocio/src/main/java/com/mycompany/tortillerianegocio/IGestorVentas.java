/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tortillerianegocio;

import com.mycompany.tortilleriadtos.DetalleVentaDTO;
import com.mycompany.tortilleriadtos.VentaDTO;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public interface IGestorVentas {
    public double calcularTotal(double cantidadKG);
    public VentaDTO generarVenta(List<DetalleVentaDTO> carrito, double efectivoRecibido, String metodoPago);
    public double calcularTotaldeVentas(List<VentaDTO> ventas);
    public double calcularKilosTotales(List<VentaDTO> ventas);
    
}

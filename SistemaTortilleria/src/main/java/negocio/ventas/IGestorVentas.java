/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.ventas;

import dtos.ClienteDTO;
import dtos.DetalleVentaDTO;
import dtos.VentaDTO;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public interface IGestorVentas {
    public double calcularTotal(double cantidadKG);
    public boolean procesarVenta(List<DetalleVentaDTO> carrito, ClienteDTO cliente, double efectivoRecibido, String metodoPago);
    public double calcularTotaldeVentas(List<VentaDTO> ventas);
    public double calcularKilosTotales(List<VentaDTO> ventas);
    
}

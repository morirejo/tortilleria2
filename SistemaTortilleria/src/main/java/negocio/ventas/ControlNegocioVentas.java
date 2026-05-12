/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.ventas;

import datos.VentaDAO;
import dtos.VentaDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public class ControlNegocioVentas {
    private IGestorVentas gestor = new GestorVentas();
    private VentaDAO dao = new VentaDAO();

    public double calcularTotal(double kilos) { 
        return gestor.calcularTotal(kilos); 
    }
    
    public boolean confirmarVenta(List<dtos.DetalleVentaDTO> carrito, dtos.ClienteDTO cliente, double efectivo, String metodoPago) { 
        return gestor.procesarVenta(carrito, cliente, efectivo, metodoPago); 
    }
    
    public List<VentaDTO> obtenerVentas(LocalDate fechaInicio, LocalDate fechaFin) {
        return dao.ventasPorFecha(fechaInicio, fechaFin);
    }

    public double calcularTotalVentas(List<VentaDTO> ventas) {
        return gestor.calcularTotaldeVentas(ventas);
    }

    public double calcularKilosTotales(List<VentaDTO> ventas) {
        return gestor.calcularKilosTotales(ventas);
    }
}

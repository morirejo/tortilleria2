/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tortillerianegocio;

import com.mycompany.tortilleriadatos.VentaDAO;
import com.mycompany.tortilleriadtos.DetalleVentaDTO;
import com.mycompany.tortilleriadtos.VentaDTO;
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
    
    public boolean confirmarVenta(List<DetalleVentaDTO> carrito, double efectivo, String metodoPago) { 
        VentaDTO nuevaVenta = gestor.generarVenta(carrito, efectivo, metodoPago);
        if (nuevaVenta != null) {
            return dao.guardarVenta(nuevaVenta);
        }
        return false;
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
    public List<VentaDTO> obtenerTodasLasVentas() {
    return dao.obtenerTodasLasVentas();
}

public boolean cancelarVenta(int idVenta) {
    return dao.cancelarVenta(idVenta);
}
}

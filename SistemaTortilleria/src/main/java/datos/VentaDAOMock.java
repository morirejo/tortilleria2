/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dtos.VentaDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public class VentaDAOMock implements IVentaDAO {
    @Override
    public boolean guardarVenta(VentaDTO venta) {
        
        System.out.println("sistema datos (mock)");
       // System.out.println("Se guardo en la BD la venta de: " + venta.getCantidadKG() + "con un precio de $ " + venta.getMontoTotal() + " por kg");
        return true;
    }

    @Override
    public List<VentaDTO> ventasPorFecha(LocalDate inicio, LocalDate fin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
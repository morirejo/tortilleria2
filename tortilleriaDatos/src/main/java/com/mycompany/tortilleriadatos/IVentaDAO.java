/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tortilleriadatos;

import com.mycompany.tortilleriadtos.VentaDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public interface IVentaDAO {
    public boolean guardarVenta(VentaDTO venta);
    public List<VentaDTO> ventasPorFecha(LocalDate inicio, LocalDate fin);
    public List<VentaDTO> obtenerTodasLasVentas();
    public boolean cancelarVenta(int idVenta);
}

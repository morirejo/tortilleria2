/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dtos.VentaDTO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public interface IVentaDAO {
    public boolean guardarVenta(VentaDTO venta);
    public List<VentaDTO> ventasPorFecha(LocalDate inicio, LocalDate fin);
}

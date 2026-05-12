/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.cierreCaja;

import dtos.cierreCaja.CorteCajaDTO;

/**
 *
 * @author MoriTejo
 */
public interface ICajaDAO {
    public double[] obtenerVentasSegmentadas();
    public boolean guardarCorte(CorteCajaDTO corte);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import daos.CajaDAO;
import datos.cierreCaja.ICajaDAO;
import dtos.cierreCaja.CorteCajaDTO;

/**
 *
 * @author MoriTejo
 */
public class GestorCaja implements IGestorCaja {
    private ICajaDAO dao = new CajaDAO();

    @Override
    public CorteCajaDTO prepararResumen(double efectivoFisico) {
        double[] totales = dao.obtenerVentasSegmentadas();
        
        return new CorteCajaDTO(totales[0], totales[1], totales[2], efectivoFisico);
    }

    @Override
    public boolean cerrarCaja(CorteCajaDTO corte) {
        return dao.guardarCorte(corte);
    }
}
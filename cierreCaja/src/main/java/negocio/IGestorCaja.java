/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.cierreCaja.CorteCajaDTO;

/**
 *
 * @author MoriTejo
 */
public interface IGestorCaja {
    public CorteCajaDTO prepararResumen(double efectivoFisico);
    public boolean cerrarCaja(CorteCajaDTO corte);
    public double[] obtenerTotalesSistema();
}

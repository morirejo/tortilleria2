/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import dtos.cierreCaja.CorteCajaDTO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.ControlNegocioCierre;

/**
 *
 * @author MoriTejo
 */
public class ControlPresentacionCierre {
    private ControlNegocioCierre negocio = new ControlNegocioCierre();
    private CorteCajaDTO corteTemporal;

    public void iniciarCierre() {
        double[] totales = negocio.obtenerTotales();
        new PantallaCierrePrincipal(this, totales).setVisible(true);
    }

    public void irAConteoEfectivo(JFrame actual) {
        actual.dispose(); 
        new PantallaConteoEfectivo(this).setVisible(true);
    }

    public void procesarConteo(double efectivoFisico, JFrame actual) {
        this.corteTemporal = negocio.calcularCierre(efectivoFisico); 
        actual.dispose();
        new PantallaRevisionCorte(this, corteTemporal).setVisible(true);
    }

    public void irAReporteIncidente(JFrame actual) {
        actual.dispose();
        new PantallaReporteIncidente(this).setVisible(true);
    }

    public void finalizarCorte(JFrame actual) {
        boolean exito = negocio.guardarCierre(this.corteTemporal);
        
        if (exito) {
            actual.dispose();
            new PantallaTurnoCerrado(this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(actual, "Error al guardar el corte en la base de datos.");
        }
    }
}

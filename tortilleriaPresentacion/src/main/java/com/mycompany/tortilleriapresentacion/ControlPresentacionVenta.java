/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tortilleriapresentacion;

import com.mycompany.tortilleriadtos.DetalleVentaDTO;
import com.mycompany.tortilleriadtos.VentaDTO;
import com.mycompany.tortillerianegocio.ControlNegocioVentas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author MoriTejo
 */
public class ControlPresentacionVenta {
    private ControlNegocioVentas controlNegocio;
    private PantallaReporteVentas vistaReporte;
    private double kilosActuales;
    private double totalActual;
    private double precioKgActual;

    public ControlPresentacionVenta() {
        this.controlNegocio = new ControlNegocioVentas();
        this.vistaReporte = new PantallaReporteVentas();
        
        vistaReporte.setGenerarListener(e -> generarReporte());
    }
    
    public void iniciar(){
        vistaReporte.setVisible(true);
    }

    // login a Comprar Tortillas
    public void navegarAPantallaVenta(JFrame pantallaAnterior) {
        if(pantallaAnterior != null) pantallaAnterior.dispose();
        new PantallaVenta(this).setVisible(true);
    }

    // calcular total en la pantalla de compras
    public double calcularTotal(double kilos) {
    this.kilosActuales = kilos;
    this.totalActual = controlNegocio.calcularTotal(kilos);
    this.precioKgActual = (kilos > 0) ? (this.totalActual / kilos) : 0;
    return this.totalActual;
}

public double calcularTotal(double kilos, double precioKg) {
    this.kilosActuales = kilos;
    this.precioKgActual = precioKg;
    this.totalActual = kilos * precioKg;
    return this.totalActual;
}

    // comprar Tortillas a metodo pago
    public void navegarAPantallaPago(JFrame pantallaActual) {
        int respuesta = JOptionPane.showConfirmDialog(pantallaActual, "¿Desea continuar con el pago?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (respuesta == JOptionPane.YES_OPTION) {
            pantallaActual.dispose();
            new PantallaMetodoPago(this).setVisible(true);
        }
    }

    // guardar venta y a la Pantalla de Éxito
    public void solicitarCobro(double efectivoRecibido, String metodoPago, JFrame pantallaActual) {
        if (efectivoRecibido >= totalActual) {
            List<DetalleVentaDTO> carrito = new ArrayList<>();
            carrito.add(new DetalleVentaDTO("Tortilla", kilosActuales, totalActual));
            boolean exito = controlNegocio.confirmarVenta(carrito, efectivoRecibido, metodoPago);
            
            if (exito) {
                pantallaActual.dispose();
                new PantallaTicket(this, kilosActuales, precioKgActual, totalActual).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(pantallaActual, "Error al guardar en la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(pantallaActual, "El pago ingresado es insuficiente.");
        }
    }

    // pantalla de Éxito de regreso a Comprar Tortillas
    public void finalizarYReiniciar(JFrame pantallaActual) {
        this.kilosActuales = 0;
        this.totalActual = 0;
        pantallaActual.dispose();
        navegarAPantallaVenta(null);
    }
    
    //generar reporte de ventas
    public void generarReporte(){
         try {
            LocalDate inicio = vistaReporte.getFechaInicio();
            LocalDate fin = vistaReporte.getFechaFin();
            var ventas = controlNegocio.obtenerVentas(inicio, fin);
            System.out.println("Ventas encontradas: " + ventas.size()); 

            vistaReporte.mostrarDatos(ventas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: revisa formato de fecha (dd/MM/yyyy)");
            e.printStackTrace();
        }
    }
    
    public List<VentaDTO> obtenerTodasLasVentas() {
    return controlNegocio.obtenerTodasLasVentas();
}

public boolean cancelarVenta(int idVenta) {
    return controlNegocio.cancelarVenta(idVenta);
}

public void navegarAPantallaCancelacion(JFrame pantallaActual) {
    pantallaActual.dispose();
    new PantallaCancelacion(this).setVisible(true);
}
}
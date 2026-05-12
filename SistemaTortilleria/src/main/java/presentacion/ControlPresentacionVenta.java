/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.DetalleVentaDTO;
import dtos.VentaDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.ventas.ControlNegocioVentas;

/**
 * @author MoriTejo
 */
public class ControlPresentacionVenta {
    private ControlNegocioVentas controlNegocio;
    private PantallaReporteVentas vistaReporte;
    private double kilosActuales;
    private double totalActual;

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
            List<dtos.DetalleVentaDTO> carrito = new ArrayList<>();
            carrito.add(new dtos.DetalleVentaDTO("Tortilla", kilosActuales, totalActual));
            dtos.ClienteDTO cliente = null;
            boolean exito = controlNegocio.confirmarVenta(carrito, cliente, efectivoRecibido, metodoPago);
            
            if (exito) {
                pantallaActual.dispose();
                new PantallaExito(this, kilosActuales, totalActual).setVisible(true);
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
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tortilleriadtos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MoriTejo
 */
public class VentaDTO {
    private int idVenta; 
    private List<DetalleVentaDTO> productos; 
    private double montoTotal;
    private String metodoPago;
    private Date fechaHora;

    public VentaDTO(int idVenta, List<DetalleVentaDTO> productos, double montoTotal, String metodoPago, Date fechaHora) {
        this.idVenta = idVenta;
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.fechaHora = fechaHora;
    }

    public VentaDTO() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public List<DetalleVentaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleVentaDTO> productos) {
        this.productos = productos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
    
}

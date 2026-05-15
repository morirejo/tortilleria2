/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author USUARIO
 */
public class PedidoDTO {

    private String producto;
    private int cantidad;
    private String direccion;
    private double total;
    private boolean domicilio;

    public PedidoDTO(
            String producto,
            int cantidad,
            String direccion,
            double total,
            boolean domicilio) {

        this.producto = producto;
        this.cantidad = cantidad;
        this.direccion = direccion;
        this.total = total;
        this.domicilio = domicilio;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getTotal() {
        return total;
    }

    public boolean isDomicilio() {
        return domicilio;
    }
}
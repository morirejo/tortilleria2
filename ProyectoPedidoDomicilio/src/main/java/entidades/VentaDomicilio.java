/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author USUARIO
 */
public class VentaDomicilio
        extends Venta {

    private Cliente cliente;
    private String direccion;

    public VentaDomicilio(
            Cliente cliente,
            String direccion,
            double total) {

        this.cliente = cliente;
        this.direccion = direccion;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }
}
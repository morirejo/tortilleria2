/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidoDomicilio;

/**
 *
 * @author USUARIO
 */
public class VentaDomicilioDTO
        extends Venta {

    private ClienteDTO cliente;
    private String direccion;

    public VentaDomicilioDTO(
            ClienteDTO cliente,
            String direccion,
            double total) {

        this.cliente = cliente;
        this.direccion = direccion;
        this.total = total;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }
}
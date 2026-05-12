/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author MoriTejo
 */
public class ClienteDTO {
    private String nombre;
    private String telefono;
    private DireccionDTO direccion; 

    public ClienteDTO(String nombre, String telefono, DireccionDTO direccion) {
        this.nombre = nombre; 
        this.telefono = telefono; 
        this.direccion = direccion;
    }

    public ClienteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }
    
    
}

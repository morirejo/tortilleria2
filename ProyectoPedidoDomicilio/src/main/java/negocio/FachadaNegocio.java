/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.PedidoDTO;

/**
 *
 * @author USUARIO
 */
public class FachadaNegocio {

    private ControlNegocio control =
            new ControlNegocio();

    public void registrarPedido(PedidoDTO pedido) {

        control.registrarPedido(pedido);
    }
}
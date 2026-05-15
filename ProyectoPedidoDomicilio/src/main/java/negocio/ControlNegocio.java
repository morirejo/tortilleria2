/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import daos.PedidoDAO;
import dtos.PedidoDTO;

/**
 *
 * @author USUARIO
 */
public class ControlNegocio
        implements IControlNegocio {

    private PedidoDAO dao =
            new PedidoDAO();

    @Override
    public void registrarPedido(PedidoDTO pedido) {

        dao.guardarPedido(pedido);
    }
}
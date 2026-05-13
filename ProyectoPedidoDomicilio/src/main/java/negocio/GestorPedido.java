/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import com.mycompany.tortilleriadtos.PedidoDTO;
import daos.PedidoDAO;

/**
 *
 * @author USUARIO
 */
public class GestorPedido {

    private PedidoDAO dao = new PedidoDAO();

    public void registrarPedido(PedidoDTO pedido) {

        dao.guardarPedido(pedido);
    }
}
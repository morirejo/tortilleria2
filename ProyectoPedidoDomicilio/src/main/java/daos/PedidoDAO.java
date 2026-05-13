/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mycompany.tortilleriadtos.PedidoDTO;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class PedidoDAO {

    private ArrayList<PedidoDTO> listaPedidos =
            new ArrayList<>();

    public void guardarPedido(PedidoDTO pedido) {

        listaPedidos.add(pedido);
    }

    public ArrayList<PedidoDTO> obtenerPedidos() {

        return listaPedidos;
    }
}
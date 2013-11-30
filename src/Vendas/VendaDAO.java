/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import Produto.Produto;
import Vendedor.Vendedor;
import java.util.List;

/**
 *
 * @author neto2_000
 */
public interface VendaDAO {
    void criar(Venda compra) throws Exception;
    void atualizar(Venda compra) throws Exception;
    void deletar(Venda comprha) throws Exception;
    List<Venda> consultar() throws Exception;
    List<Venda> consultarPorProduto(Produto produto)  throws Exception;
    List<Venda> consultarPorVendedor(Vendedor vendedor)  throws Exception;
}

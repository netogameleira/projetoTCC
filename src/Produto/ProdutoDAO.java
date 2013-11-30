/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

import java.util.List;

/**
 *
 * @author neto2_000
 */
public interface ProdutoDAO {
    void criar(Produto produto) throws Exception;
    void atualizar(Produto produto, int idp) throws Exception;
    void deletar(Produto produto) throws Exception;
    List<Produto> consultar() throws Exception;
    List<Produto> consultarPorNome(String nome) throws Exception;
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

import java.util.List;

/**
 *
 * @author neto2_000
 */
public interface VendedorDAO {
    void criar(Vendedor vendedor) throws Exception;
    void atualizar(Vendedor vendedor) throws Exception;
    void deletar(Vendedor vendedor) throws Exception;
    List<Vendedor> consultar() throws Exception;
    List<Vendedor> consultarPorNome(String nome) throws Exception;
}

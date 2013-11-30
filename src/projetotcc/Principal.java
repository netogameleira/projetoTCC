/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc;

import Vendas.VendaDAOJDBC;
import Produto.Produto;
import Produto.ProdutoDAOJDBC;
import Vendedor.Vendedor;
import Vendedor.VendedorDAOJDBC;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author neto2_000
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        VendedorDAOJDBC vendedordao = new VendedorDAOJDBC();
        
        List<Vendedor> vendedores = null;
        vendedores = new ArrayList<>();
        
        vendedores= vendedordao.consultar();
        
        for (Vendedor vendedor: vendedores) {
            System.out.println(vendedor);
        }
        
        
    }
}

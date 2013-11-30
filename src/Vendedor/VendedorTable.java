/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

import Produto.Produto;
import Produto.ProdutoDAOJDBC;
import Vendas.Venda;
import Vendas.VendaDAOJDBC;
import Vendas.VendaTable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neto
 */
public class VendedorTable extends AbstractTableModel {
    private final List<Vendedor> vendedores;
    public VendedorTable(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
   

    @Override
    public int getRowCount() {
        return vendedores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendedor vendedor = vendedores.get(rowIndex);
        int contDin = 0;
        switch (columnIndex) {
            case 0:
                return vendedor.getNome();
            case 1:
                return vendedor.getLogin();
            case 2:   
               return vendedor.getSenha();
        }       
        return "";
    }
        

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome";
            case 1:
                return "Login";
            case 2:
                return "Senha";
        }
        return null;
    }
    
    public void adicionarLinha(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
    public void atualiza(int linha, Vendedor vendedor){
        vendedores.set(linha, vendedor);
    }
    public Vendedor pegaAluno(int linha){
       Vendedor vendedor = vendedores.get(linha);
       return vendedor;
    }
    public void remove(int linha){
        vendedores.remove(linha);
    }
    
}

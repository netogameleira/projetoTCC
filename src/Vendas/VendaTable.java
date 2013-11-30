/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import Produto.Produto;
import Produto.ProdutoDAOJDBC;
import Vendedor.Vendedor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neto
 */
public class VendaTable extends AbstractTableModel {
    private final List<Venda> vendas;
    public VendaTable(List<Venda> vendas) {
        this.vendas = vendas;
    }
   

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda venda = vendas.get(rowIndex); 
        switch (columnIndex) {
            case 0:
                return venda.getNomeVendedor();
            case 1:
                return venda.getNomeProduto();
            case 2:
                return venda.getQuantidade();
            case 3:
                ProdutoDAOJDBC produtodao = new ProdutoDAOJDBC();
                List<Produto> produtos= null;
                produtos = new ArrayList<>();
                try {
                    produtos = produtodao.consultarPorNome(venda.getNomeProduto());
                } catch (Exception ex) {
                    Logger.getLogger(VendaTable.class.getName()).log(Level.SEVERE, null, ex);
                }
                // para cada Produto p na lista de arrays "produtos" faça
                for(Produto p : produtos){
                    if (p.getIdp() == venda.getIdp()){
                        return venda.valorTotal(p);    
                    //valor = p.getPreco();
                    //valores.add(valor);
                    }
                }
            case 4:
                   return venda.getData();
            }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Vendedor";
            case 1:
                return "Nome do Produto";
            case 2:
                return "Quantidade";
            case 3:
                return "Valor total";
            case 4:
                return "Data de venda";
        }
        return null;
    }
    
    public void adicionarLinha(Venda venda) {
        vendas.add(venda);
    }
    public void atualiza(int linha, Venda venda){
        vendas.set(linha, venda);
    }
    public Venda pegaAluno(int linha){
       Venda compra = vendas.get(linha);
       return compra;
    }
    public void remove(int linha){
        vendas.remove(linha);
    }
        
    
}

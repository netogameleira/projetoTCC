/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neto
 */
public class ProdutoTable extends AbstractTableModel {
    private final List<Produto> produtos;
    double valor = 0;
    public ProdutoTable(List<Produto> produtos) {
        this.produtos = produtos;
    }
   

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex); 
        switch (columnIndex) {
            case 0:
                return produto.getNome();
            case 1:
                return produto.getEstoque();
            case 2:
                return produto.getPreco();
        }    
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Produto";
            case 1:
                return "Quantidade no Estoque";
            case 2:
                return "Preço";
        }
        return null;
    }
    
    public void adicionarLinha(Produto produto) {
        produtos.add(produto);
    }
    public void atualiza(int linha, Produto produto){
        produtos.set(linha, produto);
    }
    public Produto pegaAluno(int linha){
       Produto produto = produtos.get(linha);
       return produto;
    }
    public void remove(int linha){
        produtos.remove(linha);
    }
    
}

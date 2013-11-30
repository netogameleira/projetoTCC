/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetotcc.Conexao;

/**
 *
 * @author neto2_000
 */
public class ProdutoDAOJDBC implements ProdutoDAO {

    @Override
    public void criar(Produto produto) throws Exception {
        String sql = "INSERT INTO produtos (nome_produto,estoque, preco) VALUES (?,?,?)";
        
        try (Connection conn = Conexao.getInstance(); PreparedStatement pst = conn.prepareStatement(sql)) {
           
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getEstoque());
            pst.setDouble(3, produto.getPreco());
            
            pst.executeUpdate();
            
            configuraCodigo(conn, produto);
           
        }
    }

     private void configuraCodigo(Connection conn, Produto produto) throws SQLException {
        String sqlConsultaCodigo = "SELECT MAX(idp) FROM produtos";
        try(Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sqlConsultaCodigo)){
        
            while(rst.next()){
                produto.setIdp(rst.getInt(1));
            }
        }
    }
    
    @Override
    public void atualizar(Produto produto, int idp) throws Exception {
        String sql = "UPDATE produtos SET nome = ?,estoque = ?,preco= ? WHERE idp = ?";
        try(Connection conn = Conexao.getInstance(); 
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getEstoque());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, idp);
            
            pst.executeUpdate();
        }
    }

    @Override
    public void deletar(Produto produto) throws Exception {
        String sql = "DELETE FROM produtos WHERE idp = ?";

        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, produto.getIdp());    
                
                pst.executeUpdate();
        }
    }

    @Override
    public List<Produto> consultar() throws Exception {
       List<Produto> produtos = null;
        String sql = "SELECT idp,nome,estoque, preco FROM produtos";
        try (Connection conn = Conexao.getInstance(); 
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sql)) {
        
            produtos = new ArrayList<>();
            while(rst.next()){
                
                Produto produto = new Produto(rst.getInt(1),rst.getString(2), rst.getInt(3), rst.getDouble(4));
                
                produtos.add(produto);
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> consultarPorNome(String nome) throws Exception {
            List<Produto> produtos = null;
            String sql = "SELECT idp,nome,estoque, preco FROM produtos WHERE nome = ?";
            try (Connection conn = Conexao.getInstance(); 
                PreparedStatement pst = conn.prepareStatement(sql)){
                pst.setString(1,nome);   
                ResultSet rst = pst.executeQuery();
        
                produtos = new ArrayList<>();
                while(rst.next()){
                
                    Produto produto = new Produto(rst.getInt(1),rst.getString(2),rst.getInt(3), 
                                              rst.getDouble(4));
                
                produtos.add(produto);
            
                }  
            }   
    return produtos;
    }
    
     public List<Produto> consultarPorQuantidade() throws Exception {
       List<Produto> produtos = null;
        String sql = "SELECT idp,nome,estoque, preco FROM produtos ORDER BY estoque ASC";
        try (Connection conn = Conexao.getInstance(); 
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sql)) {
        
            produtos = new ArrayList<>();
            while(rst.next()){
                
                Produto produto = new Produto(rst.getInt(1),rst.getString(2), rst.getInt(3), rst.getDouble(4));
                
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
    
    

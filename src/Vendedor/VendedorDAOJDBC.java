/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

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
public class VendedorDAOJDBC implements VendedorDAO {

    @Override
    public void criar(Vendedor vendedor) throws Exception {
        String sql = "INSERT INTO vendedores (nome, senha, login) VALUES (?,?,?)";
        
        try (Connection conn = Conexao.getInstance();
             PreparedStatement pst = conn.prepareStatement(sql)) {
           
             pst.setString(1, vendedor.getNome());
             pst.setString(2, vendedor.getSenha());
             pst.setString(3, vendedor.getLogin());
            
             pst.executeUpdate();
            
             configuraCodigo(conn, vendedor);
           
        }
    }
    
    private void configuraCodigo(Connection conn, Vendedor vendedor) throws SQLException {
         String sqlConsultaCodigo = "SELECT MAX(idv) FROM vendedores";
        try(Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sqlConsultaCodigo)){
        
            while(rst.next()){
                vendedor.setIdv(rst.getInt(1));
            }
        }
    }

    @Override
    public void atualizar(Vendedor vendedor) throws Exception {
        String sql = "UPDATE vendedores SET nome = ?,login = ?,senha = ? WHERE idv = ?";
        
        try(Connection conn = Conexao.getInstance(); 
            PreparedStatement pst = conn.prepareStatement(sql)){
                pst.setInt(4, vendedor.getIdv());
                pst.setString(1, vendedor.getNome());
                pst.setString(2, vendedor.getLogin());
                pst.setString(3, vendedor.getSenha());
                
                pst.executeUpdate();
        }
    }

    @Override
    public void deletar(Vendedor vendedor) throws Exception {
        String sql = "DELETE FROM vendedores WHERE idv = ?";

        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, vendedor.getIdv());
                
                pst.executeUpdate();
        }
    }

    @Override
    public List<Vendedor> consultar() throws Exception {
        List<Vendedor> vendedores = null;
        String sql = "SELECT idv, nome,login,senha FROM vendedores";
        try (Connection conn = Conexao.getInstance(); 
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sql)){
        
            vendedores = new ArrayList<>();
            while(rst.next()){
                
                Vendedor vendedor = new Vendedor(rst.getInt(1) , rst.getString(2),rst.getString(3), 
                                              rst.getString(4));
                
                vendedores.add(vendedor);
            
            }  
        }
    return vendedores;
    }

    @Override
    public List<Vendedor> consultarPorNome(String nome) throws Exception {
        List<Vendedor> vendedores = null;
        String sql = "SELECT  senha,login, nome FROM vendedores WHERE nome = ?";
        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)){
             pst.setString(1, nome);  
             ResultSet rst = pst.executeQuery();
        
             vendedores = new ArrayList<>();
             while(rst.next()){
                
                Vendedor vendedor = new Vendedor(rst.getString(1), rst.getString(2),rst.getString(3)); 
                                             
                
                vendedores.add(vendedor);
            }
        }  
    return vendedores;
    }

}    

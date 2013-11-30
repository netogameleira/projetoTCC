/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import Produto.Produto;
import Vendedor.Vendedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import projetotcc.Conexao;

/**
 *
 * @author neto2_000
 */
public class VendaDAOJDBC implements VendaDAO {
    @Override
    public void criar(Venda venda) throws Exception {
        String sql = "INSERT INTO vendas (idp,idv,data_compra,quantidade, nome_vendedor, nome produto) VALUES (?,?,?,?)";
        
        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
           
            pst.setInt(1, venda.getIdp());
            pst.setInt(2, venda.getIdv());
            
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");      
            java.util.Date data = new java.util.Date();
            String dataString = fmt.format(data);      
            
            pst.setString(3, dataString);
            
            pst.setInt(4, venda.getQuantidade());
            pst.setString(5, venda.getNomeVendedor());
            pst.setString(6, venda.getNomeProduto());
           
            
            pst.executeUpdate();
            
            configuraCodigo(conn, venda);
           
        }
    }
    
    private void configuraCodigo(Connection conn, Venda venda) throws SQLException {
       String sqlConsultaCodigo = "SELECT MAX(idc) FROM vendas";
        try(Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqlConsultaCodigo)){
        
            while(rst.next()){
                venda.setIdc(rst.getInt(1));
            }
        }
    }
    
    
    @Override
    public void atualizar(Venda compra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Venda venda) throws Exception {
        String sql = "DELETE FROM compra WHERE idc = ?";

        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, venda.getIdv());    
                
                pst.executeUpdate();
        }
    }

    @Override
    public List<Venda> consultar() throws Exception {
        List<Venda> vendas = null;
        String sql = "SELECT idc,idp,idv,data_compra, quantidade, nome_produto, nome_vendedor FROM vendas";
        try (Connection conn = Conexao.getInstance(); 
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sql)){
        
            vendas = new ArrayList<>();
            while(rst.next()){
                
                Venda venda = new Venda(rst.getInt(1),rst.getInt(2),rst.getInt(3),rst.getString(4),
                                           rst.getInt(5),rst.getString(6), rst.getString(7));
                
                vendas.add(venda);
            }
        }
        return vendas;
    }
    
    public List<Venda> consultarPorProduto(Produto produto) throws Exception {
        List<Venda> vendas = null;
        String sql = "SELECT idc,idp,idv,data_compra,quantidade, nome_produto,nome_cliente FROM vendss"
        + " INNER JOIN produtos ON (compras.idp = produtos.idp)"
        + "WHERE compras.idp =?";
        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)){
             pst.setInt(1,produto.getIdp());   
             ResultSet rst = pst.executeQuery(); 
        
             vendas = new ArrayList<>();
             while(rst.next()){
                
             Venda venda  = new Venda(rst.getInt(1),rst.getInt(2),rst.getInt(3), rst.getString(4),
                                         rst.getInt(5),rst.getString(6),rst.getString(7));
                
             vendas.add(venda);
                }
            }  
        return vendas;
    }
    
    public List<Venda> consultarPorVendedor(Vendedor vendedor) throws SQLException{
        
        List<Venda> vendas = null;
        String sql = "SELECT idc,idv,idp,data_compra,quantidade, nome_produto, nome_vendedor from vendas WHERE Idv = ?" ;      
        try (Connection conn = Conexao.getInstance(); 
             PreparedStatement pst = conn.prepareStatement(sql)){
             pst.setInt(1,vendedor.getIdv());
             ResultSet rst = pst.executeQuery(); 
        
             vendas = new ArrayList<>();
             while(rst.next()){
                
             Venda venda  = new Venda(rst.getInt(1), rst.getInt(2),rst.getInt(3),rst.getString(4),
                                         rst.getInt(5),rst.getString(6),rst.getString(7));
                
             vendas.add(venda);
                }
            }  
        return vendas;
    
    }
    
    public List<Venda> consultarPorData() throws Exception {
        List<Venda> vendas = null;
        String sql = "SELECT idc,idp,idv,data_compra, quantidade, nome_produto, nome_vendedor FROM vendas ORDER BY data_compra DESC ";
        try (Connection conn = Conexao.getInstance(); 
                Statement st = conn.createStatement();
                ResultSet rst = st.executeQuery(sql)){
        
            vendas = new ArrayList<>();
            while(rst.next()){
                
                Venda venda = new Venda(rst.getInt(1),rst.getInt(2),rst.getInt(3),rst.getString(4),
                                           rst.getInt(5),rst.getString(6), rst.getString(7));
                
                vendas.add(venda);
            }
        }
        return vendas;
    }
     
}

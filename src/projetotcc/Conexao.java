/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neto2_000
 */
public class Conexao {
    private static String url = "jdbc:mysql://127.0.0.1:3306/projetotcc?user=root&password=";
    private static Connection conn;
    
    private Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
  
    public static Connection getInstance() {  
        try {
            if (conn == null || conn.isClosed()) {
                new Conexao();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;  
    }  
}

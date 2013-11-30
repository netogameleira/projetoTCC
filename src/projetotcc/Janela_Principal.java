/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc;

import java.awt.Color;
import Vendas.VendaDAOJDBC;
import Vendedor.Vendedor;
import Vendedor.VendedorDAOJDBC;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author neto2_000
 */
public class Janela_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Janela_Principal
     */ 
    public Janela_Principal() {
        initComponents();
        getRootPane().setDefaultButton(jButton_Login);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel_NomeLoja = new javax.swing.JLabel();
        jLabel_EndETel = new javax.swing.JLabel();
        jLabel_CNPJ = new javax.swing.JLabel();
        jPanel_Login = new javax.swing.JPanel();
        jLabel_Senha = new javax.swing.JLabel();
        jLabel_Usuario = new javax.swing.JLabel();
        jTextField_Usuario = new javax.swing.JTextField();
        jPasswordField_Senha = new javax.swing.JPasswordField();
        jButton_Login = new javax.swing.JButton();
        jLabel_Creditos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projeto TCC");
        setBackground(new java.awt.Color(255, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imagem certa.jpg"))); // NOI18N

        jLabel_NomeLoja.setText("*Nome da Loja");

        jLabel_EndETel.setText("Endereço e telefone");

        jLabel_CNPJ.setText("CNPJ:");

        jLabel_Senha.setText("Senha:");

        jLabel_Usuario.setText("Usuário:");

        jButton_Login.setText("Login");
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_LoginLayout = new javax.swing.GroupLayout(jPanel_Login);
        jPanel_Login.setLayout(jPanel_LoginLayout);
        jPanel_LoginLayout.setHorizontalGroup(
            jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoginLayout.createSequentialGroup()
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_LoginLayout.createSequentialGroup()
                        .addComponent(jLabel_Senha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_LoginLayout.createSequentialGroup()
                        .addComponent(jLabel_Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Login)
                .addContainerGap())
        );
        jPanel_LoginLayout.setVerticalGroup(
            jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Senha)
                    .addComponent(jPasswordField_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButton_Login))
        );

        jLabel_Creditos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel_Creditos.setText("Desenvolvido por M&N Software");
        jLabel_Creditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_CreditosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_EndETel)
                            .addComponent(jLabel_NomeLoja))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel_CNPJ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Creditos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jPanel_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jPanel_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(95, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(74, 74, 74)))
                .addComponent(jLabel_NomeLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_EndETel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CNPJ)
                    .addComponent(jLabel_Creditos)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-482)/2, (screenSize.height-414)/2, 482, 414);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        // TODO add your handling code here:
        boolean merro =true;
        
        VendedorDAOJDBC vendedordaojdbc = new VendedorDAOJDBC();
        List<Vendedor> vendedores= null;
        vendedores = new ArrayList<>();
        try {
            vendedores = vendedordaojdbc.consultar();
        } catch (Exception ex) {
            Logger.getLogger(Janela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Vendedor vendedor: vendedores){
            if(vendedor.getLogin().equals(jTextField_Usuario.getText()) && vendedor.getSenha().equals(jPasswordField_Senha.getText())){
                merro=false;
                if(vendedor.getIdv()==1){
                    JanelaADM janela = new JanelaADM(vendedor);
                    janela.setVisible(true);
                    this.dispose();
                }else{
                    JanelaVendedor janela = new JanelaVendedor(vendedor);
                    janela.setVisible(true);
                    this.dispose();
                }
                
            }
        }    
        
        if(merro){
            JOptionPane.showMessageDialog(rootPane,"Informações incorretas, preencha os dados novamente ou então o banco de dados não está operante");
            jTextField_Usuario.setText("");
            jPasswordField_Senha.setText("");
            jTextField_Usuario.requestFocus();  
        }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jLabel_CreditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_CreditosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_CreditosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela_Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Login;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_CNPJ;
    private javax.swing.JLabel jLabel_Creditos;
    private javax.swing.JLabel jLabel_EndETel;
    private javax.swing.JLabel jLabel_NomeLoja;
    private javax.swing.JLabel jLabel_Senha;
    private javax.swing.JLabel jLabel_Usuario;
    private javax.swing.JPanel jPanel_Login;
    private javax.swing.JPasswordField jPasswordField_Senha;
    private javax.swing.JTextField jTextField_Usuario;
    // End of variables declaration//GEN-END:variables
}

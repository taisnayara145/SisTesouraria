package View;

import Model.bean.Usuario;
import Model.dao.UsuarioDao;
import javax.swing.JOptionPane;


public class TelaLogin extends javax.swing.JFrame {

   
    public TelaLogin() {
        initComponents();
        
        
    }
     private void Logar() {
       
        Usuario usuario     = new Usuario();
        UsuarioDao usuariodao = new UsuarioDao();
       
        usuario.setLogin(jTLogin.getText());
        usuario.setSenha(jPSenha.getText());
        
         Usuario us = usuariodao.ValidarUsuario(usuario);
         
            if(us != null){  
                
                new TelaPrincipal(us).setVisible(true);//chama a tela principal
                  
                dispose();//fecha a tela de login
               
            }else{
                JOptionPane.showMessageDialog(null, "usuario não cadastrado");
            }
        
    }//fim metodo
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLogin = new javax.swing.JPanel();
        jLLogin = new javax.swing.JLabel();
        jlLogin = new javax.swing.JLabel();
        jTLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();
        jBLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login do Usuário");
        setBounds(new java.awt.Rectangle(380, 300, 300, 300));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPLogin.setBackground(new java.awt.Color(0, 119, 119));
        jPLogin.setMaximumSize(null);

        jLLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/login_1.jpg"))); // NOI18N

        jlLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlLogin.setText("LOGIN:");

        jLSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLSenha.setText("SENHA:");

        jPSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPSenhaActionPerformed(evt);
            }
        });

        jBLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btlogin.jpg"))); // NOI18N
        jBLogin.setText("   ENTRAR ");
        jBLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLogin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/label.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/key1_1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPLoginLayout = new javax.swing.GroupLayout(jPLogin);
        jPLogin.setLayout(jPLoginLayout);
        jPLoginLayout.setHorizontalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLoginLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLSenha)
                                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPLoginLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlLogin)
                                    .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jBLogin)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLLogin)
                .addGap(92, 92, 92))
        );
        jPLoginLayout.setVerticalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLLogin)
                .addGap(19, 19, 19)
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addComponent(jlLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jBLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
       
        Logar();
        
    }//GEN-LAST:event_jBLoginActionPerformed

    private void jPSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPSenhaActionPerformed

    }//GEN-LAST:event_jPSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLogin;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPLogin;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTLogin;
    private javax.swing.JLabel jlLogin;
    // End of variables declaration//GEN-END:variables

    
}


package View;

import Control.ControllerTesouraria;
import Model.bean.NivelAcesso;
import Model.bean.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class TelaCadUsuario extends javax.swing.JFrame {
    ControllerTesouraria ct = new ControllerTesouraria();
    Usuario usuario = new Usuario();
     
    public TelaCadUsuario()  {
        initComponents();
      ct.PreencherJcbNivel(jcbNivel);
    }

     private boolean ValidarCampos() {

    if(!txtnome.getText().equals("")&& !txtlogin.getText().equals("")&& !txtsenha.getText().equals("")&& !jcbNivel.getSelectedItem().equals("SELECIONE")){ //campos diferentes de vazio cadastra, retorna verdadeiro
      return true;   
    }
    else { // senao, nao cadastra e exibe a mensagem
    JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txtnome.requestFocus();
     } return false;
     }

    private void cadastrar() throws SQLException {
        usuario.setNome(txtnome.getText());
        usuario.setLogin(txtlogin.getText());
        usuario.setSenha(txtsenha.getText());
        usuario.setNivel((NivelAcesso) jcbNivel.getSelectedItem());
       
        ct.cadastrarUsuario(usuario);
        JOptionPane.showMessageDialog(null,"Dados cadatrados com sucesso");
        
        txtnome.setText("");
        txtlogin.setText("");
        txtsenha.setText("");
        jcbNivel.setSelectedIndex(0);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jpCadastrarUsuario = new javax.swing.JPanel();
        jLnome = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLlogin = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        jLsenha = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        jcbNivel = new javax.swing.JComboBox();
        jLtipo = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLdadoscelula1 = new javax.swing.JLabel();
        jLdadoscelula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setExtendedState(100);
        setFocusCycleRoot(false);
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(350, 50));
        setModalExclusionType(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(85, 153, 151));

        jpCadastrarUsuario.setBackground(new java.awt.Color(204, 204, 204));
        jpCadastrarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpCadastrarUsuario.setAlignmentX(1.0F);
        jpCadastrarUsuario.setAutoscrolls(true);

        jLnome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLnome.setText("NOME COMPLETO:");

        txtnome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });

        jLlogin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLlogin.setText("LOGIN:");

        jLsenha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLsenha.setText("SENHA:");

        jcbNivel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLtipo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLtipo.setText("NIVEL DE ACESSO:");

        btCadastrar.setBackground(new java.awt.Color(204, 204, 204));
        btCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar1.jpg"))); // NOI18N
        btCadastrar.setText("CADASTRAR");
        btCadastrar.setBorder(null);
        btCadastrar.setInheritsPopupMenu(true);
        btCadastrar.setOpaque(false);
        btCadastrar.setRequestFocusEnabled(false);
        btCadastrar.setRolloverEnabled(false);
        btCadastrar.setVerifyInputWhenFocusTarget(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btListar.setBackground(new java.awt.Color(204, 204, 204));
        btListar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Listar1.jpg"))); // NOI18N
        btListar.setText("LISTAR");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar_2.jpg"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLdadoscelula1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLdadoscelula1.setText("Dados do Usuário");

        jLdadoscelula.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLdadoscelula.setText("Cadastro de Usuários");

        javax.swing.GroupLayout jpCadastrarUsuarioLayout = new javax.swing.GroupLayout(jpCadastrarUsuario);
        jpCadastrarUsuario.setLayout(jpCadastrarUsuarioLayout);
        jpCadastrarUsuarioLayout.setHorizontalGroup(
            jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addGap(12, 12, 12))
            .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLdadoscelula))
                    .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLnome)
                            .addComponent(jLsenha)
                            .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                                    .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLlogin))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLtipo)
                                        .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLdadoscelula1)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jpCadastrarUsuarioLayout.setVerticalGroup(
            jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLdadoscelula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLdadoscelula1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLnome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlogin)
                    .addComponent(jLtipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLsenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if(ValidarCampos()){
            try {
                cadastrar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        TelaListarUsuario tu = new TelaListarUsuario();
        tu.setVisible(true);
    }//GEN-LAST:event_btListarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btListar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLdadoscelula;
    private javax.swing.JLabel jLdadoscelula1;
    private javax.swing.JLabel jLlogin;
    private javax.swing.JLabel jLnome;
    private javax.swing.JLabel jLsenha;
    private javax.swing.JLabel jLtipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jcbNivel;
    private javax.swing.JPanel jpCadastrarUsuario;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables

  
    }

    


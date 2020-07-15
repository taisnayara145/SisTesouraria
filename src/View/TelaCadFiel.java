/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ControllerTesouraria;
import Model.bean.Celula;
import Model.bean.Fiel;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 4001109296
 */
public class TelaCadFiel extends javax.swing.JFrame {
        ControllerTesouraria ct = new ControllerTesouraria();
         Fiel fiel = new Fiel();
         
    public TelaCadFiel() {
        initComponents();
        ct.PreencherJcbCelula(jcbcelula);
    }
 public boolean ValidarCampos(){
    if(!txtnome.getText().equals("")&& !txtcpf.getText().equals("")&& !jcbcelula.getSelectedItem().equals("SELECIONE")){ //campos diferentes de vazio cadastra, retorna verdadeiro
      return true;   
    }
    else { // senao, nao cadastra e exibe a mensagem
    JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txtnome.requestFocus(); //foca no campo indicado 
     } return false;
     }
 public void cadastrar()throws SQLException{
 
        fiel.setNome(txtnome.getText());
        fiel.setCpf(Integer.parseInt(txtcpf.getText()));
        fiel.setCelula((Celula) jcbcelula.getSelectedItem());
       
        ct.cadastrarFiel(fiel);
        JOptionPane.showMessageDialog(null,"Dados cadatrados com sucesso");
        
        txtnome.setText("");
        txtcpf.setText("");
        jcbcelula.setSelectedIndex(0);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPFiel = new javax.swing.JPanel();
        jpCadastrarFiel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JTextField();
        jcbcelula = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLdadoscelula1 = new javax.swing.JLabel();
        jLdadoscelula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Fiel");
        setLocation(new java.awt.Point(350, 50));
        setResizable(false);

        jPFiel.setBackground(new java.awt.Color(85, 153, 151));

        jpCadastrarFiel.setBackground(new java.awt.Color(204, 204, 204));
        jpCadastrarFiel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpCadastrarFiel.setPreferredSize(new java.awt.Dimension(722, 295));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("NOME COMPLETO:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jcbcelula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbcelula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("CÉLULA:");

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
        jLdadoscelula1.setText("Dados do Fiel");

        jLdadoscelula.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLdadoscelula.setText("Cadastro de Fiéis");

        javax.swing.GroupLayout jpCadastrarFielLayout = new javax.swing.GroupLayout(jpCadastrarFiel);
        jpCadastrarFiel.setLayout(jpCadastrarFielLayout);
        jpCadastrarFielLayout.setHorizontalGroup(
            jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                        .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jLdadoscelula))
                            .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                                            .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jcbcelula, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 149, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLdadoscelula1)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jpCadastrarFielLayout.setVerticalGroup(
            jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarFielLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLdadoscelula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLdadoscelula1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbcelula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jpCadastrarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPFielLayout = new javax.swing.GroupLayout(jPFiel);
        jPFiel.setLayout(jPFielLayout);
        jPFielLayout.setHorizontalGroup(
            jPFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
            .addGroup(jPFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPFielLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpCadastrarFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPFielLayout.setVerticalGroup(
            jPFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
            .addGroup(jPFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPFielLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpCadastrarFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPFiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
 
        if(ValidarCampos()){
     try {
         cadastrar();
     } catch (SQLException ex) {
         Logger.getLogger(TelaCadFiel.class.getName()).log(Level.SEVERE, null, ex);
     }
    } 
 
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
    TelaListarFiel tf = new TelaListarFiel();
    tf.setVisible(true);
    }//GEN-LAST:event_btListarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btListar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLdadoscelula;
    private javax.swing.JLabel jLdadoscelula1;
    private javax.swing.JPanel jPFiel;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jcbcelula;
    private javax.swing.JPanel jpCadastrarFiel;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    
}

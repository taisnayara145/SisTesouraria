/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ControllerTesouraria;
import Model.bean.Prestador;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 4001109296
 */
public class TelaCadPrestador extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadUsuario
     */
    public TelaCadPrestador() {
        initComponents();
    }

    public void cadastrar() throws SQLException{
       Prestador prestador= new Prestador();
        prestador.setNome(txtnome.getText());
        prestador.setId(Integer.parseInt(txtid.getText()));
        
        ControllerTesouraria ct= new ControllerTesouraria();
        ct.cadastrarPrestador(prestador);
        JOptionPane.showMessageDialog(null,"Dados cadatrados com sucesso");
        
        txtnome.setText("");
        txtid.setText("");
        
    }
     public boolean validarCampos(){
    if(txtnome.getText().equals("")&&(txtid.getText().equals(""))){
         JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txtnome.requestFocus();
        
    }
    return true;
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPPrestador = new javax.swing.JPanel();
        jpCadastrarPrestador = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLdadoscelula = new javax.swing.JLabel();
        jLdadoscelula1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Prestador");
        setLocation(new java.awt.Point(350, 50));
        setResizable(false);

        jPPrestador.setBackground(new java.awt.Color(85, 153, 151));
        jPPrestador.setPreferredSize(new java.awt.Dimension(750, 330));

        jpCadastrarPrestador.setBackground(new java.awt.Color(204, 204, 204));
        jpCadastrarPrestador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpCadastrarPrestador.setPreferredSize(new java.awt.Dimension(722, 295));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("NOME/EMPRESA:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("C.P.F/C.N.P.J:");

        btCadastrar.setBackground(new java.awt.Color(204, 204, 204));
        btCadastrar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar1.jpg"))); // NOI18N
        btCadastrar.setText("CADASTRAR");
        btCadastrar.setBorder(null);
        btCadastrar.setInheritsPopupMenu(true);
        btCadastrar.setOpaque(false);
        btCadastrar.setPreferredSize(new java.awt.Dimension(116, 27));
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

        jLdadoscelula.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLdadoscelula.setText("Cadastro de Prestadores");

        jLdadoscelula1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLdadoscelula1.setText("Dados do Prestador");

        javax.swing.GroupLayout jpCadastrarPrestadorLayout = new javax.swing.GroupLayout(jpCadastrarPrestador);
        jpCadastrarPrestador.setLayout(jpCadastrarPrestadorLayout);
        jpCadastrarPrestadorLayout.setHorizontalGroup(
            jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarPrestadorLayout.createSequentialGroup()
                .addGap(0, 55, Short.MAX_VALUE)
                .addGroup(jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarPrestadorLayout.createSequentialGroup()
                        .addGroup(jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jpCadastrarPrestadorLayout.createSequentialGroup()
                                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btListar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarPrestadorLayout.createSequentialGroup()
                        .addComponent(jLdadoscelula)
                        .addGap(200, 200, 200))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarPrestadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLdadoscelula1)
                .addGap(275, 275, 275))
        );
        jpCadastrarPrestadorLayout.setVerticalGroup(
            jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarPrestadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLdadoscelula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLdadoscelula1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jpCadastrarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPPrestadorLayout = new javax.swing.GroupLayout(jPPrestador);
        jPPrestador.setLayout(jPPrestadorLayout);
        jPPrestadorLayout.setHorizontalGroup(
            jPPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrestadorLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jpCadastrarPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPPrestadorLayout.setVerticalGroup(
            jPPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrestadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
           if(validarCampos()){
               try {
                   cadastrar();
               } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, ex);
               }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
      TelaListarPrestador tp = new TelaListarPrestador();
      tp.setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLdadoscelula;
    private javax.swing.JLabel jLdadoscelula1;
    private javax.swing.JPanel jPPrestador;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel jpCadastrarPrestador;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

   
}

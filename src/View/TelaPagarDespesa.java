/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ControllerTesouraria;
import Model.bean.Despesa;
import Model.bean.Movimento;
import Model.bean.Pagamento;
import Model.bean.Usuario;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 4001109296
 */
public class TelaPagarDespesa extends javax.swing.JFrame {
    ControllerTesouraria ct= new ControllerTesouraria();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    Usuario usuariolbn;

    Usuario usuario = new Usuario();
    Pagamento pagamento= new Pagamento();
    Despesa despesa= new Despesa();
    Movimento movimento = new Movimento();

     public boolean ValidarCampos(){
    if(!txttitulo.getText().equals("")&& !jcbDespesa.getSelectedItem().equals("SELECIONE")&& !txthora1.getText().equals("")&& !txtvalor.getText().equals("")){ 
      return true;   
    }
    else { // senao, nao cadastra e exibe a mensagem
    JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txttitulo.requestFocus(); //foca no campo indicado 
     } return false;
     }
   
    public void pagar() throws SQLException{
        
        usuario.setCodigo(usuariolbn.getCodigo());
        pagamento.setUsuario(usuario);
        pagamento.setDespesa((Despesa) jcbDespesa.getSelectedItem());
        pagamento.setTitulo(txttitulo.getText());
        pagamento.setValor(Double.parseDouble(txtvalor.getText()));
        pagamento.setData(new java.sql.Date(jdcDataPagamento.getDate().getTime()));
        pagamento.setHora(txthora.getText());
        movimento.setCodigo(1); // receita.saldofinal
        pagamento.setMovimento(movimento);
        ct.cadastrarPagamento(pagamento);
        JOptionPane.showMessageDialog(null,"Despesa paga com sucesso");
        
       
        jcbDespesa.setSelectedIndex(0);
        txtvalor.setText("");
       
  
   }
    public TelaPagarDespesa(Usuario usuario) {
        initComponents();
      ct.PreencherJcbDespesa(jcbDespesa);
        txthora1.setText(sdf.format(Calendar.getInstance().getTime()));
           this.usuariolbn = usuario;
       
        lbusuario.setText("Usuário: " +usuario.getLogin());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancelar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txthora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpCadastrarDespesa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jdcDataPagamento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jcbDespesa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        btCancelar1 = new javax.swing.JButton();
        btListar1 = new javax.swing.JButton();
        btCadastrar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txthora1 = new javax.swing.JLabel();
        lbusuario = new javax.swing.JLabel();

        btCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar_2.jpg"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("HORA DO SERVICO:");

        txthora.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Pagar Despesa");
        setBackground(new java.awt.Color(85, 153, 151));

        jPanel2.setBackground(new java.awt.Color(85, 153, 151));

        jpCadastrarDespesa.setBackground(new java.awt.Color(204, 204, 204));
        jpCadastrarDespesa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Dados de saida");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Pagar Despesa");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("DATA:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("TITULO:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("VALOR DA DESPESA:");

        jcbDespesa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbDespesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("DESPESA:");

        btCancelar1.setBackground(new java.awt.Color(204, 204, 204));
        btCancelar1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar_2.jpg"))); // NOI18N
        btCancelar1.setText("CANCELAR");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        btListar1.setBackground(new java.awt.Color(204, 204, 204));
        btListar1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btListar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Listar1.jpg"))); // NOI18N
        btListar1.setText("LISTAR");
        btListar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListar1ActionPerformed(evt);
            }
        });

        btCadastrar1.setBackground(new java.awt.Color(204, 204, 204));
        btCadastrar1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar1.jpg"))); // NOI18N
        btCadastrar1.setText("PAGAR");
        btCadastrar1.setBorder(null);
        btCadastrar1.setInheritsPopupMenu(true);
        btCadastrar1.setOpaque(false);
        btCadastrar1.setRequestFocusEnabled(false);
        btCadastrar1.setRolloverEnabled(false);
        btCadastrar1.setVerifyInputWhenFocusTarget(false);
        btCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrar1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("HORA DO SERVICO:");

        txthora1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lbusuario.setText("Usuário:");

        javax.swing.GroupLayout jpCadastrarDespesaLayout = new javax.swing.GroupLayout(jpCadastrarDespesa);
        jpCadastrarDespesa.setLayout(jpCadastrarDespesaLayout);
        jpCadastrarDespesaLayout.setHorizontalGroup(
            jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtvalor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcDataPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthora1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2))
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jLabel1)))
                .addGap(136, 136, 136))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarDespesaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btListar1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar1)
                .addGap(19, 19, 19))
        );
        jpCadastrarDespesaLayout.setVerticalGroup(
            jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addComponent(lbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastrarDespesaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthora1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        TelaListarCelula tc= new TelaListarCelula();
        tc.setVisible(true);
    }//GEN-LAST:event_btListarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
      
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btListar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListar1ActionPerformed
        TelaListarPDespesa tc= new TelaListarPDespesa(usuariolbn);
        tc.setVisible(true);
    }//GEN-LAST:event_btListar1ActionPerformed

    private void btCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrar1ActionPerformed
        if(ValidarCampos()){
            try {
                pagar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaPagarDespesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCadastrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCadastrar1;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btListar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jcbDespesa;
    private com.toedter.calendar.JDateChooser jdcDataPagamento;
    private javax.swing.JPanel jpCadastrarDespesa;
    private javax.swing.JLabel lbusuario;
    private javax.swing.JLabel txthora;
    private javax.swing.JLabel txthora1;
    private javax.swing.JTextField txttitulo;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}

package View;

import Control.ControllerTesouraria;
import Model.bean.Fiel;
import Model.bean.Movimento;
import Model.bean.Receita;
import Model.bean.Tipo;
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
public class TelaReceita extends javax.swing.JFrame {
     ControllerTesouraria ct= new ControllerTesouraria();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    Usuario usuariolbn;
    Receita receita= new Receita();
    Usuario usuario = new Usuario();  
    Movimento movimento= new Movimento();
           
    public TelaReceita(Usuario usuario) {
        initComponents();
         this.usuariolbn = usuario;
       
        lbusuario.setText("Usuário: " +usuario.getLogin());
       

        ct.PreencherJcbTipo(jcbTipo);
        ct.PreencherJcbFiel(jcbFiel);
        txthora.setText(sdf.format(Calendar.getInstance().getTime()));
        
        
    }    
     public boolean ValidarCampos(){
    if(!txttitulo.getText().equals("")&& !jcbFiel.getSelectedItem().equals("SELECIONE")&& !txthora.getText().equals("")&& !txtvalor.getText().equals("")&& !jcbTipo.getSelectedItem().equals("SELECIONE")){ 
      return true;   
    }
    else { // senao, nao cadastra e exibe a mensagem
    JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txttitulo.requestFocus(); //foca no campo indicado 
     } return false;
     }

      public void realizar() throws SQLException{
  
        usuario.setCodigo(usuariolbn.getCodigo());
        receita.setUsuario(usuario);
        receita.setTitulo(txttitulo.getText());
        receita.setFiel((Fiel) jcbFiel.getSelectedItem());
        receita.setData(new java.sql.Date(jdcDataReceita.getDate().getTime()));
        receita.setHora(txthora.getText());
        receita.setValor(Double.parseDouble(txtvalor.getText()));
        receita.setTipo((Tipo) jcbTipo.getSelectedItem());
        movimento.setCodigo(1);
        receita.setMovimento(movimento);
      
      
        ct.cadastrarReceita(receita);
        JOptionPane.showMessageDialog(null,"Receita realizada com sucesso");
        
        txttitulo.setText("");
        jcbFiel.setSelectedIndex(0);
     
        txtvalor.setText("");
        jcbTipo.setSelectedIndex(0);
  
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jpCadastrarReceita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbFiel = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jdcDataReceita = new com.toedter.calendar.JDateChooser();
        txthora = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        lbusuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Realizar Receita");
        setLocation(new java.awt.Point(350, 50));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(85, 153, 151));

        jpCadastrarReceita.setBackground(new java.awt.Color(204, 204, 204));
        jpCadastrarReceita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Dados de entrada");

        jcbTipo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("TIPO:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("VALOR:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("DATA:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("TITULO:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("HORA:");

        jcbFiel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbFiel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("NOME DO FIEL:");

        txthora.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Receitas");

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
        btCadastrar.setText("REALIZAR");
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

        lbusuario.setText("Usuário:");

        javax.swing.GroupLayout jpCadastrarReceitaLayout = new javax.swing.GroupLayout(jpCadastrarReceita);
        jpCadastrarReceita.setLayout(jpCadastrarReceitaLayout);
        jpCadastrarReceitaLayout.setHorizontalGroup(
            jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarReceitaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttitulo)
                    .addComponent(jcbFiel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addGroup(jpCadastrarReceitaLayout.createSequentialGroup()
                        .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130)
                        .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpCadastrarReceitaLayout.createSequentialGroup()
                                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jdcDataReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73)))))
                .addGap(162, 162, 162))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarReceitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarReceitaLayout.createSequentialGroup()
                        .addComponent(lbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(316, 316, 316))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastrarReceitaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addGap(39, 39, 39))))
            .addGroup(jpCadastrarReceitaLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCadastrarReceitaLayout.setVerticalGroup(
            jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarReceitaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbFiel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcDataReceita, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txthora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jpCadastrarReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastrarReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          
    }//GEN-LAST:event_formWindowOpened

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        TelaListarReceita tc= new TelaListarReceita(usuariolbn);
        tc.setVisible(true);
    }//GEN-LAST:event_btListarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if(ValidarCampos()){
            try {
                realizar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaReceita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jcbFiel;
    private javax.swing.JComboBox jcbTipo;
    private com.toedter.calendar.JDateChooser jdcDataReceita;
    private javax.swing.JPanel jpCadastrarReceita;
    private javax.swing.JLabel lbusuario;
    private javax.swing.JLabel txthora;
    private javax.swing.JTextField txttitulo;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables

  


}


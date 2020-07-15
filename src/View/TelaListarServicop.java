/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ControllerTesouraria;
import Model.bean.Prestador;
import Model.bean.Servico;
import Model.dao.ServicoDao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class TelaListarServicop extends javax.swing.JFrame {
     DefaultTableModel dtmServicop = new DefaultTableModel(null, new String[]{"Código","Titulo","Data do serviço","Hora","Prestador","Serviço"});
    List <Servico> LServicop;
    ListSelectionModel lsmServicop;
    ControllerTesouraria ct= new ControllerTesouraria();
     SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    
    public void listarServicop()throws SQLException{
       ServicoDao servicodao= new ServicoDao();
         LServicop= servicodao.ListarTodos("%" + txtpesquisa.getText() + "%");
           mostraPesquisa(LServicop);
    }
    private void mostraPesquisa(List<Servico> servico){
         while(dtmServicop.getRowCount()>0){
             dtmServicop.removeRow(0);
         }
         if(servico.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum serviço cadastrado");
        }else{
            String[] linhas=new String[]{null,null,null,null};
            for(int i = 0; i<servico.size(); i++){
                dtmServicop.addRow(linhas);
                 dtmServicop.setValueAt(servico.get(i).getCodigo(), i, 0);
                  dtmServicop.setValueAt(servico.get(i).getTitulo(), i, 1);
                 dtmServicop.setValueAt(servico.get(i).getDescricao(),i,2);
                 dtmServicop.setValueAt(servico.get(i).getData(), i, 3);
                 dtmServicop.setValueAt(servico.get(i).getHora(),i,4);
                 dtmServicop.setValueAt(servico.get(i).getPrestador().getNome(),i,5);
                 

            }
         }  
     }
    
    private void linhaselecionada(JTable tabela){
         if(jtServicop.getSelectedRow()!= -1){
            txtcodigo.setText(String.valueOf(LServicop.get(tabela.getSelectedRow()).getCodigo()));
            jcbServico.setSelectedItem(String.valueOf(LServicop.get(tabela.getSelectedRow()).getDescricao()));
            txttitulo.setText(LServicop.get(tabela.getSelectedRow()).getTitulo());
            txthora.setText((LServicop.get(tabela.getSelectedRow()).getHora()));
          
           
     }else{
            txtcodigo.setText("");
            txttitulo.setText("");
            txthora.setText("");
            jcbPrestador.setSelectedIndex(0);
            jcbServico.setSelectedIndex(0);
           
         }
     }
      public boolean ValidarCampos(){
    if(!txttitulo.getText().equals("")&& !txthora.getText().equals("")&& !jcbPrestador.getSelectedItem().equals("SELECIONE")&& !jcbServico.getSelectedItem().equals("SELECIONE")){ 
      return true;   
    }
    else { // senao, nao cadastra e exibe a mensagem
    JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txttitulo.requestFocus();
     } return false;
     }
      public void alterar() throws SQLException{
    if(jtServicop.getSelectedRow()!=-1){
   Servico servico=new Servico();
    
        servico.setCodigo(Integer.parseInt(txtcodigo.getText()));
        servico.setTitulo(txttitulo.getText());
        servico.setDescricao((String) jcbServico.getSelectedItem());
        servico.setData(new java.sql.Date(jdcDataServico.getDate().getTime()));
        servico.setHora(txthora.getText());
        servico.setPrestador((Prestador) jcbPrestador.getSelectedItem());

        ct.alterarServicosp(servico);
        JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        
        txttitulo.setText("");
        txthora.setText("");
        jcbPrestador.setSelectedIndex(0);
        jcbServico.setSelectedIndex(0);
}}
   public void excluir(){
       int resposta= JOptionPane.showConfirmDialog(this, "Deseja realmente excluir dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
         if(resposta==JOptionPane.YES_NO_OPTION){
            ct= new ControllerTesouraria();
            try{
                ct.excluirServicosp(LServicop.get(jtServicop.getSelectedRow()));
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso ");
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Não é possivel excluir o serviço");
            }
         }
   }
    public TelaListarServicop() {
        initComponents();
        ct.PreencherJcbPrestador(jcbPrestador);
         txthora.setText(sdf.format(Calendar.getInstance().getTime()));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtServicop = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        btExcluir1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btAlterar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcbPrestador = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jcbServico = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcDataServico = new com.toedter.calendar.JDateChooser();
        txttitulo = new javax.swing.JTextField();
        txthora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();

        btCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar_2.jpg"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.setMargin(null);
        btCancelar.setPreferredSize(new java.awt.Dimension(125, 41));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lexeiramenor.jpg"))); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.setMargin(null);
        btExcluir.setMaximumSize(null);
        btExcluir.setMinimumSize(null);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar Fiel\n");
        setLocation(new java.awt.Point(350, 10));

        jPanel3.setBackground(new java.awt.Color(85, 153, 151));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtServicop.setModel(dtmServicop);
        jtServicop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmServicop =jtServicop.getSelectionModel();
        lsmServicop.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    linhaselecionada(jtServicop);
                }
            }
        });
        jScrollPane1.setViewportView(jtServicop);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("DIGITE O NOME PARA PESQUISAR:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Listar Serviços ");

        btPesquisar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.jpg"))); // NOI18N
        btPesquisar.setText("  PESQUISAR");
        btPesquisar.setBorder(null);
        btPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btPesquisar.setMargin(null);
        btPesquisar.setVerifyInputWhenFocusTarget(false);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btCancelar1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar_2.jpg"))); // NOI18N
        btCancelar1.setText("CANCELAR");
        btCancelar1.setMargin(null);
        btCancelar1.setPreferredSize(new java.awt.Dimension(125, 41));
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        btExcluir1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lexeiramenor.jpg"))); // NOI18N
        btExcluir1.setText("EXCLUIR");
        btExcluir1.setMargin(null);
        btExcluir1.setMaximumSize(null);
        btExcluir1.setMinimumSize(null);
        btExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluir1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alterar Serviço"));

        btAlterar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.jpg"))); // NOI18N
        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("DATA DO SERVIÇO:");

        jcbPrestador.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbPrestador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("PRESTADOR:");

        jcbServico.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbServico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", "Agua", "Luz", "Internet", "Ar condicionado" }));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("TIPO DO SERVIÇO:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("TITULO:");

        txthora.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("HORA DO SERVICO:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("CÓDIGO:");

        txtcodigo.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btAlterar)
                        .addGap(272, 272, 272))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jcbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(77, 77, 77))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(156, 156, 156))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jdcDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addComponent(jcbPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbServico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAlterar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
try {
            listarServicop();
        } catch (SQLException ex) {
            Logger.getLogger(TelaListarPrestador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluir1ActionPerformed
        excluir();
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluir1ActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(ValidarCampos()){
        try{
            alterar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btExcluir1;
    private javax.swing.JButton btPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jcbPrestador;
    private javax.swing.JComboBox jcbServico;
    private com.toedter.calendar.JDateChooser jdcDataServico;
    private javax.swing.JTable jtServicop;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JLabel txthora;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}

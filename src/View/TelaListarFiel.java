/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Control.ControllerTesouraria;
import Model.bean.Celula;
import Model.bean.Fiel;
import Model.dao.FielDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TelaListarFiel extends javax.swing.JFrame {
    DefaultTableModel dtmFiel = new DefaultTableModel(null, new String[]{"Nome","CPF","Celula"});
    List <Fiel> LFiel;
    ListSelectionModel lsmFiel;
    ControllerTesouraria ct= new ControllerTesouraria();
    
    public TelaListarFiel() {
        initComponents();
        ct.PreencherJcbCelula(jcbcelula);
    }
   public void listarFiel()throws SQLException{
        FielDao fieldao= new FielDao();
         LFiel= fieldao.ListarTodos("%" + txtpesquisa.getText() + "%");
           mostraPesquisa(LFiel);
    }
     private void mostraPesquisa(List<Fiel> fiel){
         while(dtmFiel.getRowCount()>0){
             dtmFiel.removeRow(0);
         }
         if(fiel.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum fiel cadastrado");
        }else{
            String[] linhas=new String[]{null,null,null,null};
            for(int i = 0; i<fiel.size(); i++){
                dtmFiel.addRow(linhas);
                 dtmFiel.setValueAt(fiel.get(i).getCpf(), i, 0);
                 dtmFiel.setValueAt(fiel.get(i).getNome(), i, 1);
                 dtmFiel.setValueAt(fiel.get(i).getCelula().getNome(), i, 2);
                
                 
            }
         }  
     }
     private void linhaselecionada(JTable tabela){
         if(jtFiel.getSelectedRow()!= -1){
            txtnome.setText(LFiel.get(tabela.getSelectedRow()).getNome());
            txtcpf.setText(String.valueOf(LFiel.get(tabela.getSelectedRow()).getCpf()));
            jcbcelula.setSelectedItem(String.valueOf(LFiel.get(tabela.getSelectedRow()).getCelula()));
           
     }else{
           
            txtnome.setText("");
            txtcpf.setText("");
            jcbcelula.setSelectedIndex(0);
           
         }
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
    
     public void alterar() throws SQLException{
    if(jtFiel.getSelectedRow()!=-1){
     Fiel fiel= new Fiel();
       
       fiel.setNome(txtnome.getText());
        fiel.setCpf(Integer.parseInt(txtcpf.getText()));
        fiel.setCelula((Celula) jcbcelula.getSelectedItem());
  
        ct.alterarFiel(fiel);
        JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        
       
        txtnome.setText("");
        txtcpf.setText("");
        jcbcelula.setSelectedIndex(0);
}}
     private void excluir() {
        int resposta= JOptionPane.showConfirmDialog(this, "Deseja realmente excluir dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
         if(resposta==JOptionPane.YES_NO_OPTION){
            ct= new ControllerTesouraria();
            try{
                ct.excluirFiel(LFiel.get(jtFiel.getSelectedRow()));
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso ");
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erro"+e);
            }
         }   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPListarFiel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFiel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtcpf = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbcelula = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        btExcluir1 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar Fiel\n");
        setLocation(new java.awt.Point(350, 10));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(85, 153, 151));

        jPListarFiel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("DIGITE O NOME PARA PESQUISAR:");

        jtFiel.setModel(dtmFiel);
        jtFiel= new javax.swing.JTable();

        jtFiel.setModel(dtmFiel);
        jtFiel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmFiel =jtFiel.getSelectionModel();
        lsmFiel.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    linhaselecionada(jtFiel);
                }
            }
        });
        jScrollPane1.setViewportView(jtFiel);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Listar Fiel");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alterar Fiel"));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("NOME COMPLETO:");

        jcbcelula.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbcelula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("CÉLULA:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("CPF:");

        btAlterar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.jpg"))); // NOI18N
        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(btAlterar)
                            .addComponent(jcbcelula, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(txtnome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbcelula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPListarFielLayout = new javax.swing.GroupLayout(jPListarFiel);
        jPListarFiel.setLayout(jPListarFielLayout);
        jPListarFielLayout.setHorizontalGroup(
            jPListarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListarFielLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(279, 279, 279))
            .addGroup(jPListarFielLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpesquisa)
                .addGap(22, 22, 22)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPListarFielLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPListarFielLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPListarFielLayout.createSequentialGroup()
                .addGroup(jPListarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPListarFielLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPListarFielLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPListarFielLayout.setVerticalGroup(
            jPListarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPListarFielLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPListarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPListarFielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPListarFielLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btExcluir1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPListarFiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPListarFiel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            listarFiel();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPListarFiel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jcbcelula;
    private javax.swing.JTable jtFiel;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables

   
}

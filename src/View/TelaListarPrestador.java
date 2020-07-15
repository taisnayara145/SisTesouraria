/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Control.ControllerTesouraria;
import Model.bean.Prestador;
import Model.dao.PrestadorDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author admin
 */
public class TelaListarPrestador extends javax.swing.JFrame {
    
    DefaultTableModel dtmPrestador = new DefaultTableModel(null, new String[]{"Nome/Empresa","CPF/CNPJ"});
    List <Prestador> LPrestador;
    ListSelectionModel lsmPrestador;
    ControllerTesouraria ct= new ControllerTesouraria();
    ResultSet rs;
    
    public TelaListarPrestador() {
        initComponents();
    }
 public void listarPrestador()throws SQLException{
        PrestadorDao prestadordao= new PrestadorDao();
         LPrestador= prestadordao.ListarTodos("%" + txtpesquisa.getText() + "%");
           mostraPesquisa(LPrestador);
    }
     private void mostraPesquisa(List<Prestador> prestador){
         while(dtmPrestador.getRowCount()>0){
             dtmPrestador.removeRow(0);
         }
         if(prestador.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum prestador cadastrado");
        }else{
            String[] linhas=new String[]{null,null,null};
            for(int i = 0; i<prestador.size(); i++){
                dtmPrestador.addRow(linhas);
                 dtmPrestador.setValueAt(prestador.get(i).getNome(), i, 0);
                 dtmPrestador.setValueAt(prestador.get(i).getId(), i, 1);
            }
         }  
     }
     public void linhaselecionada(JTable tabela){
         if(jtPrestador.getSelectedRow()!= -1){
            
             txtnome.setText(LPrestador.get(tabela.getSelectedRow()).getNome());
             txtid.setText(String.valueOf(LPrestador.get(tabela.getSelectedRow()).getId()));
             
         }else{
            
             txtnome.setText("");
             txtid.setText("");
         }
     }
     public boolean validarCampos(){
    if(txtnome.getText().equals("")&&(txtid.getText().equals(""))){
         JOptionPane.showMessageDialog(this, "Preencher os campos obrigatórios!");
         txtnome.requestFocus();
        
    }
    return true;
     }
    public void alterar() throws SQLException{
    if(jtPrestador.getSelectedRow()!=-1){
     Prestador prestador= new Prestador();
      
       prestador.setNome(txtnome.getText());
        prestador.setId(Integer.parseInt(txtid.getText()));
       
  
        ct.alterarPrestador(prestador);
        JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        
     
        txtnome.setText("");
        txtid.setText("");
    }
    }
     private void excluir() {
    int resposta= JOptionPane.showConfirmDialog(this, "Deseja realmente excluir dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
         if(resposta==JOptionPane.YES_NO_OPTION){
            ct= new ControllerTesouraria();
            try{
                ct.excluirPrestador(LPrestador.get(jtPrestador.getSelectedRow()));
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso ");
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erro"+e);
            }
         }   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListarPrestador = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        jPanelAlterar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btAlterar = new javax.swing.JButton();
        txtnome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPrestador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 10));

        jPanelListarPrestador.setBackground(new java.awt.Color(85, 153, 151));
        jPanelListarPrestador.setMaximumSize(null);
        jPanelListarPrestador.setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(659, 590));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Listar Prestador");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("DIGITE O NOME PARA PESQUISAR:");

        jPanelAlterar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelAlterar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alterar Prestador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("NOME/EMPRESA:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("C.P.F./CNPJ:");

        btAlterar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.jpg"))); // NOI18N
        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlterarLayout = new javax.swing.GroupLayout(jPanelAlterar);
        jPanelAlterar.setLayout(jPanelAlterarLayout);
        jPanelAlterarLayout.setHorizontalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(480, 480, 480))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                                .addComponent(btAlterar)
                                .addGap(216, 216, 216))))
                    .addGroup(jPanelAlterarLayout.createSequentialGroup()
                        .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelAlterarLayout.setVerticalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
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

        jtPrestador.setModel(dtmPrestador);
        jtPrestador= new javax.swing.JTable();
        jtPrestador.setModel(dtmPrestador);
        jtPrestador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmPrestador =jtPrestador.getSelectionModel();
        lsmPrestador.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    linhaselecionada(jtPrestador);
                }
            }
        });
        jScrollPane1.setViewportView(jtPrestador);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelListarPrestadorLayout = new javax.swing.GroupLayout(jPanelListarPrestador);
        jPanelListarPrestador.setLayout(jPanelListarPrestadorLayout);
        jPanelListarPrestadorLayout.setHorizontalGroup(
            jPanelListarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarPrestadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelListarPrestadorLayout.setVerticalGroup(
            jPanelListarPrestadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarPrestadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListarPrestador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelListarPrestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(validarCampos()){
        try {
            alterar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaListarPrestador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            listarPrestador();
        } catch (SQLException ex) {
            Logger.getLogger(TelaListarPrestador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        excluir();
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAlterar;
    private javax.swing.JPanel jPanelListarPrestador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPrestador;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables

  
}

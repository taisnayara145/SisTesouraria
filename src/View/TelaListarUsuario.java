package View;


import Control.ControllerTesouraria;
import Model.bean.NivelAcesso;
import Model.bean.Usuario;
import Model.dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TelaListarUsuario extends javax.swing.JFrame {
    
    DefaultTableModel dtmUsuario = new DefaultTableModel(null, new String[]{"Código","Nome","Login","Nivel"});
    List <Usuario> LUsuarios;
    ListSelectionModel lsmUsuario;
    ControllerTesouraria ct= new ControllerTesouraria();
    
    public TelaListarUsuario() {
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
       private void excluir() {
    
        int resposta= JOptionPane.showConfirmDialog(this, "Deseja realmente excluir dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
         if(resposta==JOptionPane.YES_NO_OPTION){
            ct= new ControllerTesouraria();
            try{
                ct.excluirUsuario(LUsuarios.get(jtUsuario.getSelectedRow()));
                  JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso ");
                  
       
        
        txtpesquisa.setText("");
        txtcodigo.setText("");
        txtnome.setText("");
        txtlogin.setText("");
        txtsenha.setText("");
        jcbNivel.setSelectedIndex(0);
                  
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"erro"+e);
            }
         }        
    }
    
        public void listarUsuario()throws SQLException{
        UsuarioDao usuariodao= new UsuarioDao();
         LUsuarios= usuariodao.ListarTodos("%" + txtpesquisa.getText() + "%");
           mostraPesquisa(LUsuarios);
    }
     private void mostraPesquisa(List<Usuario> usuario){
         while(dtmUsuario.getRowCount()>0){
             dtmUsuario.removeRow(0);
         }
         if(usuario.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado");
        }else{
            String[] linhas=new String[]{null,null,null,null};
            for(int i = 0; i<usuario.size(); i++){
                dtmUsuario.addRow(linhas);
                 dtmUsuario.setValueAt(usuario.get(i).getCodigo(), i, 0);
                 dtmUsuario.setValueAt(usuario.get(i).getNome(), i, 1);
                 dtmUsuario.setValueAt(usuario.get(i).getLogin(), i, 2);
                 dtmUsuario.setValueAt(usuario.get(i).getNivel().getDescricao(), i, 3);
                
                 
            }
         }  
     }
     private void linhaselecionada(JTable tabela){
         if(jtUsuario.getSelectedRow()!= -1){
            txtcodigo.setText(String.valueOf(LUsuarios.get(tabela.getSelectedRow()).getCodigo()));
            txtnome.setText(LUsuarios.get(tabela.getSelectedRow()).getNome());
            txtlogin.setText((LUsuarios.get(tabela.getSelectedRow()).getLogin()));
            jcbNivel.setSelectedItem(String.valueOf(LUsuarios.get(tabela.getSelectedRow()).getNivel()));
           
     }else{
            txtcodigo.setText("");
            txtnome.setText("");
            txtlogin.setText("");
            jcbNivel.setSelectedIndex(0);
           
         }
     }
 
     public void alterar() throws SQLException{
    if(jtUsuario.getSelectedRow()!=-1){
    Usuario usuario= new Usuario();
       usuario.setCodigo(Integer.parseInt(txtcodigo.getText()));
       usuario.setNome(txtnome.getText());
        usuario.setLogin(txtlogin.getText());
        usuario.setSenha(txtsenha.getText());
        usuario.setNivel((NivelAcesso) jcbNivel.getSelectedItem());
  
        ct.alterarUsuario(usuario);
        JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
        
        txtcodigo.setText("");
        txtnome.setText("");
        txtlogin.setText("");
        txtsenha.setText("");
        jcbNivel.setSelectedIndex(0);
}
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelFundo = new javax.swing.JPanel();
        jPListarUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanelAlterar = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jcbNivel = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTAR USUÁRIO");
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(350, 10));
        setResizable(false);

        jPanelFundo.setBackground(new java.awt.Color(85, 153, 151));
        jPanelFundo.setMaximumSize(null);
        jPanelFundo.setPreferredSize(new java.awt.Dimension(668, 710));

        jPListarUsuario.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel2.setText("Listar Usuário");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("DIGITE O NOME PARA PESQUISAR:");

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

        jtUsuario.setModel(dtmUsuario);
        jtUsuario= new javax.swing.JTable();

        jtUsuario.setModel(dtmUsuario);
        jtUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmUsuario =jtUsuario.getSelectionModel();
        lsmUsuario.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    linhaselecionada(jtUsuario);
                }
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

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

        jPanelAlterar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelAlterar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alterar Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        txtcodigo.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("CÓDIGO:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("NOME COMPLETO:");

        jcbNivel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("LOGIN:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("TIPO DE ACESSO:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("NOVA SENHA:");

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
                    .addGroup(jPanelAlterarLayout.createSequentialGroup()
                        .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcodigo))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAlterarLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtnome)))
                    .addGroup(jPanelAlterarLayout.createSequentialGroup()
                        .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanelAlterarLayout.createSequentialGroup()
                                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addGap(230, 230, 230))
        );
        jPanelAlterarLayout.setVerticalGroup(
            jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPListarUsuarioLayout = new javax.swing.GroupLayout(jPListarUsuario);
        jPListarUsuario.setLayout(jPListarUsuarioLayout);
        jPListarUsuarioLayout.setHorizontalGroup(
            jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                .addGroup(jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListarUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPListarUsuarioLayout.setVerticalGroup(
            jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPListarUsuarioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
        jPanelFundo.setLayout(jPanelFundoLayout);
        jPanelFundoLayout.setHorizontalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPListarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelFundoLayout.setVerticalGroup(
            jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPListarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        excluir();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            // TODO add your handling code here:
            listarUsuario();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        if(ValidarCampos()){
        try{
            alterar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }}
    }//GEN-LAST:event_btAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPListarUsuario;
    private javax.swing.JPanel jPanelAlterar;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JComboBox jcbNivel;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables


    
    
}

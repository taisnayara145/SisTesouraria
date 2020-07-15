/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Relatorios.GerarRelatorioCelula;
import Relatorios.GerarRelatorioReceita;
import Relatorios.GerarRelatorioDespesa;
import Relatorios.GerarRelatorioGeral;
import Relatorios.GerarRelatorioPrestador;
import Relatorios.GerarRelatorioFiel;
import Model.bean.Usuario;

/**
 *
 * @author 4001109296
 */
public class TelaPrincipal extends javax.swing.JFrame {
  Usuario usuariolb;
 
    public TelaPrincipal(Usuario usuario) {
        initComponents();
       lbnivel.setText(usuario.getNivel().getDescricao());//exibe o nivel do usuario  
         lbusuario.setText(usuario.getNome());//exibe o usuario logado
         this.usuariolb = usuario;
          
         
         
           if(lbnivel.getText().equals("Tesoureiro")){
            
            jmiCadastros.setEnabled(true);
            jmiReceitas.setEnabled(true);
            jmiDespesas.setEnabled(true);
            jmRelatorios.setEnabled(true);
            
        }else{
         jmiCadastros.setEnabled(false);
            jmiReceitas.setEnabled(false);
            jmiDespesas.setEnabled(false);
            jmRelatorios.setEnabled(true);
            
        }//fim
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jLimagem = new javax.swing.JLabel();
        lbnivel = new javax.swing.JLabel();
        lbusuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiCadastros = new javax.swing.JMenu();
        jmUsuario = new javax.swing.JMenu();
        jmiCadastrarUsuario = new javax.swing.JMenuItem();
        jmiListarUsuario = new javax.swing.JMenuItem();
        jmCelula = new javax.swing.JMenu();
        jmiCadastrarCelula = new javax.swing.JMenuItem();
        jmiListarCelula = new javax.swing.JMenuItem();
        jmFiel = new javax.swing.JMenu();
        jmiCadastrarFiel = new javax.swing.JMenuItem();
        jmiListarFiel = new javax.swing.JMenuItem();
        jmPrestador = new javax.swing.JMenu();
        jmiCadastrarPrestador = new javax.swing.JMenuItem();
        jmiListarPrestador = new javax.swing.JMenuItem();
        jmServicosp = new javax.swing.JMenu();
        jmiCadastrarServicosP = new javax.swing.JMenuItem();
        jmiListarServicosP = new javax.swing.JMenuItem();
        jmiReceitas = new javax.swing.JMenu();
        jmiRealizarReceita = new javax.swing.JMenuItem();
        jmiListarReceita = new javax.swing.JMenuItem();
        jmiDespesas = new javax.swing.JMenu();
        jmiDespesa = new javax.swing.JMenuItem();
        jmiListarDespesa = new javax.swing.JMenuItem();
        jmiPagarDespesa = new javax.swing.JMenuItem();
        jMListarPagamentos = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenu();
        jmiRFieis = new javax.swing.JMenuItem();
        jmiRCelulas = new javax.swing.JMenuItem();
        jmiRPrestadores = new javax.swing.JMenuItem();
        jmiRReceitas = new javax.swing.JMenuItem();
        jmiRDespesas = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmiRGeral = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenu();

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("jMenu6");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem8.setText("jMenuItem8");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCT");
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(1177, 717));
        setResizable(false);

        jLimagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/índice.jpg"))); // NOI18N
        jLimagem.setPreferredSize(new java.awt.Dimension(1180, 661));

        lbnivel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbnivel.setText("USUÁRIO:");

        jMenuBar1.setMaximumSize(new java.awt.Dimension(350, 32769));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(330, 32));

        jmiCadastros.setText("CADASTROS");
        jmiCadastros.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jmUsuario.setText("USUÁRIO");

        jmiCadastrarUsuario.setText("CADASTRAR");
        jmiCadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarUsuarioActionPerformed(evt);
            }
        });
        jmUsuario.add(jmiCadastrarUsuario);

        jmiListarUsuario.setText("LISTAR");
        jmiListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarUsuarioActionPerformed(evt);
            }
        });
        jmUsuario.add(jmiListarUsuario);

        jmiCadastros.add(jmUsuario);

        jmCelula.setText("CÉLULA");

        jmiCadastrarCelula.setText("CADASTRAR");
        jmiCadastrarCelula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarCelulaActionPerformed(evt);
            }
        });
        jmCelula.add(jmiCadastrarCelula);

        jmiListarCelula.setText("LISTAR");
        jmiListarCelula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarCelulaActionPerformed(evt);
            }
        });
        jmCelula.add(jmiListarCelula);

        jmiCadastros.add(jmCelula);

        jmFiel.setText("FIEL");

        jmiCadastrarFiel.setText("CADASTRAR");
        jmiCadastrarFiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarFielActionPerformed(evt);
            }
        });
        jmFiel.add(jmiCadastrarFiel);

        jmiListarFiel.setText("LISTAR");
        jmiListarFiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarFielActionPerformed(evt);
            }
        });
        jmFiel.add(jmiListarFiel);

        jmiCadastros.add(jmFiel);

        jmPrestador.setText("PRESTADOR");

        jmiCadastrarPrestador.setText("CADASTRAR");
        jmiCadastrarPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarPrestadorActionPerformed(evt);
            }
        });
        jmPrestador.add(jmiCadastrarPrestador);

        jmiListarPrestador.setText("LISTAR");
        jmiListarPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarPrestadorActionPerformed(evt);
            }
        });
        jmPrestador.add(jmiListarPrestador);

        jmiCadastros.add(jmPrestador);

        jmServicosp.setText("SERVIÇOS");

        jmiCadastrarServicosP.setText("CADASTRAR");
        jmiCadastrarServicosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarServicosPActionPerformed(evt);
            }
        });
        jmServicosp.add(jmiCadastrarServicosP);

        jmiListarServicosP.setText("LISTAR");
        jmiListarServicosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarServicosPActionPerformed(evt);
            }
        });
        jmServicosp.add(jmiListarServicosP);

        jmiCadastros.add(jmServicosp);

        jMenuBar1.add(jmiCadastros);

        jmiReceitas.setText("RECEITAS");
        jmiReceitas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jmiRealizarReceita.setText("REALIZAR RECEITA");
        jmiRealizarReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRealizarReceitaActionPerformed(evt);
            }
        });
        jmiReceitas.add(jmiRealizarReceita);

        jmiListarReceita.setText("LISTAR RECEITA");
        jmiListarReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarReceitaActionPerformed(evt);
            }
        });
        jmiReceitas.add(jmiListarReceita);

        jMenuBar1.add(jmiReceitas);

        jmiDespesas.setText("DESPESAS");
        jmiDespesas.setAutoscrolls(true);
        jmiDespesas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jmiDespesa.setText("CADASTRAR DESPESA");
        jmiDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDespesaActionPerformed(evt);
            }
        });
        jmiDespesas.add(jmiDespesa);

        jmiListarDespesa.setText("LISTAR DESPESA");
        jmiListarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListarDespesaActionPerformed(evt);
            }
        });
        jmiDespesas.add(jmiListarDespesa);

        jmiPagarDespesa.setText("PAGAR DESPESA");
        jmiPagarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPagarDespesaActionPerformed(evt);
            }
        });
        jmiDespesas.add(jmiPagarDespesa);

        jMListarPagamentos.setText("LISTAR PAGAMENTOS");
        jMListarPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarPagamentosActionPerformed(evt);
            }
        });
        jmiDespesas.add(jMListarPagamentos);

        jMenuBar1.add(jmiDespesas);

        jmRelatorios.setText("RELATÓRIOS");
        jmRelatorios.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jmiRFieis.setText("RELATÓRIO DE FIÉIS");
        jmiRFieis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRFieisActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRFieis);

        jmiRCelulas.setText("RELATÓRIO DE CÉLULAS");
        jmiRCelulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRCelulasActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRCelulas);

        jmiRPrestadores.setText("RELATÓRIO DE PRESTADORES");
        jmiRPrestadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRPrestadoresActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRPrestadores);

        jmiRReceitas.setText("RELATÓRIO DE  RECEITAS");
        jmiRReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRReceitasActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRReceitas);

        jmiRDespesas.setText("RELATÓRIO DE DESPESAS");
        jmiRDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRDespesasActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRDespesas);

        jMenuItem4.setText("RELATÓRIO DE SERVIÇOS PRESTADOS");
        jmRelatorios.add(jMenuItem4);

        jmiRGeral.setText("RELATÓRIO DE MOVIMENTO FINANCEIRO");
        jmiRGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRGeralActionPerformed(evt);
            }
        });
        jmRelatorios.add(jmiRGeral);

        jMenuBar1.add(jmRelatorios);

        jmSair.setText("SAIR");
        jmSair.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuBar1.add(jmSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLimagem, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbnivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnivel)
                    .addComponent(lbusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLimagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiRealizarReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRealizarReceitaActionPerformed
        TelaReceita tr= new TelaReceita(usuariolb);
        tr.setVisible(true);
    }//GEN-LAST:event_jmiRealizarReceitaActionPerformed

    private void jmiDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDespesaActionPerformed
        // TODO add your handling code here:
        TelaCadDespesa td= new TelaCadDespesa();
        td.setVisible(true);
    }//GEN-LAST:event_jmiDespesaActionPerformed

    private void jmiPagarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPagarDespesaActionPerformed
        // TODO add your handling code here:
        TelaPagarDespesa tpd= new TelaPagarDespesa(usuariolb);
        tpd.setVisible(true);
    }//GEN-LAST:event_jmiPagarDespesaActionPerformed

    private void jmiRGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRGeralActionPerformed
        // TODO add your handling code here:
        GerarRelatorioGeral grg= new GerarRelatorioGeral();
        grg.setVisible(true);
    }//GEN-LAST:event_jmiRGeralActionPerformed

    private void jmiRDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRDespesasActionPerformed
        // TODO add your handling code here:
        GerarRelatorioDespesa grd= new GerarRelatorioDespesa();
        grd.setVisible(true);
    }//GEN-LAST:event_jmiRDespesasActionPerformed

    private void jmiRReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRReceitasActionPerformed
        // TODO add your handling code here:
        GerarRelatorioReceita grr= new GerarRelatorioReceita();
        grr.setVisible(true);
    }//GEN-LAST:event_jmiRReceitasActionPerformed

    private void jmiRPrestadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRPrestadoresActionPerformed
        // TODO add your handling code here:
        GerarRelatorioPrestador grp= new GerarRelatorioPrestador();
        grp.setVisible(true);
    }//GEN-LAST:event_jmiRPrestadoresActionPerformed

    private void jmiRCelulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRCelulasActionPerformed
        // TODO add your handling code here:
        GerarRelatorioCelula grc= new GerarRelatorioCelula();
        grc.setVisible(true);
    }//GEN-LAST:event_jmiRCelulasActionPerformed

    private void jmiRFieisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRFieisActionPerformed
        // TODO add your handling code here:
        GerarRelatorioFiel grf= new GerarRelatorioFiel();
        grf.setVisible(true);
    }//GEN-LAST:event_jmiRFieisActionPerformed

    private void jmiCadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarUsuarioActionPerformed
        // TODO add your handling code here:
        TelaCadUsuario tcu= new TelaCadUsuario();
        tcu.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarUsuarioActionPerformed

    private void jmiListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarUsuarioActionPerformed
        // TODO add your handling code here:
        TelaListarUsuario tlu= new TelaListarUsuario();
        tlu.setVisible(true);
    }//GEN-LAST:event_jmiListarUsuarioActionPerformed

    private void jmiCadastrarFielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarFielActionPerformed
        // TODO add your handling code here:
        TelaCadFiel tlf= new TelaCadFiel();
        tlf.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarFielActionPerformed

    private void jmiListarFielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarFielActionPerformed
       TelaListarFiel tf = new TelaListarFiel();
       tf.setVisible(true);
    }//GEN-LAST:event_jmiListarFielActionPerformed

    private void jmiCadastrarCelulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarCelulaActionPerformed
        // TODO add your handling code here:
        TelaCadCelula tcc= new TelaCadCelula();
        tcc.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarCelulaActionPerformed

    private void jmiListarCelulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarCelulaActionPerformed
        // TODO add your handling code here:
        TelaListarCelula tlc= new TelaListarCelula();
        tlc.setVisible(true);
    }//GEN-LAST:event_jmiListarCelulaActionPerformed

    private void jmiCadastrarPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarPrestadorActionPerformed
        // TODO add your handling code here:
        TelaCadPrestador tcp= new TelaCadPrestador();
        tcp.setVisible(true);
    }//GEN-LAST:event_jmiCadastrarPrestadorActionPerformed

    private void jmiListarPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarPrestadorActionPerformed
        // TODO add your handling code here:
        TelaListarPrestador tlp= new TelaListarPrestador();
        tlp.setVisible(true);
    }//GEN-LAST:event_jmiListarPrestadorActionPerformed

    private void jmiCadastrarServicosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarServicosPActionPerformed
        // TODO add your handling code here:
        TelaCadServicop tcsp= new TelaCadServicop();
        tcsp.setVisible(true);  
    }//GEN-LAST:event_jmiCadastrarServicosPActionPerformed

    private void jmiListarServicosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarServicosPActionPerformed
        // TODO add your handling code here:
        TelaListarServicop tlsp= new TelaListarServicop();
        tlsp.setVisible(true);
    }//GEN-LAST:event_jmiListarServicosPActionPerformed

    private void jmiListarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarDespesaActionPerformed
        // TODO add your handling code here:
        TelaListarDespesa tld=new TelaListarDespesa();
        tld.setVisible(true);
    }//GEN-LAST:event_jmiListarDespesaActionPerformed

    private void jmiListarReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListarReceitaActionPerformed
        // TODO add your handling code here:
        TelaListarReceita tlr= new TelaListarReceita(usuariolb);
        tlr.setVisible(true);
    }//GEN-LAST:event_jmiListarReceitaActionPerformed

    private void jMListarPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarPagamentosActionPerformed
        // TODO add your handling code here:
        TelaListarPDespesa tlpd= new TelaListarPDespesa(usuariolb);
        tlpd.setVisible(true);
    }//GEN-LAST:event_jMListarPagamentosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLimagem;
    private javax.swing.JMenuItem jMListarPagamentos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jmCelula;
    private javax.swing.JMenu jmFiel;
    private javax.swing.JMenu jmPrestador;
    private javax.swing.JMenu jmRelatorios;
    private javax.swing.JMenu jmSair;
    private javax.swing.JMenu jmServicosp;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JMenuItem jmiCadastrarCelula;
    private javax.swing.JMenuItem jmiCadastrarFiel;
    private javax.swing.JMenuItem jmiCadastrarPrestador;
    private javax.swing.JMenuItem jmiCadastrarServicosP;
    private javax.swing.JMenuItem jmiCadastrarUsuario;
    private javax.swing.JMenu jmiCadastros;
    private javax.swing.JMenuItem jmiDespesa;
    private javax.swing.JMenu jmiDespesas;
    private javax.swing.JMenuItem jmiListarCelula;
    private javax.swing.JMenuItem jmiListarDespesa;
    private javax.swing.JMenuItem jmiListarFiel;
    private javax.swing.JMenuItem jmiListarPrestador;
    private javax.swing.JMenuItem jmiListarReceita;
    private javax.swing.JMenuItem jmiListarServicosP;
    private javax.swing.JMenuItem jmiListarUsuario;
    private javax.swing.JMenuItem jmiPagarDespesa;
    private javax.swing.JMenuItem jmiRCelulas;
    private javax.swing.JMenuItem jmiRDespesas;
    private javax.swing.JMenuItem jmiRFieis;
    private javax.swing.JMenuItem jmiRGeral;
    private javax.swing.JMenuItem jmiRPrestadores;
    private javax.swing.JMenuItem jmiRReceitas;
    private javax.swing.JMenuItem jmiRealizarReceita;
    private javax.swing.JMenu jmiReceitas;
    private javax.swing.JLabel lbnivel;
    private javax.swing.JLabel lbusuario;
    // End of variables declaration//GEN-END:variables

    /*private void mostrarUsuario(Usuario usu) {
    
        jl
    }*/
}

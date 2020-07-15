package Control;

import Model.bean.Celula;
import Model.bean.Despesa;
import Model.bean.Fiel;
import Model.bean.NivelAcesso;
import Model.bean.Pagamento;
import Model.bean.Prestador;
import Model.bean.Receita;
import Model.bean.Servico;
import Model.bean.Tipo;
import Model.bean.Usuario;
import Model.dao.CelulaDao;
import Model.dao.DespesaDao;
import Model.dao.FielDao;
import Model.dao.NivelAcessoDao;
import Model.dao.PagamentoDao;
import Model.dao.PrestadorDao;
import Model.dao.ReceitaDao;
import Model.dao.ServicoDao;
import Model.dao.TipoDao;
import Model.dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;


public class ControllerTesouraria {
    
     CelulaDao celuladao= new CelulaDao();
     PrestadorDao prestadordao= new  PrestadorDao();
     UsuarioDao usuariodao= new UsuarioDao();
     NivelAcessoDao niveldao= new NivelAcessoDao();
     FielDao fieldao= new FielDao();
     DespesaDao despesadao= new DespesaDao();
     ServicoDao servicodao= new ServicoDao();
     TipoDao tipodao= new TipoDao();
     ReceitaDao receitadao= new ReceitaDao();
     PagamentoDao pagamentodao= new PagamentoDao();
   
// Celula
     public void cadastrarCelula (Celula celula){
        celuladao. cadastrar(celula);   
    }
    public void alterarCelula(Celula celula)throws SQLException{
        celuladao.alterar(celula);
    }
    public void excluirCelula(Celula celula)throws SQLException{
    celuladao.excluir(celula);
}// Final Celula

//Usuario
    public void cadastrarUsuario(Usuario usuario)throws SQLException{
        usuariodao.cadastrar(usuario);
    }
    public void alterarUsuario(Usuario usuario)throws SQLException{
        usuariodao.alterar(usuario);
    }
    public void excluirUsuario(Usuario usuario)throws SQLException{
        usuariodao.excluir(usuario);
    }//Final Usuario
    
    //Fiel
    public void cadastrarFiel(Fiel fiel)throws SQLException{
        fieldao.cadastrar(fiel);
    }
    public void alterarFiel(Fiel fiel)throws SQLException{
        fieldao.alterar(fiel);
    }
    public void excluirFiel(Fiel fiel)throws SQLException{
        fieldao.excluir(fiel);
    }//Final fiel
    
    //Prestador
    
    public void cadastrarPrestador(Prestador prestador) throws SQLException{
        prestadordao.cadastrar(prestador);
    }
    public void alterarPrestador(Prestador prestador) throws SQLException{
        prestadordao.alterar(prestador);
    }
    public void excluirPrestador(Prestador prestador)throws SQLException{
        prestadordao.excluir(prestador);
    } // Final prestador
    
    //Despesas
    public void cadastrarDespesa(Despesa despesa)throws SQLException{
        despesadao.cadastrar(despesa);
    }
    public void alterarDespesa(Despesa despesa)throws SQLException{
        despesadao.alterar(despesa);
    }
    public void excluirDespesa(Despesa despesa)throws SQLException{
        despesadao.excluir(despesa);
    }
    
    //Serviços prestados
    public void cadastrarServicosp(Servico servico)throws SQLException{
        servicodao.cadastrar(servico);
    }
    public void alterarServicosp(Servico servico)throws SQLException{
        servicodao.alterar(servico);
    }
    public void excluirServicosp(Servico servico)throws SQLException{
        servicodao.excluir(servico);
    }
    //Receitas
    public void cadastrarReceita(Receita receita)throws SQLException{
        receitadao.cadastrar(receita);
    }
   
    public void excluirReceita(Receita receita)throws SQLException{
        receitadao.excluir(receita);
    }

    //Pagamentos
    public void cadastrarPagamento(Pagamento pagamento)throws SQLException{
        pagamentodao.cadastrar(pagamento);
    }
    
  
    public void excluirPagamento(Pagamento pagamento)throws SQLException{
        pagamentodao.excluir(pagamento);
    }
    
 
    
    public void PreencherJcbNivel(JComboBox nivel){
        NivelAcesso nab= new NivelAcesso();
        List<NivelAcesso> listana = niveldao.listarNivel();
        for(NivelAcesso n : listana){
            nivel.addItem(n);
        }
    }//fim
    // Celula na tela fiel
 public void PreencherJcbCelula(JComboBox celula){
        Celula c= new Celula();
        List<Celula> listac = celuladao.listarCelula();
        for(Celula c1: listac){
            celula.addItem(c1);
        }
    }//fim
 //Prestador na tela Despesa
 public void PreencherJcbPrestador(JComboBox prestador){
        Prestador p= new Prestador();
        List<Prestador> listap=prestadordao.listarPrestador();
        for(Prestador p1: listap){
            prestador.addItem(p1);
        }
    }//fim
 
 //Tipo na tela receita
 public void PreencherJcbTipo(JComboBox tipo){
     Tipo t= new Tipo();
     List<Tipo> listat=tipodao.listarTipo();
     for(Tipo t1:listat){
         tipo.addItem(t1);
     }
     
 }
 
 //Fiel na tela receita
 public void PreencherJcbFiel(JComboBox fiel){
     Fiel f= new Fiel();
     List<Fiel> listaf= fieldao.listarFiel();
     for(Fiel f1:listaf){
         fiel.addItem(f1);
     }
 }
 
 //Despesa na tela pagamento
     public void PreencherJcbDespesa(JComboBox despesa){
         Despesa d= new Despesa();
         List<Despesa>  listad= despesadao.listarDespesas();
         for(Despesa d1: listad){
         despesa.addItem(d1);   
 }
     }

}
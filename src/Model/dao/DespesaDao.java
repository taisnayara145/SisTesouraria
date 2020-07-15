/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Despesa;
import Model.bean.Prestador;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 4001109296
 */
public class DespesaDao {
     Connection connection;
      PreparedStatement stmt;
      ResultSet rs;
    
        public DespesaDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
        
        public void cadastrar(Despesa despesa){
         String sql="call sp_insertdespesa(?,?,?,?)";
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,despesa.getTitulo());   
           stmt.setString(2,despesa.getDescricao());
           stmt.setString(3,despesa.getStatus());
           stmt.setInt(4, despesa.getPrestador().getId());
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }

   public List<Despesa> ListarTodos(String nome) throws SQLException{
      
      String sql="select *from despesa where des_titulo like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
     List<Despesa> minhaLista= (List<Despesa>) new ArrayList<Despesa>();
        while(rs.next()){
           Despesa despesa= new Despesa();
            Prestador prestador= new Prestador();
            
            despesa.setCodigo(Integer.parseInt(rs.getString("des_codigo")));
            despesa.setTitulo(rs.getString("des_titulo"));
           despesa.setDescricao(rs.getString("des_descricao"));
            despesa.setStatus(rs.getString("des_status"));
            prestador.setNome(rs.getString("fk_prestador"));
            despesa.setPrestador(prestador);
            minhaLista.add(despesa);
        }
        rs.close();
        stmt.close();
        return minhaLista;    
  } 
   
public List<Despesa> listarDespesas(){ // lista nomes das celulas para preencher JComboBox
          List<Despesa> listadespesa = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM despesa where des_status='PAGAMENTO PENDENTE'";
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
              Despesa despesa= new Despesa();
                
               despesa.setCodigo(rs.getInt("des_codigo"));
                despesa.setTitulo(rs.getString("des_titulo"));
                
                listadespesa.add(despesa);
           }    
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());  
        }
        return listadespesa;
     }
    
  
      public void alterar(Despesa despesa) throws SQLException{
      String sql= "call sp_updatedespesa (?,?,?,?,?)";
 
           stmt=connection.prepareStatement(sql);
           
           stmt.setInt(1,despesa.getCodigo());
           stmt.setString(2,despesa.getTitulo());   
           stmt.setString(3,despesa.getDescricao());
           stmt.setString(4,despesa.getStatus());
           stmt.setInt(5, despesa.getPrestador().getId());
           
           
           stmt.execute();
           stmt.close();
  }
    public void excluir(Despesa despesa) throws SQLException {
    String sql="call sp_deletedespesa (?)";
    
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, despesa.getCodigo());
    stmt.execute();
    stmt.close();
}
}

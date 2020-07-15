
package Model.dao;

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
public class PrestadorDao {
    Connection connection;
    PreparedStatement stmt;
    ResultSet rs;
    
    
     public PrestadorDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
     
     
     public void cadastrar(Prestador prestador){
         String sql="insert into prestador(pre_nome,pre_id)values(?,?)";
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,prestador.getNome());   
           stmt.setInt(2,prestador.getId());
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }
     
     public List<Prestador> ListarTodos(String nome) throws SQLException{
      String sql="select *from prestador where pre_nome like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
      List<Prestador> minhaLista= (List<Prestador>) new ArrayList<Prestador>();
        while(rs.next()){
            Prestador prestador= new Prestador();
            prestador.setNome(rs.getString("pre_nome"));
            prestador.setId(rs.getInt("pre_id"));
 
            minhaLista.add(prestador);
        }
        rs.close();
        stmt.close();   
        return minhaLista;    
  } 
      public List<Prestador> listarPrestador(){
        
        List<Prestador> listaprestador = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM prestador";
        
        try {
            
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Prestador prestador= new Prestador();
                
               
                prestador.setNome(rs.getString("pre_nome"));
                prestador.setId(rs.getInt("pre_id"));
                
                listaprestador.add(prestador);
                
           }
            
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());
            
        }
        return listaprestador;
    }
      public void alterar(Prestador prestador) throws SQLException{
      String sql= "update prestador set pre_nome=?,pre_id=? where pre_id=?";
 
           stmt=connection.prepareStatement(sql);
           stmt.setString(1,prestador.getNome());
           stmt.setInt(2,prestador.getId());
     
           stmt.setInt(3, prestador.getId());
           stmt.execute();
           stmt.close();
  }
      public void excluir(Prestador prestador) throws SQLException {
    String sql="delete from prestador where pre_id=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, prestador.getId());
    stmt.execute();
    stmt.close();
}
}

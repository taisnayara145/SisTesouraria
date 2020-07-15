package Model.dao;
import Model.bean.Celula;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CelulaDao {
    Connection connection;
    PreparedStatement stmt;
    ResultSet rs;

     public CelulaDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
     
     public void cadastrar(Celula celula){
         String sql="INSERT INTO celula(cel_nome,cel_lider)VALUES(?,?)";
         
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,celula.getNome());   
           stmt.setString(2,celula.getLider());
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }
   public List<Celula> ListarTodos(String nome) throws SQLException{ //consulta e lista
      String sql="select *from celula where cel_nome like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
      List<Celula> minhaLista= (List<Celula>) new ArrayList<Celula>();
        while(rs.next()){
            Celula celula= new Celula();
            celula.setCodigo(Integer.parseInt(rs.getString("cel_codigo")));
            celula.setNome(rs.getString("cel_nome"));
            celula.setLider(rs.getString("cel_lider"));
 
            minhaLista.add(celula);
        }
        rs.close();
        stmt.close();   
        return minhaLista;    
  } 
     public List<Celula> listarCelula(){ // lista nomes das celulas para preencher JComboBox
          List<Celula> listacelula = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM celula";
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Celula celula = new Celula();
                
               celula.setCodigo(rs.getInt("cel_codigo"));
                celula.setNome(rs.getString("cel_nome"));
                
                listacelula.add(celula);
           }    
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());  
        }
        return listacelula;
     }
      public void alterar(Celula celula) throws SQLException{
      String sql= "update celula set cel_nome=?,cel_lider=? where cel_codigo=?";
 
           stmt=connection.prepareStatement(sql);
           stmt.setString(1,celula.getNome());
           stmt.setString(2,celula.getLider());
     
           stmt.setInt(3, celula.getCodigo());
           stmt.execute();
           stmt.close();
  }
      public void excluir(Celula celula) throws SQLException {
    String sql="delete from celula where cel_codigo=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, celula.getCodigo());
    stmt.execute();
    stmt.close();
}
}

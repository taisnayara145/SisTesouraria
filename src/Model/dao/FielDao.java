/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Celula;
import Model.bean.Fiel;
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
public class FielDao {
    Connection connection;
      PreparedStatement stmt;
      ResultSet rs;
    
        public FielDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
        
        public void cadastrar(Fiel fiel){
         String sql="INSERT INTO fiel(fie_nome,fie_cpf,fk_celula)VALUES(?,?,?)";
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,fiel.getNome());   
           stmt.setInt(2,fiel.getCpf());
           stmt.setInt(3, fiel.getCelula().getCodigo());
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }

   public List<Fiel> ListarTodos(String nome) throws SQLException{
      
      String sql="select *from fiel where fie_nome like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
     List<Fiel> minhaLista= (List<Fiel>) new ArrayList<Fiel>();
        while(rs.next()){
            Fiel fiel= new Fiel();
            Celula celula= new Celula();
            
           
            fiel.setNome(rs.getString("fie_nome"));
            fiel.setCpf(rs.getInt("fie_cpf"));
            celula.setNome(rs.getString("fk_celula"));
            fiel.setCelula(celula);
            minhaLista.add(fiel);
        }
        rs.close();
        stmt.close();
        return minhaLista;    
  } 
      public List<Fiel> listarFiel(){
        
        List<Fiel> listafiel = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM fiel";
        
        try {
            
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Fiel fiel= new Fiel();
                
               fiel.setCpf(rs.getInt("fie_cpf"));
                fiel.setNome(rs.getString("fie_nome"));
                
                listafiel.add(fiel);
                
           }
            
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());
            
        }
        return listafiel;
    }
      public void alterar(Fiel fiel) throws SQLException{
      String sql= "update fiel set fie_nome=?,fie_cpf=?, fk_celula=? where fie_cpf=?";
 
           stmt=connection.prepareStatement(sql);
           stmt.setString(1,fiel.getNome());
           stmt.setInt(2,fiel.getCpf());
           stmt.setInt(3, fiel.getCelula().getCodigo());
           stmt.setInt(4, fiel.getCpf());
           stmt.execute();
           stmt.close();
  }
    public void excluir(Fiel fiel) throws SQLException {
    String sql="delete from fiel where fie_cpf=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, fiel.getCpf());
    stmt.execute();
    stmt.close();
}
}

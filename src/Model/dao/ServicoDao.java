/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Prestador;
import Model.bean.Servico;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4001109296
 */
public class ServicoDao {
     Connection connection;
    PreparedStatement stmt;
    ResultSet rs;
    
      public ServicoDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }

      public void cadastrar(Servico servico){
         String sql="INSERT INTO servico(ser_titulo,ser_descricao, ser_dataservico,ser_hora, fk_prestador)VALUES(?,?,?,?,?)";
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,servico.getTitulo());
           stmt.setString(2,servico.getDescricao());
           stmt.setDate(3,new Date (servico.getData().getTime()));
           stmt.setString(4,servico.getHora());
           stmt.setInt(5,servico.getPrestador().getId());
           

           stmt.execute();
           stmt.close();
                  }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }
     
      public List<Servico> ListarTodos(String nome) throws SQLException{ //consulta e lista
      String sql="select *from servico where ser_titulo like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
      List<Servico> minhaLista= (List<Servico>) new ArrayList<Servico>();
        while(rs.next()){
           
           Prestador prestador= new Prestador();
           Servico servico= new Servico();
           
           servico.setCodigo(Integer.parseInt(rs.getString("ser_codigo")));
           servico.setTitulo(rs.getString("ser_titulo"));
           servico.setDescricao(rs.getString("ser_descricao"));
           servico.setData(rs.getDate("ser_dataservico"));
           servico.setHora(rs.getString("ser_hora"));
           prestador.setNome(rs.getString("fk_prestador"));
           servico.setPrestador(prestador);
           
            minhaLista.add(servico);
        }
        rs.close();
        stmt.close();   
        return minhaLista;    
  } 
     
   public void alterar(Servico servico) throws SQLException{
      String sql= "update servico set ser_titulo=?,ser_dataservico=?, ser_hora=?, fk_prestador=? where ser_codigo=?";
 
           stmt=connection.prepareStatement(sql);
           
           stmt.setString(1,servico.getTitulo());
           stmt.setString(2,servico.getDescricao());
           stmt.setDate(3,new Date (servico.getData().getTime()));
           stmt.setString(4,servico.getHora());
           stmt.setInt(5,servico.getPrestador().getId());
             
           stmt.setInt(6,servico.getCodigo());
        
           
           stmt.execute();
           stmt.close();
  }
    public void excluir(Servico servico) throws SQLException {
    String sql="delete from servico where ser_codigo=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, servico.getCodigo());
    stmt.execute();
    stmt.close();
}   
}

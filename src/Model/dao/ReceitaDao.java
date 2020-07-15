/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Fiel;
import Model.bean.Receita;
import Model.bean.Tipo;
import Model.bean.Usuario;
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
public class ReceitaDao {
    Connection connection;
      PreparedStatement stmt;
      ResultSet rs;
    
        public ReceitaDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
        
        public void cadastrar(Receita receita){
         //String sql="INSERT INTO receita(fk_usuario,rec_titulo,fk_fiel,rec_data,rec_hora,rec_valor,fk_tipo,fk_caixa)VALUES(?,?,?,?,?,?,?,?)";
        String sql="call sp_insertreceita(?,?,?,?,?,?,?,?)";
            try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,receita.getTitulo());
           stmt.setDate(2,new Date (receita.getData().getTime()));
           stmt.setDouble(3,receita.getValor());
           stmt.setString(4,receita.getHora());
           stmt.setInt(5,receita.getUsuario().getCodigo());
           stmt.setInt(6, receita.getFiel().getCpf());
           stmt.setInt(7, receita.getTipo().getCodigo());
           stmt.setInt(8, receita.getMovimento().getCodigo());
         
        
           stmt.execute();
           
           //update na tabela caixa com o valor inserido
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }

   public List<Receita> ListarTodos(String nome) throws SQLException{
      
      String sql="select *from receita where rec_titulo like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
     List<Receita> minhaLista= (List<Receita>) new ArrayList<Receita>();
        while(rs.next()){
           
           Receita receita = new Receita();
           Tipo tipo= new Tipo();
           Fiel fiel= new Fiel();
           Usuario usuario= new Usuario();
            
            receita.setCodigo(Integer.parseInt(rs.getString("rec_codigo")));
          
            receita.setTitulo(rs.getString("rec_titulo"));
            receita.setData(rs.getDate("rec_data"));
            receita.setValor(Double.parseDouble(rs.getString("rec_valor")));
            receita.setHora(rs.getString("rec_hora"));
            tipo.setDescricao(rs.getString("fk_tipo"));
            receita.setTipo(tipo);
            fiel.setNome(rs.getString("fk_fiel"));
            receita.setFiel(fiel);
            usuario.setCodigo(Integer.parseInt(rs.getString("fk_usuario")));
            receita.setUsuario(usuario);
            minhaLista.add(receita);
        }
        rs.close();
        stmt.close();
        return minhaLista;    
  } 
    
     
    public void excluir(Receita receita) throws SQLException {
   
        String sql="call sp_deletereceita(?)";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, receita.getCodigo());
    stmt.execute();
    stmt.close();
}
}

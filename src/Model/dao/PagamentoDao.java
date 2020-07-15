/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Despesa;
import Model.bean.Pagamento;
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
public class PagamentoDao {
    Connection connection;
      PreparedStatement stmt;
      ResultSet rs;
    
        public PagamentoDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
        
        public void cadastrar(Pagamento pagamento){
         String sql="INSERT INTO pagamento(fk_usuario,pag_titulo,fk_despesa,pag_data, pag_hora,pag_valor,fk_movimento)VALUES(?,?,?,?,?,?,?)";
       
         try{
           stmt = connection.prepareStatement(sql); 
           
           stmt.setInt(1, pagamento.getUsuario().getCodigo());
           stmt.setString(2, pagamento.getTitulo());
	   stmt.setInt(3,pagamento.getDespesa().getCodigo());
           stmt.setDate(4,new Date (pagamento.getData().getTime()));
           stmt.setString(5,pagamento.getHora());
            stmt.setDouble(6,pagamento.getValor());
           stmt.setInt(7,pagamento.getMovimento().getCodigo());
           
           
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }
        
        public List<Pagamento> ListarTodos(String nome) throws SQLException{
      
      String sql="select *from pagamento where pag_titulo like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
     List<Pagamento> minhaLista= (List<Pagamento>) new ArrayList<Pagamento>();
        while(rs.next()){
            Pagamento pagamento= new Pagamento();
            Despesa despesa= new Despesa();
            Usuario usuario = new Usuario();
            
            pagamento.setCodigo(Integer.parseInt(rs.getString("pag_codigo")));
           
            pagamento.setTitulo(rs.getString("pag_titulo"));
            pagamento.setData(rs.getDate("pag_data"));
            pagamento.setHora(rs.getString("pag_hora"));
            pagamento.setValor(Double.parseDouble(rs.getString("pag_valor")));
            despesa.setDescricao("fk_despesa");
            pagamento.setDespesa(despesa);
            usuario.setCodigo(Integer.parseInt(rs.getString("fk_usuario")));
            pagamento.setUsuario(usuario);
            
            
            minhaLista.add(pagamento);
        }
        rs.close();
        stmt.close();
        return minhaLista;    
  } 

      public void excluir(Pagamento pagamento) throws SQLException {
   
     String sql="delete from pagamento where pag_codigo=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, pagamento.getCodigo());
    stmt.execute();
    stmt.close();
}   
}

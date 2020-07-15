package Model.dao;

import Model.bean.NivelAcesso;
import Model.bean.Usuario;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDao {
      Connection connection;
      PreparedStatement stmt;
      ResultSet rs;
    
        public UsuarioDao(){
        this.connection= new ConnectionFactory().getConnection();      
    }
        
        public void cadastrar(Usuario usuario){
         String sql="INSERT INTO usuario(usu_nome,usu_login, usu_senha, fk_nivel)VALUES(?,?,?,?)";
        try{
           stmt = connection.prepareStatement(sql); 
           
	   stmt.setString(1,usuario.getNome());   
           stmt.setString(2,usuario.getLogin());
           stmt.setString(3, usuario.getSenha());
           stmt.setInt(4, usuario.getNivel().getCodigo());
        
           stmt.execute();
           stmt.close();
        
          }catch (SQLException u) {
            throw new RuntimeException(u);
        }
     }

   public List<Usuario> ListarTodos(String nome) throws SQLException{
      
      String sql="select *from usuario where usu_nome like ?";
      stmt=this.connection.prepareStatement(sql);
      stmt.setString(1,nome);
      rs=stmt.executeQuery();
      
     List<Usuario> minhaLista= (List<Usuario>) new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario= new Usuario();
            NivelAcesso nivelacesso= new NivelAcesso();
            
            usuario.setCodigo(Integer.parseInt(rs.getString("usu_codigo")));
            usuario.setNome(rs.getString("usu_nome"));
            usuario.setLogin(rs.getString("usu_login"));
            nivelacesso.setDescricao(rs.getString("fk_nivel"));
            usuario.setNivel(nivelacesso);
            minhaLista.add(usuario);
        }
        rs.close();
        stmt.close();
        return minhaLista;    
  } 
      
      public void alterar(Usuario usuario) throws SQLException{
      String sql= "update usuario set usu_nome=?,usu_login=?, usu_senha=?, fk_nivel=? where usu_codigo=?";
 
           stmt=connection.prepareStatement(sql);
           stmt.setString(1,usuario.getNome());
           stmt.setString(2,usuario.getLogin());
           stmt.setString(3,usuario.getSenha());
           stmt.setInt(4, usuario.getNivel().getCodigo());
           stmt.setInt(5, usuario.getCodigo());
           stmt.execute();
           stmt.close();
  }
    public void excluir(Usuario usuario) throws SQLException {
    String sql="delete from usuario where usu_codigo=?";
    stmt=connection.prepareStatement(sql);
    stmt.setInt(1, usuario.getCodigo());
    stmt.execute();
    stmt.close();
}
   
  public Usuario ValidarUsuario(Usuario usuario){
       
        Usuario usu = null;
        connection = new ConnectionFactory().getConnection();
        //sql = "select * from usuario where usua_login = ? and usua_senha= ? ";
        String sql = "select * from usuario\n" +
              "inner join nivelacesso on niv_codigo = fk_nivel\n" +
              "where usu_login = ? and usu_senha = ? and( niv_codigo = 1 or niv_codigo = 2)";
     
        try {
            
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
           
            rs = stmt.executeQuery();
            
            if(rs.next()){
              
               NivelAcesso nivelacesso = new NivelAcesso();
               nivelacesso.setDescricao(rs.getString("niv_descricao"));
               
               usu = new Usuario();
               
               usu.setLogin(rs.getString("usu_login"));
               usu.setNome(rs.getString("usu_nome"));
               usu.setCodigo(rs.getInt("usu_codigo"));
               usu.setNivel(nivelacesso);
                
            }
            
        } 
        catch (SQLException ex) {
            
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return usu;
  }
}

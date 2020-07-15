package Model.dao;

import Model.bean.NivelAcesso;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NivelAcessoDao {
    Connection connection;
    PreparedStatement stmt;
    ResultSet rs;

    public List<NivelAcesso> listarNivel(){
        
        List<NivelAcesso> listanivel = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM nivelacesso";
        
        try {
            
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                NivelAcesso nivelacesso = new NivelAcesso();
                
               nivelacesso.setCodigo(rs.getInt("niv_codigo"));
                nivelacesso.setDescricao(rs.getString("niv_descricao"));
                
                listanivel.add(nivelacesso);
                
           }
            
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());
            
        }
        return listanivel;
    }
    
}

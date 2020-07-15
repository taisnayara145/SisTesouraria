/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.bean.Tipo;
import Model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4001109296
 */
public class TipoDao {
     Connection connection;
    PreparedStatement stmt;
    ResultSet rs;

    public List<Tipo> listarTipo(){
        
        List<Tipo> listatipo = new ArrayList<>();
        connection = new ConnectionFactory().getConnection();
        String sql = "SELECT * FROM tipo";
        
        try {
            
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Tipo tipo= new Tipo();
                
               tipo.setCodigo(rs.getInt("tip_codigo"));
                tipo.setDescricao(rs.getString("tip_descricao"));
                
                listatipo.add(tipo);
                
           }
            
        } catch (Exception e) {
            
             System.out.println("Falha ao Listar !!!!!!"+e.getMessage());
            
        }
        return listatipo;
    }
    
}

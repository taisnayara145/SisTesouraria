
package Model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static boolean Conexao;
     public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/sistesouraria","root","12345");
            
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
     
     
     public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    } 
    }    


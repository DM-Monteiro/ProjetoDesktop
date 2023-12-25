
package br.com.daniel.projetoJavaDesktop.core.dao.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexaoJDBC {
    
    private static final String URL ="jdbc:mysql://localhost:3306/banco_de_dados";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot33@";
    
    private static Connection conn;
    
    public static Connection getConexao(){
        try{
            if(conn == null){
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            }else{
                return conn;
            }    
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar com o banco de dados");
            return null;
        }
    }
    
}

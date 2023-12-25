
package br.com.daniel.projetoJavaDesktop.core.dao;

import br.com.daniel.projetoJavaDesktop.core.dao.conexao.ConexaoJDBC;
import br.com.daniel.projetoJavaDesktop.core.entity.ClienteEntity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    
    public String salvarCliente(ClienteEntity cliente){
        System.out.println("Cadastrando cliente no banco de dados....");
        
        String sql = "INSERT INTO CLIENTE (NOME, CPF, TELEFONE, EMAIL) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps;
        
        try{
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEmail());
            
            ps.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao cadastrar Cliente!";
        }
                
        return "Cliente cadastrado com sucesso";
        
    }
    
    public List<ClienteEntity> listarClientes(){
        
        String sql = "SELECT IDCLIENTE, NOME, CPF, TELEFONE, EMAIL FROM CLIENTE";
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();
            
            while(rs.next()){
                ClienteEntity c = new ClienteEntity();
                c.setId(rs.getString("IDCLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                clientes.add(c);
                
            }
            return clientes;
            
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}


package br.com.daniel.projetoJavaDesktop.core.service;

import br.com.daniel.projetoJavaDesktop.core.dao.ClienteDAO;
import br.com.daniel.projetoJavaDesktop.core.entity.ClienteEntity;
import java.util.List;


public class ClienteService {
    
    public void salvarCliente(ClienteEntity cliente){
        System.out.println("Passando pelo service");
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.salvarCliente(cliente);
        
    }
    
    public List<ClienteEntity> listarClientes(){
        return new ClienteDAO().listarClientes();
    }
    
}

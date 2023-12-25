
package br.com.daniel.projetoJavaDesktop.core.controller;

import br.com.daniel.projetoJavaDesktop.core.entity.ClienteEntity;
import br.com.daniel.projetoJavaDesktop.core.service.ClienteService;
import java.util.List;


public class ClienteController {
    
    public void salvarCliente(ClienteEntity cliente){
        System.out.println("Passando pelo controller");
        ClienteService clienteService = new ClienteService();
        clienteService.salvarCliente(cliente);
        
    }
    
    public List<ClienteEntity> listarClientes(){
        return new ClienteService().listarClientes();
    }
    
}

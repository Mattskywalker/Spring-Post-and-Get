package com.mattskywalker.LearningSpring.springController;


import com.mattskywalker.LearningSpring.hibernate.ClienteDao;
import com.mattskywalker.LearningSpring.hibernate.ClienteDaoInterface;
import com.mattskywalker.LearningSpring.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClientesController {

    private final ClienteDaoInterface clienteDao = new ClienteDao();

    @GetMapping(value = "/clientes")
    @ResponseBody
    private List<Cliente> listarClientes(){
        return clienteDao.Listar();
    }

    @GetMapping(value = "/cliente/{id}")
    public Cliente pesquisarCliente(@PathVariable(value  = "id") String id){
        return clienteDao.pesquisarCliente(id);
    }

    @PostMapping(value = "/cadastrar")
    private void cadastrarCliente(@RequestBody Cliente cliente){
        clienteDao.Cadastrar(cliente);

    }

}

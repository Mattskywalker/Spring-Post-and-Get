package com.mattskywalker.LearningSpring.hibernate;

import com.mattskywalker.LearningSpring.model.Cliente;

import java.util.List;

public interface ClienteDaoInterface {

    public void Cadastrar(Cliente cliente);

    public List<Cliente> Listar();

    public Cliente pesquisarCliente(String id);
}

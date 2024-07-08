package com.java.service;

import java.util.*;

import com.java.model.Cliente;

public class ClienteService {
	private Map<String, Cliente> clientes = new HashMap<>();
	
	
	public void criarCliente(String nome, String documento, String endereco, String contato) {
		Cliente cliente = new Cliente(nome, documento, endereco, contato);
		clientes.put(nome, cliente);
        System.out.println("Cliente adicionado com sucesso! ");
        System.out.println(cliente.toString());
	}
	
	public Cliente buscarCliente(String nome) {
        return clientes.get(nome);
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }
}

package com.java.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.*;
import com.java.enumerations.TipoConta;
import com.java.model.Cliente;
import com.java.model.Conta;

@Service
public interface ContaService {
    Scanner scanner = new Scanner(System.in);

	void abrirConta(String nomeCliente, TipoConta tipoConta);
	
	void sacar(int numeroConta, double valor);
	
	void depositar(int numeroConta, double valor);
	
	void transferir(int contaOrigem, int contaDestino, double valor);
	
	void consultarExtrato(int numeroConta);
	
	void consultarSaldo(int numeroConta) ;
	
	void infoExtrato();
}

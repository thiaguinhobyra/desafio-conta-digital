package com.java;
import java.util.Scanner;

import com.java.enumerations.TipoConta;
import com.java.service.ClienteService;
import com.java.service.ContaService;
import com.java.service.ContaServiceImpl;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ClienteService clienteService = new ClienteService();
		
		ContaService contaService = new ContaServiceImpl(clienteService);
		
		clienteService.criarCliente("Cliente 1", "Documento 1", "end 1", "(99) 9999-9999");
		clienteService.criarCliente("Cliente 2", "Documento 2", "end 2", "(99) 9999-9991");
		
		contaService.abrirConta("Cliente 1", TipoConta.CORRENTE);
		contaService.abrirConta("Cliente 1", TipoConta.POUPANCA);
		
		contaService.abrirConta("Cliente 2", TipoConta.CORRENTE);
		contaService.abrirConta("Cliente 2", TipoConta.POUPANCA);
		
		contaService.depositar(1, 300);
		contaService.sacar(1, 200);
        contaService.transferir(1, 2, 100);
        contaService.consultarExtrato(1);
        contaService.consultarSaldo(2);
        contaService.consultarSaldo(3);
        contaService.consultarSaldo(4);
	}

}

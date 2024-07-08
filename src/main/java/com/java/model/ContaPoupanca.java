package com.java.model;

import com.java.enumerations.TipoConta;
import com.java.service.ContaService;

public class ContaPoupanca extends Conta implements ContaService {

	public ContaPoupanca(int numero, int agencia, Cliente cliente) {
		super(numero, agencia, cliente, TipoConta.POUPANCA);
	}

	@Override
	public void consultarExtrato(int numeroConta) {
		System.out.println("=== Extrato Conta Poupança ===");
		infoExtrato();
	}

	@Override
	public void abrirConta(String nomeCliente, TipoConta tipoConta) {
		System.out.println("Conta Poupança já está aberta.");
	}

	@Override
	public void sacar(int numeroConta, double valor) {
		if (valor >= getSaldo() && valor > 0) {
			double saldoAtual = getSaldo() - valor;
			this.setSaldo(saldoAtual);
			System.out.println("Saldo: " + saldoAtual);
		}
	}

	@Override
	public void depositar(int numeroConta, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int contaOrigem, int contaDestino, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consultarSaldo(int numeroConta) {
		// TODO Auto-generated method stub
		
	}
	
}

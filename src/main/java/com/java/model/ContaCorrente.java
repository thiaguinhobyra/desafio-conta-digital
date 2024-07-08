package com.java.model;

import java.math.BigDecimal;

import com.java.enumerations.TipoConta;
import com.java.service.ContaService;

public class ContaCorrente extends Conta implements ContaService {
		
	public ContaCorrente(int numero, int agencia, Cliente cliente) {
		super(numero, agencia, cliente, TipoConta.CORRENTE);
	}
	
	@Override
    public void abrirConta(String nomeCliente, TipoConta tipoConta) {
        System.out.println("Conta Corrente já está aberta.");
    }
	
	@Override
	public void sacar(int numeroConta, double valor) {
		if (valor >= getSaldo() && valor > 0) {
			double saldoAtual = getSaldo() - valor;
			this.setSaldo(saldoAtual);
			System.out.println("Saldo: " + saldoAtual);
		} else {
			System.out.println("Saldo insuficiente ou valor inválido");
		}
	}

	@Override
	public void consultarExtrato(int numeroConta) {
		System.out.println("=== Extrato Conta Corrente ===");
		infoExtrato();
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

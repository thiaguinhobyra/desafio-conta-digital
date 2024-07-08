package com.java.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.enumerations.TipoConta;
import com.java.model.Cliente;
import com.java.model.Conta;
import com.java.model.ContaCorrente;
import com.java.model.ContaPoupanca;

public class ContaServiceImpl implements ContaService {
	private Scanner scanner = new Scanner(System.in);
	
	private static int SEQUENCIAL = 1;
	private static final int AGENCIA_PADRAO = 1;

	@Autowired
	private Map<Integer, Conta> contas = new HashMap<>();
	
	private int numero;
	private int agencia;
	private double saldo;
	private ClienteService clienteService;
	
	public ContaServiceImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
	
	@Override
	public void abrirConta(String nomeCliente, TipoConta tipoConta) {
		Cliente cliente = clienteService.buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
		this.agencia = ContaServiceImpl.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		Conta conta;
		if(tipoConta == TipoConta.CORRENTE) {
			conta = new ContaCorrente(numero, agencia, cliente);
		} else if(tipoConta == TipoConta.POUPANCA) {
			conta = new ContaPoupanca(numero, agencia, cliente);
		} else {
			throw new IllegalArgumentException("Tipo conta inválido");
		}
		contas.put(numero, conta);
		System.out.println(conta.toString());
	};
	
    @Override
    public void sacar(int numeroConta, double valor) {
    	Conta conta = contas.get(numeroConta);
    	System.out.println(conta.toString());
    	if(conta != null && conta.getSaldo() >= valor && valor > 0) {
    		conta.setSaldo(conta.getSaldo() - valor);
    		System.out.println("Saque realizado com sucesso. Saldo atual: " + conta.getSaldo());
		} else {
    		System.out.println("Saldo insuficiente para saque. ");
    	}
	}
	
    @Override
    public void depositar(int numeroConta, double valor) {
    	Conta conta = contas.get(numeroConta);
    	System.out.println(conta.toString());
		if(conta != null && valor > 0) {
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso. ");
			System.out.println("Saldo atual: " + conta.getSaldo());
		}else {
			System.out.println("Valor inválido. ");
		}
	}
	
    @Override
    public void transferir(int contaOrigem, int contaDestino, double valor) {
    	Conta origem = contas.get(contaOrigem);
    	System.out.println(origem.toString());
    	Conta destino = contas.get(contaDestino);
		if(destino != null && origem.getSaldo() >= valor && valor > 0) {
			origem.setSaldo(origem.getSaldo() - valor);
			destino.setSaldo(destino.getSaldo() + valor);
			System.out.println("Transferência realizada com sucesso.");
			System.out.println("Saldo atual: " + origem.getSaldo());
		}else {
			System.out.println("Saldo insuficiente para transferência. ");
			System.out.println("Saldo atual: " + origem.getSaldo());
		}
	}
	
    @Override
    public void consultarExtrato(int numeroConta) {
    	Conta conta = contas.get(numeroConta);
    	System.out.println(conta.toString());
    	
    	if (conta != null) {
    		this.infoExtrato();
    	} else {
    		System.out.println("Conta não encontrada.");
    	}
	};
	
    @Override
    public void consultarSaldo(int numeroConta) {
    	Conta conta = contas.get(numeroConta);
    	System.out.println(conta.toString());
        if (conta != null) {
            System.out.println("Saldo: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
	};
	
    public void setSEQUENCIAL(int Sequencial) {
		SEQUENCIAL = Sequencial;
	}

	@Override
	public void infoExtrato() {
		System.out.println(String.format("Agência: %d", agencia));
		System.out.println(String.format("Número: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
		System.out.println();
	}
	

}

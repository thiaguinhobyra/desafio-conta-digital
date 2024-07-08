package com.java.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.java.enumerations.TipoConta;

public abstract class Conta {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private int agencia;
	private double saldo;
	
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@ManyToOne
	private Cliente cliente;
	
	public Conta(int numero, int agencia, Cliente cliente, TipoConta tipoConta) {
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
	}
	
	public int getNumero() {
		return numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
		
	@Override
	public String toString() {
		return "Conta " + tipoConta + " Número: " + numero + ", Agência: " + agencia + ", Saldo: " + saldo + ", " + cliente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
        return tipoConta;
    }
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    public void infoExtrato() {
		System.out.println(String.format("Agência: %s", cliente.getNome()));
		System.out.println(String.format("Agência: %d", agencia));
		System.out.println(String.format("Número: %d", numero));
		System.out.println(String.format("Saldo: %.2f", saldo));
		System.out.println();
	}
}

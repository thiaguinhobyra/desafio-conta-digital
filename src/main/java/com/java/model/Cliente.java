package com.java.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String documento;
	private String contato;
	private String endereco;
	@OneToMany(mappedBy = "cliente")
	private List<Conta> contas;
	
	public Cliente(String nome, String documento, String endereco, String contato) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.contato = contato;
        this.contas = new ArrayList<>();
    }
	
	public String getNome() {
		return nome;
	}

	public String getContato() {
		return contato;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public String getDocumento() {
		return documento;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public void addContas(Conta conta) {
		contas.add(conta);
	}
	
	public String toString() {
        return "Cliente " + nome + 
                ", contato: " + contato + 
                ", endereco: " + endereco;
    }
}

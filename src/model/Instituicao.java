package model;

import java.util.ArrayList;

public class Instituicao {
	private String nome;
	private String cnpj;
	private ArrayList<String> telefones;
	private String email;
	private ArrayList<Contato> contatos;
	private ArrayList<Endereco> endereco;
	private ArrayList<String> tags;
	private ArrayList<ContaBancaria> contaBancaria;
	private Descricao descricao;
	private ArrayList<Pedido> pedidos;
	
	public Instituicao(String nome, String cnpj, ArrayList<String> telefones, String email, ArrayList<Contato> contatos,
			ArrayList<Endereco> endereco, ArrayList<String> tags, ArrayList<ContaBancaria> contaBancaria,
			Descricao descricao, ArrayList<Pedido> pedidos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefones = telefones;
		this.email = email;
		this.contatos = contatos;
		this.endereco = endereco;
		this.tags = tags;
		this.contaBancaria = contaBancaria;
		this.descricao = descricao;
		this.pedidos = pedidos;
	}
	
	public String getNome() {
		return nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public ArrayList<String> getTelefones() {
		return telefones;
	}
	public String getEmail() {
		return email;
	}
	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public ArrayList<ContaBancaria> getContaBancaria() {
		return contaBancaria;
	}
	public Descricao getDescricao() {
		return descricao;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
	public void setEndereco(ArrayList<Endereco> endereco) {
		this.endereco = endereco;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public void setContaBancaria(ArrayList<ContaBancaria> contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}

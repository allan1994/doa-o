package model;

public class Endereco {
	private String rua;
	private String bairro;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco(String rua, String bairro, String numero, String cidade, String estado, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public String getRua() {
		return rua;
	}
	public String getBairro() {
		return bairro;
	}
	public String getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getCep() {
		return cep;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}

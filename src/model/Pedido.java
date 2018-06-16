package model;

public class Pedido {
	private String nome;
	private String dataLimite;
	private Float quantidade;
	private String medida;
	private String descricao;
	private String tipo;
	private String imagem;
	
	public Pedido(String nome, String dataLimite, Float quantidade, String medida, String descricao, String tipo,
			String imagem) {
		super();
		this.nome = nome;
		this.dataLimite = dataLimite;
		this.quantidade = quantidade;
		this.medida = medida;
		this.descricao = descricao;
		this.tipo = tipo;
		this.imagem = imagem;
	}
	
	public String getNome() {
		return nome;
	}
	public String getDataLimite() {
		return dataLimite;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public String getMedida() {
		return medida;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public String getImagem() {
		return imagem;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}

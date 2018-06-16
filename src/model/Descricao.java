package model;

public class Descricao {
	private String data;
	private String texto;
	private String imagens;
	
	public Descricao(String data, String texto, String imagens) {
		super();
		this.data = data;
		this.texto = texto;
		this.imagens = imagens;
	}
	
	public String getData() {
		return data;
	}
	public String getTexto() {
		return texto;
	}
	public String getImagens() {
		return imagens;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public void setImagens(String imagens) {
		this.imagens = imagens;
	}
}

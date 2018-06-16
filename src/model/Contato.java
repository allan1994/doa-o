package model;

public class Contato {
	private String nomeRede;
	private String endereco;
	
	public Contato(String nomeRede, String endereco) {
		super();
		this.nomeRede = nomeRede;
		this.endereco = endereco;
	}
	
	public String getNomeRede() {
		return nomeRede;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setNomeRede(String nomeRede) {
		this.nomeRede = nomeRede;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}

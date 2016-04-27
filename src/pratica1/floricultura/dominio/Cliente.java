package pratica1.floricultura.dominio;

public class Cliente {
	private final String nome;
	private final String RG;
	private String endereco;
	private String telefone;
	
	public Cliente(String nome, String RG, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.RG = RG;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getRG() {
		return RG;
	}
	
	@Override
	public String toString() {
		return  "Nome: " + nome + "\n" +
				"RG: " + RG + "\n" +
				"Telefone: " + telefone + "\n" +
				"Endereço: " + endereco + "\n";				
	}
}

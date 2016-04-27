package pratica1.floricultura.dominio;

public enum StatusCompra {
	EFETUADA("Compra realizada com sucesso"),
	CANCELADA("Não foi possivei efeutar a compra");
	
	private String nome;
	private StatusCompra(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}

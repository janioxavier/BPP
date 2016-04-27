package pratica1.floricultura.dominio;

public enum StatusProduto {
	ENCONTRADO("Produto encontrado"),
	DISPONIVEL("Produto encontra-se no estoque"),
	INEXISTENTE("Produto não cadastrado"),
	ACABADO("Acabou o estoque"),
	REDUZIDO("Estoque reduzido");
	
	private String status;
	private StatusProduto(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}

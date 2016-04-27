package pratica1.floricultura.dominio;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

public class Produto {
	private String nome;
	private String tipo;
	private double preco;
	private int estoque;
	
	public Produto(String nomeDoProduto, String tipo, double preco, int estoque) {
		super();
		this.nome = nomeDoProduto;
		this.tipo = tipo;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPreco() {
		return preco;
	}
	
	@Ensures("preco >= 0")
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}
	
	@Ensures("estoque >= 0")
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}		
	
	@Ensures("estoque >= 0")
	public boolean dimunirEstoque() {
		boolean isDiminuido = false;
		
		if (estoque > 0) {
			estoque--;
			isDiminuido = true;
		}
		
		return isDiminuido;
	}
	
	@Override
	public String toString() {
		return  "Nome: " + nome + "\n" +
				"Tipo: " + tipo + "\n" +
				"Preço: " + preco + "\n" +
				"Estoque: " + estoque + "\n";	
	}
	
}

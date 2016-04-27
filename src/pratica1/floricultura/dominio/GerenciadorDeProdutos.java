package pratica1.floricultura.dominio;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeProdutos {
	private List<Produto> listaDeProdutos;
	
	public GerenciadorDeProdutos() {
		listaDeProdutos = new ArrayList<>();
	}
	
	public void addProduto(Produto produto) {
		listaDeProdutos.add(produto);
	}
		
	public String diminuirEstoque(String nomeDoProduto) {
		String resultado = "";
		boolean estoqueDiminuido = false;
		
		Produto produtoEncontrado = buscarProduto(nomeDoProduto);		
		
		if (produtoEncontrado != null) {					
			resultado = verificarEstoqueDiminuido(produtoEncontrado);
		}
		else {
			resultado = "Produto não encontrado!";
		}
		
		return resultado;
	}
	
	private Produto buscarProduto(String nomeDoProduto) {
		Produto produtoEncontrado = null;
		
		for (Produto p : listaDeProdutos) {
			if (p.getNome().equals(nomeDoProduto))
				produtoEncontrado = p;
		}
		
		return produtoEncontrado;
	}
	
	private String verificarEstoqueDiminuido(Produto produto) {
		String resultado = "";
		
		if (produto.dimunirEstoque()) {
			resultado =  "Estoque reduzido";
		}
		else 
			resultado = "Não foi possível reduzir o estoque";
		
		return resultado;
	}
	
	public String listarProdutosCadastrados() {
		String listaProdutosCadastrados = "";
		
		int cont = 1;
		for (Produto p:listaDeProdutos) {
			listaProdutosCadastrados += "\nProduto: " + cont++ + "\n";
			listaProdutosCadastrados += p.toString() + "\n";			
		}
		
		return listaProdutosCadastrados;
	}
}

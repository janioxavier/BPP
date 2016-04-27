package pratica1.floricultura.dominio;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeProdutos {
	private List<Produto> listaDeProdutos;
	private StatusProduto estadoProduto;
	
	public GerenciadorDeProdutos() {
		listaDeProdutos = new ArrayList<>();
	}
	
	public void addProduto(Produto produto) {
		listaDeProdutos.add(produto);
	}
	
	public StatusProduto verificarDisponibilidade(String nomeDoProduto) {
		StatusProduto statusProduto;
		Produto produtoEncontrado = buscarProduto(nomeDoProduto);
		
		if (produtoEncontrado != null) {
			statusProduto = verificarDisponibilidade(produtoEncontrado);
		} else {
			statusProduto = StatusProduto.INEXISTENTE;
		}
		
		return statusProduto;	
	}
	
	public StatusProduto obterEstadoProduto(Produto produto) {
		StatusProduto statusProduto;
		if (produto != null) {
			statusProduto = verificarDisponibilidade(produto);
		} else {
			statusProduto = StatusProduto.INEXISTENTE;
		}
		return statusProduto;
	}

	private StatusProduto verificarDisponibilidade(Produto produtoEncontrado) {
		StatusProduto statusProduto;
		
		if (produtoEncontrado.getEstoque() > 0)
			statusProduto = StatusProduto.DISPONIVEL;
		else
			statusProduto =  StatusProduto.ACABADO;
		
		return statusProduto;
	}
	
	public StatusProduto diminuirEstoque(String nomeDoProduto) {
		Produto produtoEncontrado = buscarProduto(nomeDoProduto);
		StatusProduto statusProduto = obterEstadoProduto(produtoEncontrado);		
						
		if (statusProduto == StatusProduto.DISPONIVEL) {					
			produtoEncontrado.dimunirEstoque();
		}		
		
		return statusProduto;
	}
	
	public Produto buscarProduto(String nomeDoProduto) {
		Produto produtoEncontrado = null;
		
		for (Produto p : listaDeProdutos) {
			if (p.getNome().equals(nomeDoProduto))
				produtoEncontrado = p;
		}
		
		return produtoEncontrado;
	}
	
	private void verificarEstoqueDiminuido(Produto produto) {		
		
		if (produto.dimunirEstoque()) {
			estadoProduto =  estadoProduto.REDUZIDO;
		}
		else 
			estadoProduto = estadoProduto.ACABADO;
				
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

package pratica1.floricultura.dominio;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GerenciadorDeCompras {
	private List<Compra> listaDeCompras;
	
	public GerenciadorDeCompras() {
		listaDeCompras = new ArrayList<>();
	}
	
	public void addCompra(Compra compra, Produto produto) {				
		Compra compraEncontrada = buscarCompra(compra.getComprador().getNome());
		
		if (compraEncontrada != null) {
			compraEncontrada.addProdutoComprado(produto);
			listaDeCompras.add(compraEncontrada);
		}
		// adiciona uma nova compra
		else {
			compra.addProdutoComprado(produto);
			listaDeCompras.add(compra);
		}
	}
	
	public Compra buscarCompra(String nomeComprador) {
		Compra compra = null;
		Cliente comprador = null;
		
		for (Compra c : listaDeCompras) {
			comprador = c.getComprador(); 
			if (comprador.getNome().equals(nomeComprador)) {
				compra = c;
				break;
			}				
		}
		
		return compra;
	}
	
	public boolean hasComprador(Cliente comprador) {		
		boolean encontrado = false;
		
		for (Compra c : listaDeCompras) {
			if (c.getComprador().equals(comprador)) {
				encontrado = true;
				break;
			}				
		}
		
		return encontrado;
	}
	
	public void removerCompra(Compra compra) {
		listaDeCompras.remove(compra);
	}
	
	public List<Compra> getListaDeCompras() {
		return listaDeCompras;
	}
		
}

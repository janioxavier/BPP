package pratica1.floricultura.dominio;

import java.util.List;
import java.util.ArrayList;

public class Compra {
	private Cliente comprador;
	private String dataDaCompra;
	private List<Produto> produtosComprados;	
	
	public Compra(Cliente comprador, String dataDaCompra, List<Produto> produtosComprados) {		
		this.comprador = comprador;
		this.dataDaCompra = dataDaCompra;
		this.produtosComprados = produtosComprados;
	}
	
	public Compra(Cliente comprador, String dataDaCompra) {
		this.comprador = comprador;
		this.dataDaCompra = dataDaCompra;
		this.produtosComprados = new ArrayList<>();
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public String getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(String dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public double getTotalDaCompra() {
		double totalDaCompra = 0.0;
		
		for (Produto p : produtosComprados)  {
			totalDaCompra += p.getPreco();
		}
		
		return totalDaCompra;
	}
	
	public void setProdutosComprados(List<Produto> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}
	
	public void addProdutoComprado(Produto produtoComprado) {
		produtosComprados.add(produtoComprado);		
	}
	
	
	private String reciboDaCompra() {
		String recibo = "";
		
		for (Produto p : produtosComprados) {
			recibo += p.getNome() + "\t" + p.getPreco() + "\n";
		}
		
		recibo += "Total da compra: " + getTotalDaCompra();
		return recibo;
	}	
	
	@Override
	public String toString() {
		return  "Nome do comprador: " + comprador.getNome() + 
				"\n" + reciboDaCompra();
				
	}
	
}

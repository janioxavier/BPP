package pratica1.floricultura.dominio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Floricultura {
	private GerenciadorDeClientes gerenciadorDeClientes;
	private GerenciadorDeProdutos gerenciadorDeProdutos;
	private GerenciadorDeCompras gerenciadorDeCompras;
	
	public Floricultura() {
		gerenciadorDeClientes = new GerenciadorDeClientes();
		gerenciadorDeProdutos = new GerenciadorDeProdutos();
		gerenciadorDeCompras = new GerenciadorDeCompras();
	}
	
	public void cadastrarCliente(Cliente cliente) {
		gerenciadorDeClientes.addCliente(cliente);
	}
	
	public void cadastrarProduto(Produto produto) {
		gerenciadorDeProdutos.addProduto(produto);
	}
	
	public String realizarCompra(String nomeCliente, String nomeProduto) {
		String resultado = "";
		Cliente comprador = gerenciadorDeClientes.buscarCliente(nomeCliente);
		Produto produto = gerenciadorDeProdutos.buscarProduto(nomeProduto);
		StatusProduto estadoProduto;
		
		if (comprador != null) {
			resultado = adicionarCompra(nomeProduto, comprador, produto);
		} else {
			resultado = "Cliente não encontrado";
		}
		
		return resultado;
	}

	private String adicionarCompra(String nomeProduto, Cliente comprador, Produto produto) {
		String resultado;
		StatusProduto estadoProduto;
		estadoProduto = gerenciadorDeProdutos.diminuirEstoque(nomeProduto);
		resultado = estadoProduto.getStatus();
		if (estadoProduto == StatusProduto.DISPONIVEL)
			gerenciadorDeCompras.addCompra(new Compra(comprador, getDataAtual()), produto);
		return resultado;
	}
	
	public String finalizarCompra(String nomeCliente) {
		Compra compra = gerenciadorDeCompras.buscarCompra(nomeCliente);
		gerenciadorDeCompras.removerCompra(compra);
		return compra.toString();
	}
	
	private String getDataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String exibirClientes() {
		return gerenciadorDeClientes.listarClientesCadastrados();
	}
	
	public String exibirProdutos() {
		return gerenciadorDeProdutos.listarProdutosCadastrados();
	}
			
	public static void main(String[] args) {
		Floricultura floricultura = new Floricultura();
		
		Cliente[] clientes = {
				new Cliente("João Maria", "3033", "Travessa Santa Luzia", "99121-7641"),
				new Cliente("Cristina Quister", "0286", "Rua Joaquim", "99451-3644"),
				new Cliente("Sandra Rosenberg", "6668", "Rua São Bento", "98145-6887"),

		};
		
		Produto[] produtos = {
				new Produto("Pá", "Utilitário", 2.5, 10),
				new Produto("Flor de Lótus rara", "Flor", 15699.90, 1),
				new Produto("vaso rústico", "Vaso", 3.0, 459),
		};			
		
		// Cadastrar Clientes
		for (Cliente c:clientes) {
			floricultura.cadastrarCliente(c);
		}
		
		// Cadastrar Produtos
		for (Produto p:produtos) {
			floricultura.cadastrarProduto(p);
		}		
		
		//System.out.println(floricultura.exibirClientes());
		//System.out.println(floricultura.exibirProdutos());
		
		// realizar compra
		System.out.println(floricultura.realizarCompra("João Maria", "Pá"));
		System.out.println(floricultura.realizarCompra("João Maria", "Flor de Lótus rara"));
		System.out.println(floricultura.realizarCompra("João Maria", "Flor de Lótus rara"));
		System.out.println(floricultura.finalizarCompra("João Maria"));
	}
}

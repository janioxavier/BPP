package pratica1.floricultura.dominio;



public class Floricultura {
	private GerenciadorDeClientes gerenciadorDeClientes;
	private GerenciadorDeProdutos gerenciadorDeProdutos;
	
	public Floricultura() {
		gerenciadorDeClientes = new GerenciadorDeClientes();
		gerenciadorDeProdutos = new GerenciadorDeProdutos();
	}
	
	public void cadastrarCliente(Cliente cliente) {
		gerenciadorDeClientes.addCliente(cliente);
	}
	
	public void cadastrarProduto(Produto produto) {
		gerenciadorDeProdutos.addProduto(produto);
	}
	
	public void realizarCompra(String cliente, String produto) {
		
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
		
		System.out.println(floricultura.exibirClientes());
		System.out.println(floricultura.exibirProdutos());
	}
}

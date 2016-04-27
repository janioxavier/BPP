package pratica1.floricultura.dominio;

import java.util.List;
import java.util.ArrayList;

public class GerenciadorDeClientes {
	private List<Cliente> listaDeClientes;
	
	public GerenciadorDeClientes() {
		listaDeClientes = new ArrayList<>();
	}
	
	public void addCliente(Cliente cliente) {
		listaDeClientes.add(cliente);
	}
	
	public boolean hasCliente(Cliente cliente) {
		return listaDeClientes.contains(cliente);		
	}
	
	public Cliente buscarCliente(String nomeDoCliente) {
		Cliente clienteEncontrado = null;
		
		for (Cliente c : listaDeClientes) {
			if (c.getNome().equals(nomeDoCliente)) {
				clienteEncontrado = c;
				break;
			}
		}
		
		return clienteEncontrado;
	}
	
	public String listarClientesCadastrados() {
		String listaClientesCadastrados = "";
		
		int cont = 1;
		for (Cliente c:listaDeClientes) {
			listaClientesCadastrados += "\nCliente: " + cont++ + "\n";
			listaClientesCadastrados += c.toString() + "\n";			
		}
		
		return listaClientesCadastrados;
	}
}

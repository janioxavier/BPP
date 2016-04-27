package pratica1.floricultura.dominio;

import java.util.List;
import java.util.ArrayList;

public class GerenciadorDeCompras {
	private List<Compra> listaDeCompras;
	
	public GerenciadorDeCompras() {
		listaDeCompras = new ArrayList<>();
	}
	
	public void addCompra(Compra compra) {
		listaDeCompras.add(compra);
	}
	
	
}

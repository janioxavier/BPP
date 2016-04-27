package pratica1.floricultura.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdutoTest {	
	
	@Test
	public void testSetPrecoNegativo() {
		Produto produto = new Produto("Arroz", "Comida", 50, 1);
		produto.setPreco(-5);
		assertEquals(-5, produto.getPreco(), 0.5);
	}

	@Test
	public void testSetEstoque() {
		Produto produto = new Produto("Arroz", "Comida", 50, 1);
		produto.setEstoque(-1);
		assertEquals(-1, produto.getEstoque());
	}

}

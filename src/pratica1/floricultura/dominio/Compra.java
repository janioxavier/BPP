package pratica1.floricultura.dominio;

public class Compra {
	private Cliente comprador;
	private String dataDaCompra;
	private double totalDaCompra;
	
	public Compra(Cliente comprador, String dataDaCompra, double totalDaCompra) {
		super();
		this.comprador = comprador;
		this.dataDaCompra = dataDaCompra;
		this.totalDaCompra = totalDaCompra;
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
		return totalDaCompra;
	}

	public void setTotalDaCompra(double totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}
	
	
}

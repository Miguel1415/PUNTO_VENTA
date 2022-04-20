
public class DetalleVenta {
	private int cantidad;
	private Producto productos;
	
	public DetalleVenta(int cantidad, Producto productos) {	
		this.cantidad = cantidad;
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
		
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return productos;
	}

	public void setProducto(Producto productos) {
		this.productos = productos;
	}

		
}




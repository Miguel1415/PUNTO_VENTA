package PuntoVenta;


public class Producto {

	public static void main (String[] args) 
	{
		Producto p1 = new Producto();
		p1.setCodigo("CHICLE");
		p1.setNombre("chicle 2 asbor menta");
		p1.setPrecio(200);
	}

private String codigo;
private String nombre;
private int precio;

public Producto() {
	super();
}

public Producto(String codigo, String nombre, int precio) {
	super();
	this.setCodigo(codigo);
	this.setNombre(nombre);
	this.setPrecio(precio);
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getPrecio() {
	return precio;
}

public void setPrecio(int precio) {
	this.precio = precio;
}

}

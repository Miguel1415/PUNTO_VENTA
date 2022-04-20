import java.time.LocalDate;

import java.util.ArrayList;

public class Venta {

	private LocalDate fecha;
	private ArrayList<DetalleVenta> detalle = new ArrayList<>();
	
	public void agregarDetalleVenta(DetalleVenta detalleVenta) {	
		this.detalle.add(detalleVenta);
		this.fecha = LocalDate.now();
	}

	public Venta(LocalDate fecha, ArrayList<DetalleVenta> detalle) {
		
		this.fecha = fecha;
		this.detalle = detalle;
	}

	public Venta() {
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<DetalleVenta> getDetalle() {
		return detalle;
	}

	public void setDetalle(ArrayList<DetalleVenta> detalle) {
		this.detalle = detalle;
	}
	

}

package PuntoVenta;

import java.util.ArrayList;
import java.util.Calendar;

public class Venta {
	
	private Calendar fecha = Calendar.getInstance();
	private ArrayList<LineaDetalle> lineasDetalle = new ArrayList<>();
	
	
	public Venta(Calendar fecha, ArrayList<LineaDetalle> lineasdetalle) 
	{
		this.fecha= fecha;
		this.lineasDetalle=lineasdetalle;
	}


	public Venta() {
		super();
	}
	
	public void agregarListaDetalle(LineaDetalle lineadetalle) 
	{
		this.lineasDetalle.add(lineadetalle);
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public ArrayList<LineaDetalle> getLineasDetalle() {
		return lineasDetalle;
	}


	public void setLineasDetalle(ArrayList<LineaDetalle> lineasDetalle) {
		this.lineasDetalle = lineasDetalle;
	}
	
}

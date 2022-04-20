import java.util.Scanner;

/**
 * Maritza Carcamo
 * Miguel Olivera
 * Luciano Neira
 * Maria Maldonado
 * Gary Aburto
 * 
 */

import java.util.ArrayList;

public class Libreria {

	private static ArrayList<Producto>productos = new ArrayList<Producto>();
	private static ArrayList<Venta>ventas = new ArrayList<Venta>();
	
	// Constantes
	public final static int OPCION_MENU_CREAR				=1;
	public final static int OPCION_MENU_MOSTRAR				=2;
	public final static int OPCION_MENU_ELIMINAR			=3;
	public final static int OPCION_MENU_AGREGAR_AL_CARRO	=4;
	public final static int OPCION_MENU_CARGA				=5;
	public final static int OPCION_MENU_PAGO				=6;
	public final static int OPCION_MENU_SALIR				=7;
	
	public static int opcionSeleccionada;
	
	public static void main(String[] args) {
		
		int opcionSeleccionada;
		do {
				opcionSeleccionada = menu();
				switch (opcionSeleccionada) {
				
				case OPCION_MENU_CREAR:
					crearProducto();
					break;
					
				case OPCION_MENU_MOSTRAR:
					mostrarProducto();
					break;	
					
				case OPCION_MENU_ELIMINAR:
					eliminarProducto();
					break;
					
	/*			case OPCION_MENU_AGREGAR_AL_CARRO:
					agregarProductoCarro();
					break;
			*/
				case OPCION_MENU_CARGA:
					cargaProducto();
					break;
				
				case OPCION_MENU_PAGO:
					pagoProducto();
					break;
	
				
				}    
		}
		while (opcionSeleccionada != OPCION_MENU_SALIR);
		
		System.out.printf ("Selecciona la opcion %d", opcionSeleccionada);

	}

	private static void crearProducto() {
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println ("Ingrese el nombre: ");
		String nombreProducto = scanner.nextLine();
		
		System.out.println ("Ingrese el codigo: ");
		String codigoProducto = scanner.nextLine();
		
		System.out.println ("Ingrese el precio: ");
		int precioProducto = scanner.nextInt();
		
		Producto p1 = new Producto (nombreProducto, codigoProducto, precioProducto);
			productos.add(p1);
		
	}
	
	private static void mostrarProducto() {
		System.out.println (" _".repeat(24));
		System.out.println ("|\t\tPRODUCTOS \t\t\t|");
		System.out.println (" _".repeat(24));
		for (Producto producto:productos) {
		
			System.out.println ("|PRODUCTO: " +producto.getNombre()+ "\t\t\t|");
			System.out.println ("|CODIGO: " +producto.getCodigo()+ "\t\t\t\t\t|");
			System.out.println ("|PRECIO: " +producto.getPrecio()+ "\t\t\t\t\t|");
			System.out.println (" _".repeat(24));
		}
	}
	
	private static void eliminarProducto() {
		System.out.println ("Ingrese codigo del producto a eliminar: ");
		Scanner scanner = new Scanner (System.in);
		String codigo = scanner.nextLine();
		
		Producto producto = buscarProducto(codigo);
		if (producto != null) {
			productos.remove(producto);
			
			System.out.println (" _".repeat(20));
			System.out.printf("|EL PRODUCTO: " +producto.getNombre()+ " FUE ELIMINADO \t|\n");
			System.out.println (" _".repeat(20));
			} else {
				System.out.println (" _".repeat(20));
				System.out.printf ("|CODIGO NO EXISTE: " +codigo+ "\t\t|\n");
				System.out.println (" _".repeat(20));
				}
		}
	
	private static Producto buscarProducto(String codigo) {
		for (Producto producto:productos) {
			//COMPRARA SI SON IGUALES SIN IMPORTAR MAYUS O MINUS
	
			if(producto.getCodigo().equalsIgnoreCase(codigo)) {
	
				System.out.println (" _".repeat(20));
				System.out.println ("|CODIGO DEL PRODUCTO: " +producto.getCodigo()+ "\t\t\t|\n");
				System.out.println (" _".repeat(20));
				return producto;
			} 
		}
		return null;
	}
	
/*
	private static void agregarProductoCarro() {
		Venta venta = new Venta();
		boolean seguirAgregandoProductos = true;
		do {
			mostrarProducto();
			System.out.println ("Ingrese el codigo del producto a comprar: ");
			Scanner scanner = new Scanner (System.in);
			String codigo = scanner.nextLine();
			Producto producto = buscarProducto(codigo);
			
			if(producto !=null) {	
				System.out.println ("Ingrese la cantidad a comprar: ");
				int cantidad = scanner.nextInt();
			
				DetalleVenta DetalleVenta = new DetalleVenta (cantidad, producto);
				venta.agregarDetalleVenta (DetalleVenta);
				do {
					System.out.println ("Quiere agregar mas productos al carro: (si/no) ");
					String seguirAgregandoProductosStr = scanner.next();
					seguirAgregandoProductos=seguirAgregandoProductosStr.equalsIgnoreCase("si") ? true:false;
				} while (seguirAgregandoProductos);
			} else {
					System.out.println("Producto no existe");
			}
	
		Scanner scanner = new Scanner (System.in);
		System.out.println ("la venta fue pagada? (si/no)");
		boolean ventaPagada=scanner.nextLine().equalsIgnoreCase("si")? true:false;
			if (ventaPagada) {
				ventas.add(venta);
	
	}
			
			
*/
	private static void cargaProducto() {
		productos.add (new Producto ("cuaderno escolar", "cu1", 790));
		productos.add (new Producto ("cuaderno collage", "cu2", 990));
		productos.add (new Producto ("Lapiz BIC azul", "lba", 240));
		productos.add (new Producto ("Lapiz BIC negro", "lbn", 240));
		productos.add (new Producto ("Lapiz BIC rojo", "lbr", 240));
		productos.add (new Producto ("Lapiz FABER 2B", "l2b", 350));
		productos.add (new Producto ("Goma de borrar", "gbf", 290));
		productos.add (new Producto ("Sacapuntas MAPED", "sac", 590));	
		productos.add (new Producto ("Tijera MAPED 12cm", "tij", 1290));
		productos.add (new Producto ("Regla MAPED 30cm", "re3", 890));
	}
	
	private static void pagoProducto() {
		//int pagoEntregado = 20000;
		int totalVenta = 0;
		
		
		Scanner scanner = new Scanner (System.in);
		System.out.println ("Ingrese monto con que va a pagar");
		int pagoEntregado = scanner.nextInt();
		
		for (Producto producto:productos) {
			totalVenta +=producto.getPrecio();
		}
		System.out.println("El total de la compra es: " +totalVenta);
		System.out.println("El pago entregado es: " +pagoEntregado);
		
		if(pagoEntregado == totalVenta)
		{
			System.out.println("COMPRA REALIZADA CON EXITO");
		}
		else if (pagoEntregado < totalVenta)
			{
				System.out.println("Pago incompleto. Por favor efectuar el pago en su totalidad");
			}
			else
			{
				System.out.println("Compra exitosa. Su cambio es: " +(pagoEntregado-totalVenta));
			}
	}
	

	private static int menu() {
		System.out.println (" _".repeat(20));
		System.out.println ("|                                       |");
		System.out.println ("|\t MENU PRINCIPAL \t\t|");
		System.out.println (" _".repeat(20));
		System.out.println ("|\n\t 1. CREAR PRODUCTOS \t\t|");
		System.out.println ("|\t 2. MOSTRAR PRODUCTOS \t\t|");
		System.out.println ("|\t 3. ELIMINAR PRODUCTOS \t\t|");
		System.out.println ("|\t 4. AGREGAR AL CARRO \t\t|");
		System.out.println ("|\t 5. CARGA PRODUCTOS \t\t|");
		System.out.println ("|\t 6. PAGAR COMPRA \t\t|");
		System.out.println ("|\t 8. SALIR 	\t\t|");
		System.out.println (" _".repeat(20));
		System.out.println ("\n    DIGITE LA OPCION DESEADA: \t");
			Scanner scanner = new Scanner (System.in);
			int opcionSeleccionada = scanner.nextInt();
			return opcionSeleccionada;
		
	}
}
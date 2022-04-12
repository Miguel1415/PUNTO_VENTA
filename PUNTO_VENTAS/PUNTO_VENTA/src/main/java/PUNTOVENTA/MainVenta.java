package PUNTOVENTA;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Miguel Olivera
 */

public class MainVenta 
{
	   // formate fecha 
		static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		private static ArrayList<Producto> productos = new ArrayList<Producto>();
		private static ArrayList<Venta> ventas = new ArrayList<Venta>();
		
		static Scanner scanner = new Scanner(System.in);
		
		public final static int OPCION_MENU_REGISTRAR = 1;
		public final static int OPCION_MENU_ELIMINAR = 2;
		public final static int OPCION_MENU_LISTA = 3;
		public final static int OPCION_MENU_VENTAS = 4;
		public final static int OPCION_MENU_COMPRAR = 5;
		public final static int OPCION_MENU_REPORTE = 6;
		public final static int OPCION_MENU_SALIR = 7;
		
		public static void main(String[] args) 
		{
			

			
			int opcionMenu;		
			
			do {
				opcionMenu = menu();
				
				System.out.printf("Ha seleccionado la opcion %d \n \n", opcionMenu);
				
				// Segun la opcion elegida, se ejecuta lo correspondiente
				switch(opcionMenu) 
				{
					case OPCION_MENU_REGISTRAR:
						registrarProducto();
						break;
					case OPCION_MENU_ELIMINAR:
						eliminarProducto();
						break;
					case OPCION_MENU_LISTA:
						verListaProductos();
						break;
					case OPCION_MENU_VENTAS:
						verVentasProductos();
						break;
					case OPCION_MENU_COMPRAR:
						comprarProductos();
						break;
					case OPCION_MENU_REPORTE:
						generarReporte();
						break;
					case OPCION_MENU_SALIR:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opcion seleccionada no valida. Vuelva a intentarlo");
						break;
				}
				
			} while(opcionMenu != OPCION_MENU_SALIR);
			
		}

		private static void registrarProducto() 
		{
			scanner.nextLine();
			System.out.println("Ingrese codigo producto");
			String codigoProducto = scanner.nextLine();

			System.out.println("Ingrese nombre producto");
			String nombreProducto = scanner.nextLine();
			
			System.out.println("Ingrese precio para del producto");
			int precioProducto = scanner.nextInt();
			
			Producto nuevoProducto = new Producto(codigoProducto, nombreProducto, precioProducto);
			productos.add(nuevoProducto);
			
		}	
		
		private static void eliminarProducto() 
		{
			scanner.nextLine();
			System.out.println("Digite el codigo del producto a eliminar: ");
			String codigo = scanner.nextLine();
			System.out.println(codigo);
			
			Producto producto = buscarProducto(codigo);
			if (producto != null) {
				productos.remove(producto);
				System.out.printf("Se ha eliminado el producto: %s %n%n", producto.getNombre());
			}
			else
			{
				System.out.printf("No se ha encontrado el producto %n%n");
			}
			
		}

		private static void verListaProductos() 
		{
			System.out.println("\n PRODUCTOS ENCONTRADOS");
			System.out.println("==============");
			
			for (Producto producto : productos) 
			{
				System.out.printf("Codigo: %s Producto: %s Precio: %d %n", producto.getCodigo(), producto.getNombre(), producto.getPrecio());
				System.out.println("--------------------------------------------------");
			}
			System.out.println("\n\n");

			
			
		}

		private static void comprarProductos() 
		{
			Venta venta = new Venta();
			boolean seguirAgregandoProductos = true;
			
			do 
			{
			verListaProductos();
			scanner.nextLine(); 
			System.out.println("Escriba el codigo del producto que desea comprar: ");
			String codigo = scanner.nextLine();
			
			Producto producto = buscarProducto(codigo);
			
			System.out.println("Escriba la cantidad que desea comprar: ");
			int cantidad = scanner.nextInt();
			
			//Crea una linea de detalle con el producto y su la cantidad
			LineaDetalle lineaDetalle = new LineaDetalle(cantidad,producto);
			venta.agregarLineaDetalle(lineaDetalle);
			
			System.out.println("¿Desea agregar mas productos al carro? (si/no)");
			
			seguirAgregandoProductos = scanner.next().equalsIgnoreCase("SI") ? true : false;
			} 
			while (seguirAgregandoProductos == true);
			
			ventas.add(venta);
			
			
		}

		private static void verVentasProductos() 
		{
			System.out.println("\n VENTAS");
			System.out.println("==============");
			
			for (Venta venta : ventas) 
			{			
				System.out.printf(" Fecha: %s %n", formateador.format(venta.getFecha()));
				System.out.println(venta.productosTotales());
				System.out.printf(" Total: %s %n", venta.calcularTotal());
				System.out.println("--------------------------------------------------");
			}
			System.out.println("\n\n");			
		}

		private static void generarReporte()
		{
			
			String nombreArchivo = "REPORTE_VENTAS";
			
			String contenidoArchivo = "REPORTE VENTAS\n==============\n";

			// Por cada venta realizada, se anota la fecha, los productos vendidos y el total de cada un de las ventas.
			for (Venta venta : ventas) {
				contenidoArchivo += "Fecha: "+ formateador.format(venta.getFecha())+"\n";
				contenidoArchivo += venta.productosTotales()+"\n";
				contenidoArchivo += "Total: "+venta.calcularTotal()+"\n";
				contenidoArchivo += "-----------------------------------------------\n";
			}
			
			//Utiliza un try-catch para atrapar exepciones para con esto evitar que el programa deje de funcionar.
			try {
				
				FileWriter writer = new FileWriter(nombreArchivo);
				writer.write(contenidoArchivo);
				writer.close();
				
				System.out.println("Reporte generado exitosamente");
				
			} 
			catch(IOException ioe) 
			{
				System.out.println("Fallo al generar el reporte.");
			}
			
		}
		
		private static Producto buscarProducto(String codigo) 
		{
			for (Producto p: productos) 
			{
				if (p.getCodigo().equalsIgnoreCase(codigo)) 
				{
					return p;
				}
			}
			return null;
		}

		private static int menu() 
		{
			System.out.println("Menu Punto de venta testMarket:\n");
			System.out.println("1. Registrar producto");
			System.out.println("2. Eliminar producto");
			System.out.println("3. Ver lista de productos");
			System.out.println("4. Ver ventas realizadas");
			System.out.println("5. Agregar productos al carro");
			System.out.println("6. Generar reporte");
			System.out.println("7. Salir \n");

			System.out.println("Seleccione una opcion del 1 al 7");

			// toma valor dado por el usuario y lo convierte a int 
			int opcionSeleccionada = scanner.nextInt(); 
			
			// luego lo retorna a main.
			return opcionSeleccionada;
		}
}

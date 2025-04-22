import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        //crear cuatro productos
        Producto p1 =new Producto("123","Fideos",1800.0,5,CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("456","MIcroondas",12200.0,2,CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("789","Computadora",5000.0,3,CategoriaProducto.ELECTRONICA);
        Producto p4 = new Producto("159","Platos de ceramica",250.50,8,CategoriaProducto.HOGAR);
        Producto p5 = new Producto("111","Cacerola",450.20,4,CategoriaProducto.HOGAR);



       //listar los productos en el inventario
       Inventario inventario = new Inventario();
       inventario.agregarProducto(p1);
       inventario.agregarProducto(p2);
       inventario.agregarProducto(p3);
       inventario.agregarProducto(p4);
       inventario.agregarProducto(p5);

       //buscar producto por su id

        System.out.println("Ingrese el id del producto buscado: ");
        String idBuscado = input.nextLine();
        //llamar al metedo de la clase Inventario
        System.out.println(inventario.buscarProductoPorId(idBuscado));
        System.out.println("-------------------------------------------");





       //mostrar por consola
        System.out.println("-------------------------------------------");
        System.out.println("----Productos Existentes----");
        inventario.listarProductos();
        System.out.println();
        System.out.println("-------------------------------------------");



        //filtrar por categoria
        ArrayList<Producto> electro = inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        //mostrar
        System.out.println("Productos de la categoria ELECTRONICA:");
        for (Producto electros: electro){
            System.out.println(electros);

        }
        System.out.println("-------------------------------------------");

        //eliminar un producto por id y listar los productos restantes
        System.out.println("Ingrese el id del producto que desea eliminar: ");
        String idRemover = input.nextLine();
        inventario.eliminarProducto(idRemover);

        //mostrar de nuevo los productos
        inventario.listarProductos();
        int stockTotal = inventario.obtenerTotalStock();
        System.out.println("Total Stock disponible: "+stockTotal);

        //obtener el producto con mayor Stock y mostrar
        Producto productoMayorStock = inventario.obtenerProductoConMayorStock();
        System.out.println("El producto con mayor stock es: "+ productoMayorStock);
        System.out.println();

        //filtrar productos con precios entre 1000 y 3000
        ArrayList<Producto> preciosFiltrados = inventario.filtrarProductosPorPrecio(1000,3000);
        System.out.println("Productos con precios entre $1000 y $3000: ");
        for (Producto producto:preciosFiltrados){
            System.out.println(producto);
        }
        System.out.println();

        //mostrar las categorias disponibles
        inventario.mostrarCategoriasDisponibles();



    }
}

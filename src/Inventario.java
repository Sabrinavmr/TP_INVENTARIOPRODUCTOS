import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public Inventario(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    //Busca el id pedido por el usuario mediante un for

    public Producto buscarProductoPorId(String id){
        //logica para encontrar el id buscado con un for each
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                //retornamos el valor buscado
                return producto;
            }
        }

        /* Logica con for normal:
        for (int i = 0; i <productos.size() ; i++) {
            if (productos.get(i).getId().equals(id) ){
                //retornamos el valor buscado
                return productos.get(i);
            }else{
                System.out.println("id no encontrado");
            }
        }
         */

        return null; //no encontrado
    }

    public void eliminarProducto(String id) {
        //logica para eliminar el id buscado
        /*for (Producto producto: productos){
            if (producto.getId().equals(id)){
                productos.remove(producto);
            }
        }*/
        Iterator<Producto> it = productos.iterator();

        while (it.hasNext()) {
            Producto p = it.next(); // accede al siguiente elemento
            if (p.getId().equals(id)) {
                it.remove(); //  elimina de forma segura
            }

            //otra logica mas simple
            //productos.removeIf(producto -> producto.getId().equals(id));
        }
    }


    //Actualizamos el stock de la unidad
    public void actualizarStock(String id, int nuevaCantidad){
        for (Producto producto:productos){
            if (producto.getId().equals(id)){
                producto.setCantidad(nuevaCantidad);
            }
        }
    }

    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoriaProducto){
        ArrayList<Producto> listaPedida = new ArrayList<>();
        for (Producto producto:productos){
            if (producto.getCategoriaProducto().equals(categoriaProducto)){
                listaPedida.add(producto);
            }else{

            }
        }

        return listaPedida;
    }



    public void listarProductos(){
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i));
        }

        /*
        for each:
        for (Producto producto : productos) {
            System.out.println(producto);
        }
         */
    }

    public int obtenerTotalStock(){
        int totalStock = 0;

        for (Producto producto: productos){
            totalStock += producto.getCantidad();
        }

        return totalStock;
    }


    public Producto obtenerProductoConMayorStock(){

        //intanciamos un  objeto, guardando el valor 0 de productos
        Producto mayorStock = productos.get(0);

        for (Producto producto: productos){
            //si la cantidad del producto ES MAYOR a la cantidad de mayorStock
            if (producto.getCantidad()> mayorStock.getCantidad()){
                mayorStock = producto;
                return mayorStock;
            }
        }
       return null;
    }


    //devuelve productos dentro de un rango de precios
    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max){
        ArrayList<Producto> preciosBuscados = new ArrayList<>();
        for (Producto producto : productos){
            if (producto.getPrecio()>=min && producto.getPrecio()<=max){
                preciosBuscados.add(producto);
            }
        }
        return preciosBuscados;
    }

    public void mostrarCategoriasDisponibles(){
        System.out.println("Categorias Disponibles:");
        System.out.println(CategoriaProducto.ALIMENTOS.getDescripcion());
        System.out.println(CategoriaProducto.ROPA.getDescripcion());
        System.out.println(CategoriaProducto.ELECTRONICA.getDescripcion());
        System.out.println(CategoriaProducto.HOGAR.getDescripcion());
    }
}

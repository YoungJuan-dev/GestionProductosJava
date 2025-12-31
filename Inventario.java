package GestionDeProductos;

import java.util.ArrayList;

public class Inventario {

    public Inventario() {
    }

    ArrayList<Productos> productos = new ArrayList<Productos>();

    public int tamañoLista() {
        return productos.size();
    }

    public void agregarProducto(String codigoBuscado, Productos producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigoBuscado)) {
                System.out.println("No se pudo agregar el producto, ya que contiene el mismo codigo que otro producto.");
                return;
            }
        }
        productos.add(producto);
        System.out.println("Se agregó correctamente el producto");
    }

    public void buscarPorCodigo(String codigoBuscado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigoBuscado)) {
                System.out.println("El producto buscado es: " + productos.get(i));
                return;
            }
        }
        System.err.println("No existe el producto buscado, o hubo un error.");
    }

    public void eliminarProducto(String codigoBuscado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigoBuscado)) {
                productos.remove(i);
                System.out.println("Se elimino correctamente el producto.");
                return;
            }
        }
        System.err.println("No se pudo eliminar el producto, ya que no existe o no se encontro.");
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles para mostrar.");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println(productos.get(i));
            }
        }
    }

    public void actualizarPrecio(String codigoBuscado, Integer nuevoPrecio) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigoBuscado)) {
                productos.get(i).setPrecio(nuevoPrecio);
                System.out.println("Se actualizo el precio del producto.");
                return;
            }
        }
        System.err.println("No se encontro el producto para modificar su precio.");

    }
}

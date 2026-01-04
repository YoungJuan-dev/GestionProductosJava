package GestionDeProductos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out
                        .println("No se pudo agregar el producto, ya que contiene el mismo codigo que otro producto.");
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

    public void guardadoDeDatos() {
        try {
            String rutaOriginal = System.getProperty("user.dir");
            File carpeta = new File(rutaOriginal + File.separator + "Productos");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }
            File archivo = new File(carpeta, "ProductosGuardados.txt");
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
                for (int i = 0; i < productos.size(); i++) {
                    String lectura = productos.get(i).getCodigo() + ";" +
                            productos.get(i).getNombre() + ";" +
                            productos.get(i).isDisponible() + ";" +
                            productos.get(i).getPrecio() + ";" +
                            productos.get(i).getCategoria() + ";" +
                            productos.get(i).getDescripcion();
                    escritor.write(lectura);
                    escritor.newLine();
                }
                System.out.println("ruta: " + archivo.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("ha ocurrido un error :( " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error :( " + e.getMessage());
        }
    }

    public void cargarDatos() {
        try {
            String rutaOriginal = System.getProperty("user.dir");
            File carpeta = new File(rutaOriginal + File.separator + "Productos");
            File archivo = new File(carpeta, "ProductosGuardados.txt");

            try (BufferedReader lector = new BufferedReader(new java.io.FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datos = linea.split(";");
                    String codigo = datos[0];
                    String nombre = datos[1];
                    boolean disponible = Boolean.parseBoolean(datos[2]);
                    int precio = Integer.parseInt(datos[3]);
                    String categoria = datos[4];
                    String descripcion = datos[5];

                    Productos producto = new Productos(codigo, nombre, precio, disponible, categoria, descripcion);
                    productos.add(producto);
                }
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}

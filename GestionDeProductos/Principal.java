package GestionDeProductos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventario gestor = new Inventario();
        int opcion;
        String codigo, nombre, categoria, descripcion, codigoBuscado;
        int nuevoPrecio, precio;
        boolean disponible = true;
        gestor.cargarDatos();
        System.out.println("¡Bienvenido!");
        do {
            try {
                System.out.println("--GESTOR DE PRODUCTOS V1.1--");
                System.out.println("1) Agregar producto.");
                System.out.println("2) Eliminar producto.");
                System.out.println("3) Mostrar productos.");
                System.out.println("4) Actualizar precio de un producto.");
                System.out.println("5) Buscar producto por codigo.");
                System.out.println("0) Salir.");
                opcion = input.nextInt();
                switch (opcion) {
                    case 1:
                        input.nextLine();
                        System.out.println("Ingresa el codigo del producto.");
                        codigo = input.nextLine();
                        System.out.println("Ingrese el nombre del producto.");
                        nombre = input.nextLine();
                        System.out.println("Ingrese el precio del producto $.");
                        precio = input.nextInt();
                        input.nextLine();
                        System.out.println("Ingrese la categoria del producto.");
                        categoria = input.nextLine();
                        System.out.println("Ingrese la descripcion del producto.");
                        descripcion = input.nextLine();

                        Productos producto = new Productos(codigo, nombre, precio, disponible, categoria, descripcion);
                        gestor.agregarProducto(codigo, producto);
                        gestor.guardadoDeDatos();
                        break;
                    case 2:
                        input.nextLine();
                        System.out.println("Ingrese el codigo del producto a eliminar.");
                        codigoBuscado = input.nextLine();
                        gestor.eliminarProducto(codigoBuscado);
                        gestor.guardadoDeDatos();
                        break;
                    case 3:
                        System.out.println("Productos disponibles -- Cantidad de productos:" + gestor.tamañoLista());
                        gestor.mostrarProductos();
                        break;
                    case 4:
                        input.nextLine();
                        System.out.println("Ingrese el codigo del producto a modificar su precio.");
                        codigoBuscado = input.nextLine();
                        System.out.println("Ingrese el nuevo precio del producto $.");
                        nuevoPrecio = input.nextInt();
                        input.nextLine();
                        gestor.actualizarPrecio(codigoBuscado, nuevoPrecio);
                        gestor.guardadoDeDatos();
                        break;
                    case 5:
                        input.nextLine();
                        System.out.println("Ingrese el codigo del producto a buscar.");
                        codigoBuscado = input.nextLine();
                        gestor.buscarPorCodigo(codigoBuscado);
                        break;
                    case 0:
                        System.out.println("Gracias por probar nuestra version V1 del programa :)");
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.err.println("Ingrese una opcion valida dentro del programa.");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Error critico, ingresaste una letra o numero en un espacio donde no debias.");
                input.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);
        input.close();
    }
}

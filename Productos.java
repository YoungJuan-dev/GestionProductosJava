package GestionDeProductos;

public class Productos {
    private String codigo;
    private String nombre;
    private int precio;
    private boolean disponible = true;
    private String categoria;
    private String descripcion;

    public Productos(String codigo, String nombre, int precio, boolean disponible, String categoria,
            String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.categoria = categoria;
        this.descripcion = descripcion;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                " | Nombre: " + nombre +
                " | Precio: $" + precio +
                " | Disponible: " + disponible +
                " | Categoría: " + categoria +
                " | Descripción: " + descripcion;
    }
}

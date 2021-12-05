package Entidades;

public class Inventario {

    private String categoria;
    private String nombre;
    private double precio;
    private int cantidad;
    private String codigo;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Inventario(String categoria, String nombre, double precio, int cantidad, String codigo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }



    public Inventario() {
    }

    @Override
    public String toString() {
        return "Inventario{" + "categoria=" + categoria + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", codigo=" + codigo + '}';
    }

}

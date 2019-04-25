package Clases_Modelos;

public class Producto {
    private int id_stock;
    private String codigo;
    private String Producto;
    private int cantidad;
    private double precio;
    private String marca;
    private float gravamen;
    private double precioGravamen;

    public Producto(int id_stock, String codigo, String Producto, int cantidad, double precio, String marca, float gravamen, double precioGravamen) {
        this.id_stock = id_stock;
        this.codigo = codigo;
        this.Producto = Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.marca = marca;
        this.gravamen = gravamen;
        this.precioGravamen = precioGravamen;
    }

    public Producto(String codigo, String Producto, int cantidad, double precio, String marca, float gravamen, double precioGravamen) {
        this.codigo = codigo;
        this.Producto = Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.marca = marca;
        this.gravamen = gravamen;
        this.precioGravamen = precioGravamen;
    }

    public Producto() {
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getGravamen() {
        return gravamen;
    }

    public void setGravamen(float gravamen) {
        this.gravamen = gravamen;
    }

    public double getPrecioGravamen() {
        return precioGravamen;
    }

    public void setPrecioGravamen(double precioGravamen) {
        this.precioGravamen = precioGravamen;
    }

}
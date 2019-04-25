package Clases_Modelos;

public class Cliente {

    private int id_cliente;
    private String cl_nombre;
    private int cl_dni;
    private String cl_direccion;

    public Cliente(int id_cliente, String cl_nombre, int cl_dni, String cl_direccion) {
        this.id_cliente = id_cliente;
        this.cl_nombre = cl_nombre;
        this.cl_dni = cl_dni;
        this.cl_direccion = cl_direccion;
    }

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCl_nombre() {
        return cl_nombre;
    }

    public void setCl_nombre(String cl_nombre) {
        this.cl_nombre = cl_nombre;
    }

    public int getCl_dni() {
        return cl_dni;
    }

    public void setCl_dni(int cl_dni) {
        this.cl_dni = cl_dni;
    }

    public String getCl_direccion() {
        return cl_direccion;
    }

    public void setCl_direccion(String cl_direccion) {
        this.cl_direccion = cl_direccion;
    }
}

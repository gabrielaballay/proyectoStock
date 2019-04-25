package Clases_Modelos;

public class Empleado {
    private int id_empleado;
    private String apellido;
    private String nombre;
    private int dni;
    private String direccion;

    public Empleado(int id_empleado, String apellido, String nombre, int dni, String direccion) {
        this.id_empleado = id_empleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Empleado(String apellido, String nombre, int dni, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Empleado() {
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String toString(){
        return id_empleado +" - "+ apellido + " " + nombre;
    }
}

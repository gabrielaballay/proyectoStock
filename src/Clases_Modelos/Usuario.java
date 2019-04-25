package Clases_Modelos;

public class Usuario {
    private int id_usuario;
    private String nombres;
    private int dni;
    private String usuario;
    private String password;
    private String tipoUser;

    public Usuario(int id_usuario, String nombres, int dni, String usuario, String password, String tipoUser) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public Usuario(String nombres, int dni, String usuario, String password, String tipoUser) {
        this.nombres = nombres;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
}

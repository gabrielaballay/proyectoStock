package Clases_Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private final String URL = "jdbc:mysql://localhost/tienda2";
    private final String USUARIO = "root";
    private final String PASS = "";
    private Connection conexion;
    
    public Connection getConexion(){
        conexion=null;
        try {
            if (conexion == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, PASS);
            }
            return conexion;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex, "Atención", 1);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
}

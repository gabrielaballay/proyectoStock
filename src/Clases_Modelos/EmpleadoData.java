package Clases_Modelos;

import Frame_Vistas.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoData extends Conexion {
    private Connection con = getConexion();

    public void cargarEmpleado(Empleado emp) {
        try {
            String sql = "INSERT INTO empleado (apellido,nombre,dni,direccion, estado)"
                    + "VALUES (?,?,?,?, true);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, emp.getApellido());
            ps.setString(2, emp.getNombre());
            ps.setInt(3, emp.getDni());
            ps.setString(4, emp.getDireccion());
            ps.execute();
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex, "error al guardar un empleado",0);
        }
    }

    public ArrayList listarEmpleado() {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try {
            String sql = "SELECT * FROM empleado;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Empleado e;
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    e = new Empleado();
                    e.setId_empleado(rs.getInt("id_empleado"));
                    e.setApellido(rs.getString("apellido"));
                    e.setNombre(rs.getString("nombre"));
                    e.setDni(rs.getInt("dni"));
                    e.setDireccion(rs.getString("direccion"));
                    empleados.add(e);
                }
            }
            ps.close();
            //con.close();
            return empleados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"error al listar empleado",0);
            return null;
        }
    }

    public void eliminarEmpleado(int dni) {
        try {
            String sql = "UPDATE empleado SET estado=false WHERE dni= ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(MenuPrincipal.Opciones, "Se Elimino El Empleado Correctamente", "Atencion", 1);

            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex, "error al intentar eliminar un empleado",0);
        }
    }

    public void actualizaEmpleado(Empleado emp, int dni) {
        try {
            String sql = "UPDATE empleado SET apellido= ? , nombre= ? , dni = ? ,"
                    + "direccion = ? WHERE dni = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, emp.getApellido());
            ps.setString(2, emp.getNombre());
            ps.setInt(3, emp.getDni());
            ps.setString(4, emp.getDireccion());
            ps.setInt(5, dni);
            ps.executeUpdate();
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex, "error al intentar modificar un empleado",0);
        }
    }

    public Empleado buscarEmpleado(int id) {
        Empleado e = null;
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    e = new Empleado();
                    e.setId_empleado(rs.getInt("id_empleado"));
                    e.setApellido(rs.getString("apellido"));
                    e.setNombre(rs.getString("nombre"));
                    e.setDni(rs.getInt("dni"));
                    e.setDireccion(rs.getString("direccion"));
                }
            }
            ps.close();
            //con.close();
            return e;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex, "error al buscar un empleado",0);
            return null;
        }
    }
}

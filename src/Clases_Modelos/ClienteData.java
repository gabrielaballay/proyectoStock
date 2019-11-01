package Clases_Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteData extends Conexion {
    private Connection con = getConexion();

    public int guardarCliente(Cliente cl) {
        String sql = "INSERT INTO cliente (cl_nombre, cl_dni, cl_direccion, estado) VALUES ( ? , ? ,? , true );";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getCl_nombre());
            ps.setInt(2, cl.getCl_dni());
            ps.setString(3, cl.getCl_direccion());
            ps.execute();
            ps.close();
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar un cliente " + ex);
            return 0;
        }
    }

    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Cliente cl;
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    cl = new Cliente();
                    cl.setId_cliente(rs.getInt("id_cliente"));
                    cl.setCl_nombre(rs.getString("cl_nombre"));
                    cl.setCl_dni(rs.getInt("cl_dni"));
                    cl.setCl_direccion(rs.getString("cl_direccion"));
                    clientes.add(cl);
                }
            }
            ps.close();
            return clientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar un cliente " + ex);
            return null;
        }
    }

    public Cliente buscarCliente(int clDni) {
        Cliente cl = null;
        String sql = "SELECT * FROM cliente WHERE cl_dni = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, clDni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    cl = new Cliente();
                    cl.setId_cliente(rs.getInt("id_cliente"));
                    cl.setCl_nombre(rs.getString("cl_nombre"));
                    cl.setCl_dni(rs.getInt("cl_dni"));
                    cl.setCl_direccion(rs.getString("cl_direccion"));
                }
            }
            ps.close();
            return cl;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar un cliente " + ex);
            return null;
        }        
    }

    public void eliminarCliente(Cliente cl) {
        String sql = "UPDATE cliente SET estado=false WHERE id_cliente  = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Borrar un cliente " + ex);
        }
    }

    public int actualizarCliente(Cliente cl) {
        String sql = "UPDATE cliente SET cl_nombre = ?, cl_dni = ?, cl_direccion = ? WHERE id_cliente = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getCl_nombre());
            ps.setInt(2, cl.getCl_dni());
            ps.setString(3, cl.getCl_direccion());
            ps.setInt(4, cl.getId_cliente());
            ps.execute();
            ps.close();
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar un cliente " + ex);
            return 0;
        }
    }

    public Cliente buscarClId(int id) {
        Cliente cl = null;
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    cl = new Cliente();
                    cl.setId_cliente(rs.getInt("id_cliente"));
                    cl.setCl_nombre(rs.getString("cl_nombre"));
                    cl.setCl_dni(rs.getInt("cl_dni"));
                    cl.setCl_direccion(rs.getString("cl_direccion"));
                }
            }
            ps.close();
            return cl;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar un cliente " + ex);
            return null;
        }
    }
}

package Clases_Modelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentaData extends Conexion {
    private Venta venta=new Venta();
    private Connection con = getConexion();

    public boolean cargarVenta(Venta v) {
        LocalDate fe;

        PreparedStatement ps = null;
        String sql = "INSERT INTO ventas (nro_Factura, Fecha,interesTar,descuento,sub_total,total,id_empleado,id_cliente)"
                + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, v.getNro_Factura());
            fe = LocalDate.parse(v.getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            ps.setDate(2, Date.valueOf(fe));
            ps.setFloat(3, v.getIn_tarjeta());
            ps.setFloat(4, v.getDescuento());
            ps.setDouble(5, v.getSub_total());
            ps.setDouble(6, v.getTotal());
            ps.setInt(7, v.getId_emp().getId_usuario());
            ps.setInt(8, v.getCl().getId_cliente());

            ps.executeUpdate();
            ps.close();
            //con.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al guardar una Venta", 0);
            return false;
        }
    }

    public ArrayList listarVentas() {
        Venta venta=null;
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ventas;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta=new Venta();
                venta.setNro_Factura(rs.getInt("nro_Factura"));
                venta.setFecha(rs.getDate("fecha") + "");
                venta.setIn_tarjeta(rs.getFloat("interesTar"));
                venta.setDescuento(rs.getFloat("descuento"));
                venta.setSub_total(rs.getDouble("sub_total"));
                venta.setTotal(rs.getDouble("total"));
                Usuario e = new Usuario();
                e.setId_usuario(rs.getInt("id_empleado"));
                venta.setId_emp(e);
                Cliente c =new  Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));            
                venta.setCl(c);
                ventas.add(venta);
            }
            ps.close();
            //con.close();
            return ventas;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error a Listar una Venta", 0);
            return null;
        }        
    }

    public Venta BuscarVenta(int nro) {
        Venta venta = null;
        try {
            String sql = "SELECT * FROM ventas WHERE nro_Factura= ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta=new Venta();
                venta.setNro_Factura(rs.getInt("nro_Factura"));
                venta.setFecha(rs.getDate("fecha") + "");
                venta.setIn_tarjeta(rs.getFloat("interesTar"));
                venta.setDescuento(rs.getFloat("descuento"));
                venta.setSub_total(rs.getDouble("sub_total"));
                venta.setTotal(rs.getDouble("total"));
                Usuario e = buscarEmpleado(rs.getInt("id_empleado"));
                Cliente c = buscarCliente(rs.getInt("id_cliente"));
                venta.setCl(c);
                venta.setId_emp(e);
            }
            ps.close();
            return venta;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al buscar una venta", 0);
            return null;
        }
        
    }

    public Usuario buscarEmpleado(int id) {
        UsuarioData ed = new UsuarioData();
        return ed.buscarEmpleado(id);
    }

    public Cliente buscarCliente(int id) {
        ClienteData cd = new ClienteData();
        return cd.buscarClId(id);
    }
}

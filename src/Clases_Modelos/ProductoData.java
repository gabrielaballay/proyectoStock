package Clases_Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoData extends Conexion {
private Connection con =getConexion();

    public void cargarProducto(Producto p) {

        try {
            String sql = "INSERT INTO producto (codigo,producto,cantidad,precio,marca,gravamen,precioGravamen)"
                    + " VALUES ( ? , ? , ? , ? , ? , ? , ? );";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getProducto());
            ps.setInt(3, p.getCantidad());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getMarca());
            ps.setFloat(6, p.getGravamen());
            ps.setDouble(7, p.getPrecioGravamen());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setId_stock(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "error al obtener id depues de\n insertar un producto", "Atencion", 0);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al guardar un producto", 0);
        }

    }

    public ArrayList listarProducto() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            String sql = "SELECT * FROM producto;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Producto producto;
            while (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getString("codigo"));
                producto.setProducto(rs.getString("producto"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setMarca(rs.getString("marca"));
                producto.setGravamen(rs.getFloat("gravamen"));
                producto.setPrecioGravamen(rs.getDouble("precioGravamen"));
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al listar producto", 0);
        }
        return productos;
    }

    public void actiualizarProducto(Producto producto, String cod) {
        try {
            String sql = "UPDATE producto SET codigo= ? , producto= ? , cantidad = ? ,"
                    + "precio = ? , marca = ? , gravamen = ? , precioGravamen = ? WHERE codigo = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getProducto());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio());
            ps.setString(5, producto.getMarca());
            ps.setFloat(6, producto.getGravamen());
            ps.setDouble(7, producto.getPrecioGravamen());
            ps.setString(8, cod);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al actualizar un producto", 0);
        }
    }

    public void borrarProducto(String cod) {
        try {
            String sql = "DELETE FROM producto WHERE codigo= ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Producto se Elimino\n en forma Correcta", "Atencion", 1);
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al borrar un producto", 0);
        }

    }

    public Producto buscarProducto(String cod) {
        Producto p = null;
        String sql = "SELECT * FROM producto WHERE codigo = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cod);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p = new Producto();
                p.setId_stock(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("Codigo"));
                p.setProducto(rs.getString("producto"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getDouble("precio"));
                p.setMarca(rs.getString("marca"));
                p.setGravamen(rs.getFloat("gravamen"));
                p.setPrecioGravamen(rs.getDouble("precioGravamen"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al buscar un producto", 0);
        }
        return p;
    }

    public Producto buscarProductoId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM producto WHERE id_producto = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p = new Producto();
                p.setId_stock(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("Codigo"));
                p.setProducto(rs.getString("producto"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecio(rs.getDouble("precio"));
                p.setMarca(rs.getString("marca"));
                p.setGravamen(rs.getFloat("gravamen"));
                p.setPrecioGravamen(rs.getDouble("precioGravamen"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al buscar un producto", 0);
        }
        return p;
    }

    public void actiualizarProductoVenta(int can, String cod) {
        try {
            String sql = "UPDATE producto SET cantidad = ? WHERE codigo = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, can);
            ps.setString(2, cod);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al actualizar un producto", 0);
        }
    }
}

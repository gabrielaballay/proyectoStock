package Clases_Modelos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductoData extends Conexion {
private Connection con =getConexion();

    public void cargarProducto(Producto p) {
        try {
            String sql = "INSERT INTO producto (codigo,producto,cantidad,precio,marca,gravamen,precioGravamen,proveedor,categoria, estado) "
                    + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , true);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getProducto());
            ps.setInt(3, p.getCantidad());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getMarca());
            ps.setFloat(6, p.getGravamen());
            ps.setDouble(7, p.getPrecioGravamen());
            ps.setString(8, p.getProveedor());
            ps.setString(9, p.getCategoria());
            ps.execute();
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al guardar un producto", 0);            
        }
    }

    public ArrayList listarProducto() {
        Producto p=null;
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            String sql = "SELECT * FROM producto;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    p=new Producto();
                    p.setCodigo(rs.getString("codigo"));
                    p.setProducto(rs.getString("producto"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setMarca(rs.getString("marca"));
                    p.setGravamen(rs.getFloat("gravamen"));
                    p.setPrecioGravamen(rs.getDouble("precioGravamen"));
                    p.setProveedor(rs.getString("proveedor"));
                    p.setCategoria(rs.getString("categoria"));
                    productos.add(p);
                }
            }
            ps.close();
            //con.close();
            return productos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al listar producto", 0);
            return null;
        }
    }

    public void actiualizarProducto(Producto producto, String cod) {
        try {
            String sql = "UPDATE producto SET codigo= ? , producto= ? , cantidad = ? ,"
                    + "precio = ? , marca = ? , gravamen = ? , precioGravamen = ? , proveedor = ? ,"
                    + "categoria = ? WHERE codigo = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getProducto());
            ps.setInt(3, producto.getCantidad());
            ps.setDouble(4, producto.getPrecio());
            ps.setString(5, producto.getMarca());
            ps.setFloat(6, producto.getGravamen());
            ps.setDouble(7, producto.getPrecioGravamen());
            ps.setString(8, producto.getProveedor());
            ps.setString(9, producto.getCategoria());
            ps.setString(10, cod);
            ps.executeUpdate();
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al actualizar un producto", 0);
        }
    }

    public void borrarProducto(String cod) {
        try {
            String sql = "UPDATE producto SET estado=false WHERE codigo= ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Producto se Elimino\n en forma Correcta", "Atencion", 1);
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al borrar un producto", 0);
        }
    }

    public Producto buscarProducto(String cod) {
        Producto p=null;
        String sql = "SELECT * FROM producto WHERE codigo=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    p=new Producto();
                    p.setId_stock(rs.getInt("id_producto"));
                    p.setCodigo(rs.getString("Codigo"));
                    p.setProducto(rs.getString("producto"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setMarca(rs.getString("marca"));
                    p.setGravamen(rs.getFloat("gravamen"));
                    p.setPrecioGravamen(rs.getDouble("precioGravamen"));
                    p.setProveedor(rs.getString("proveedor"));
                    p.setCategoria(rs.getString("categoria"));
                }
            }
            ps.close();
            //con.close();
            return p;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al buscar un producto aca", 0);
            return null;
        }
    }

    public Producto buscarProductoId(int id) {
        Producto p=null;
        String sql = "SELECT * FROM producto WHERE id_producto = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if(rs.getBoolean("estado")){
                    p=new Producto();
                    p.setId_stock(rs.getInt("id_producto"));
                    p.setCodigo(rs.getString("Codigo"));
                    p.setProducto(rs.getString("producto"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setMarca(rs.getString("marca"));
                    p.setGravamen(rs.getFloat("gravamen"));
                    p.setPrecioGravamen(rs.getDouble("precioGravamen"));
                }
            }
            ps.close();
            return p;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al buscar un producto", 0);
            return null;
        }
    }

    public void actiualizarProductoVenta(int can, String cod) {
        try {
            String sql = "UPDATE producto SET cantidad = ? WHERE codigo = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, can);
            ps.setString(2, cod);
            ps.executeUpdate();
            ps.close();
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error al actualizar un producto", 0);
        }
    }
    
    public ArrayList<VentaTotales> ventaCategoria(String fecha,String fecha2){
        try {
            LocalDate f=LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate f2=LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            //JOptionPane.showMessageDialog(null, f);
            ArrayList<VentaTotales> listaCategoria=new ArrayList();
            String sql="CALL ventasCategoria( ? , ? );";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(f));
            ps.setDate(2, Date.valueOf(f2));
            ResultSet rs=ps.executeQuery();
            VentaTotales vts;
            while(rs.next()){
                vts=new VentaTotales();
                vts.setCantidad(rs.getInt("cantidad"));
                vts.setProveedor(rs.getString("proveedor"));
                vts.setTotalcompra(rs.getFloat("totalcompra"));
                vts.setTotalventa(rs.getFloat("totalventa"));
                vts.setGanancia(rs.getFloat("ganancia"));
                listaCategoria.add(vts);
            }
            ps.close();
            //con.close();
            return listaCategoria;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

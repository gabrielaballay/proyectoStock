package Clases_Modelos;

import Frame_Vistas.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Venta_Detalle_Data extends Conexion{
    Connection con=getConexion();
    
    public boolean cargarDetalleV(Venta_Detalle vd){
        PreparedStatement ps=null;
        String sql="INSERT INTO detalleventas (nro_Factura, cantProductoFactura,imp_Total, id_producto)"
                + "VALUES ( ? , ? , ? , ? );";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, vd.getNroFact().getNro_Factura());
            ps.setInt(2, vd.getCantFact());
            ps.setDouble(3, vd.getImpTotal());
            ps.setInt(4, vd.getId_pro().getId_stock());
                        
            ps.execute();
            ps.close();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(MenuPrincipal.Opciones, ex,"Error al cargar Factura",0);
            return false;
        }
    }
    
    public ArrayList<Venta_Detalle> listarDetalleVentas(){
        
        ArrayList<Venta_Detalle> vdetalle=new ArrayList<>();
        Venta_Detalle vd = null;        
        try{
            String sql="SELECT * FROM detalleventas;";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vd=new Venta_Detalle();
                vd.setId_detalle(rs.getInt("id_detalle"));
                Venta ven=buscarVenta(rs.getInt("nro_Factura"));
                vd.setNroFact(ven);
                vd.setCantFact(rs.getInt("cantProductoFactura"));
                vd.setImpTotal(rs.getDouble("imp_Total"));
                Producto p=buscarProductoId(rs.getInt("id_producto"));
                vd.setId_pro(p);
                vdetalle.add(vd);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(MenuPrincipal.Opciones, ex,"Error al Listar Factura",0);
        }
        return vdetalle;
    }
    
    public Venta buscarVenta(int nro){
        VentaData vd=new VentaData();
        return vd.BuscarVenta(nro);
    }
    
    public Producto buscarProductoId(int id){
        ProductoData pd=new ProductoData();
        return pd.buscarProductoId(id);
    }
}

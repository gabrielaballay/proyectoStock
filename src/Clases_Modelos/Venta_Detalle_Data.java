package Clases_Modelos;

import Frame_Vistas.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Venta_Detalle_Data extends Conexion{
        
    public boolean cargarDetalleV(Venta_Detalle vd){
        Connection con=getConexion();
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
    
    public ArrayList<Venta_Detalle> listarDetalleVentas(int cel){
        Connection con=getConexion();
        ArrayList<Venta_Detalle> vdetalle=new ArrayList<>();
        Venta_Detalle vd = null;        
        try{
            String sql="SELECT * FROM detalleventas WHERE nro_Factura=?;";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, cel);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vd=new Venta_Detalle();
                vd.setId_detalle(rs.getInt("id_detalle"));
                Venta ven=new Venta();
                ven.setNro_Factura(rs.getInt("nro_Factura"));
                vd.setNroFact(ven);
                vd.setCantFact(rs.getInt("cantProductoFactura"));
                vd.setImpTotal(rs.getDouble("imp_Total"));
                Producto p=new Producto();
                p.setId_stock(rs.getInt("id_producto"));
                vd.setId_pro(p);
                vdetalle.add(vd);
            }
            ps.close();
            return vdetalle;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(MenuPrincipal.Opciones, ex,"Error al Listar Factura",0);
            return null;
        }
        
    }    
}

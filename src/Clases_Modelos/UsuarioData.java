package Clases_Modelos;

import Frame_Vistas.Login2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioData extends Conexion {
private Connection con=getConexion();
    
    public boolean guardarUsuario(Usuario U){
        try {
            String sql="INSERT INTO usuarios (apellido_nombre,dni,usuario,password,tipoUser, estado)"
                    + "VALUES (?,?,?,?,?,true);";
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, U.getNombres());
            ps.setInt(2, U.getDni());
            ps.setString(3, U.getUsuario());
            ps.setString(4, U.getPassword());
            ps.setString(5, U.getTipoUser());
            ps.execute();
            ps.close();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al guardar un Usuario",0);
            return false;
        }
    }
    
    public ArrayList listarUsuario(){
        ArrayList<Usuario> usuarios=new ArrayList<>();
        try{
            String sql="SELECT * FROM usuarios;";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Usuario u;
            while(rs.next()){
                if(rs.getBoolean("estado")){
                    u=new Usuario();
                    u.setNombres(rs.getString("apellido_nombre"));
                    u.setDni(rs.getInt("dni"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setPassword(rs.getString("password"));
                    u.setTipoUser(rs.getString("tipoUser"));
                    usuarios.add(u);
                }
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex,"Error al listar usuario",0);
        }
        return usuarios;
    }
    
    public int existeUsuario(String users){
        try {
            ResultSet rs=null;
            String sql="SELECT count(id_usuario), estado FROM usuarios WHERE usuario=?;";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, users);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBoolean("estado")){
                    return rs.getInt(1);
                }
                return 0;
            }
            ps.close();
            return 1;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al verificar Usuario",0);
            return 1;
        }
    }

    public boolean login(Usuario users){
        try {
            ResultSet rs=null;
            String sql="SELECT id_usuario,apellido_nombre,usuario,password,tipoUser,estado FROM usuarios WHERE usuario=?;";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1,users.getUsuario() );
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBoolean("estado")){
                    if(users.getPassword().equals(rs.getString(4))&&users.getTipoUser().equals(rs.getString(5))){
                        users.setId_usuario(rs.getInt(1));
                        users.setUsuario(rs.getString(3));
                        users.setPassword(rs.getString(4));
                        users.setTipoUser(rs.getString(5));
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(Login2.log1, "Usuario o contraseña incorrectos!!!");
                        return false;
                    }
                }
            }
            ps.close();
            return false;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al verificar Usuario",0);
            return false;
        }
    }
    
    public boolean loginAd(Usuario users){
        try {
            ResultSet rs=null;
            String sql="SELECT password,tipoUser, estado FROM usuarios WHERE password=?;";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1,users.getPassword());
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBoolean("estado")){
                    if(rs.getString(2).equals("Administrador")){
                        users.setPassword(rs.getString(1));
                        users.setTipoUser(rs.getString(2));
                        ps.close();
                        return true;
                    }else{
                        ps.close();
                        return false;
                    }
                }
            }
            ps.close();
            return false;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al verificar Usuario",0);
            return false;
        }
    }
    
    public void eliminarUsuario(int dni){
        try {
            String sql="UPDATE usuarios SET estado=false WHERE dni= ?;";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.executeUpdate();
            
            ps.close();
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al borrar un Usuario",0);
        }
    }
    
    public Usuario buscarUsuario(String users){
        try {
            Usuario user=new Usuario();
            ResultSet rs=null;
            String sql="SELECT * FROM usuarios WHERE usuario=?;";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setString(1, users);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBoolean("estado")){
                    user.setId_usuario(rs.getInt(1));
                    user.setNombres(rs.getString(2));
                    user.setDni(rs.getInt(3));
                    user.setUsuario(rs.getString(4));
                }
            }
            ps.close();
            return user;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al verificar Usuario",0);
            return null;
        }
    }
    
    public Usuario buscarEmpleado(int id){
        try {
            Usuario us=new Usuario();
            ResultSet rs=null;
            String sql="SELECT * FROM usuarios WHERE id_usuario=?;";
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                if(rs.getBoolean("estado")){
                    us.setId_usuario(rs.getInt(1));
                    us.setNombres(rs.getString(2));
                    us.setDni(rs.getInt(3));
                    us.setUsuario(rs.getString(4));
                }
            }
            ps.close();
            return us;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex,"Error al verificar Usuario",0);
            return null;
        }
    }
}

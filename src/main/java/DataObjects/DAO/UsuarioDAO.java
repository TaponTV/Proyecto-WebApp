package DataObjects.DAO;

import java.sql.*;
import java.util.*;
import DataObjects.DBConnection.ConnectionDB;
import DataObjects.interfaces.usuarioInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

public class UsuarioDAO implements usuarioInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Usuario obj = null;
    public static final String insertSQL = "INSERT INTO "
            + "Usuario (nombre, apPaterno, apMaterno, idGenero, edad, direccion, celular, telefono, email, pswrd, idRol)"
            + "VALUES (?,?,?,?,?,row(?,?,?,?),?,?,?,?,?)";

    public UsuarioDAO() {
        connect = ConnectionDB.getConnection();
    }

    public boolean create(Usuario ob) {
        try {

            ps = connect.prepareStatement(insertSQL);
            ps.setString(1, ob.getNombre());
            ps.setString(2, ob.getApPaterno());
            ps.setString(3, ob.getApMaterno());
            ps.setInt(4, ob.getIdGenero());
            ps.setInt(5, ob.getEdad());
            ps.setString(6, ob.getPais());
            ps.setString(7, ob.getEstado());
            ps.setString(8, ob.getCiudad());
            ps.setString(9, ob.getCalle());
            ps.setString(10, ob.getCelular());
            ps.setString(11, ob.getTelefono());
            ps.setString(12, ob.getEmail());
            ps.setString(13, ob.getPswrd());
            ps.setInt(14, ob.getIdRol());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
    }

    public List<Usuario> read() {
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            ps = connect.prepareStatement("SELECT * FROM Usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String nombre = rs.getString("nombre");
                String apPaterno = rs.getString("apPaterno");
                String apMaterno = rs.getString("apMaterno");
                int idGenero = rs.getInt("idGenero");
                int edad = rs.getInt("edad");
                String pais = rs.getString("direccion.pais");
                String estado = rs.getString("direccion.estado");
                String ciudad = rs.getString("direccion.ciudad");
                String calle = rs.getString("direccion.calle");
                String celular = rs.getString("celular");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String pswrd = rs.getString("pswrd");
                int idRol = rs.getInt("idRol");
                obj = new Usuario(idUser, nombre, apPaterno, apMaterno, idGenero, edad, pais, estado, ciudad, calle, celular, telefono, email, pswrd, idRol);
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
        return list;
    }

    public Usuario showUser(int _idUser) {
        try {
            ps = connect.prepareStatement("SELECT * FROM Usuario WHERE idUser = ?");
            ps.setInt(1, _idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String nombre = rs.getString("nombre");
                String apPaterno = rs.getString("apPaterno");
                String apMaterno = rs.getString("apMaterno");
                int idGenero = rs.getInt("idGenero");
                int edad = rs.getInt("edad");
                String pais = rs.getString("direccion");
                String estado = rs.getString("direccion");
                String ciudad = rs.getString("direccion");
                String calle = rs.getString("direccion");
                String celular = rs.getString("celular");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String pswrd = rs.getString("pswrd");
                int idRol = rs.getInt("idRol");
                obj = new Usuario(idUser, nombre, apPaterno, apMaterno, idGenero, edad, pais, estado, ciudad, calle, celular, telefono, email, pswrd, idRol);
                return obj;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
        return obj;
    }

    public boolean update(Usuario ob) {
        return false;
        // TODO Auto-generated method stub

    }

    public boolean delete(int id) {
        return false;
        // TODO Auto-generated method stub

    }

    @Override
    public int validate(String str_e, String str_p) {
        int idUser = 0;
        try {
            ps = connect.prepareStatement("SELECT * FROM Usuario WHERE email = ? and pswrd = ?");
            ps.setString(1, str_e);
            ps.setString(2, str_p);
            rs = ps.executeQuery();
            if (rs.next()) {
                idUser = rs.getInt("idUser");
                return idUser;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
        return 0;
    }

    @Override
    public int currentUser(int idUser) {
        try {
            ps = connect.prepareStatement("SELECT idRol FROM Usuario WHERE idUser = ? ");
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            if (rs.next()) {
                int rol = rs.getInt("idRol");
                return rol;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
        return 0;
    }

    @Override
    public int count() {
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Usuario");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return 0;
    }

}

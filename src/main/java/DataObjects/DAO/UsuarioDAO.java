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
    private Usuario obj = new Usuario();
    public static final String insertSQL = "INSERT INTO "
            + "Usuario (nombre, apPaterno, apMaterno, idGenero, edad, direccion, celular, telefono, email, pswrd, idRol)"
            + "VALUES (?,?,?,?,?,row(?,?,?,?),?,?,?,?,?)";

    public UsuarioDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
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
        } finally {
            ConnectionDB.closeDB(ps);
        }
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            ps = connect.prepareStatement("SELECT idUser,nombre,apPaterno,apMaterno,edad,(direccion).pais AS pais,(direccion).estado AS estado,email,roldesc AS tipoUsuario "
                    + "FROM Usuario\n"
                    + "JOIN rol\n"
                    + "ON rol.idrol = usuario.idrol\n"
                    + "WHERE usuario.idRol <> 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String nombre = rs.getString("nombre");
                String apPaterno = rs.getString("apPaterno");
                String apMaterno = rs.getString("apMaterno");
                int edad = rs.getInt("edad");
                String pais = rs.getString("pais");
                String estado = rs.getString("estado");
                String email = rs.getString("email");
                String rol = rs.getString("tipoUsuario");
                obj = new Usuario(idUser, nombre, apPaterno, apMaterno, edad, pais, estado, email, rol);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }

    @Override
    public Usuario showUser(int _idUser) {
        try {
            ps = connect.prepareStatement("SELECT "
                    + "idUser,"
                    + "nombre,"
                    + "apPaterno,"
                    + "apMaterno,"
                    + "edad,"
                    + "(direccion).pais AS pais,"
                    + "(direccion).estado AS estado,"
                    + "(direccion).ciudad AS ciudad,"
                    + "(direccion).calle AS calle,"
                    + "celular,"
                    + "telefono,"
                    + "email,"
                    + "usuario.idRol,"
                    + "roldesc AS tipoUsuario "
                    + "FROM Usuario\n"
                    + "JOIN rol\n"
                    + "ON rol.idrol = usuario.idrol\n"
                    + "WHERE idUser = ?");
            ps.setInt(1, _idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("idUser");
                String nombre = rs.getString("nombre");
                String apPaterno = rs.getString("apPaterno");
                String apMaterno = rs.getString("apMaterno");
                int edad = rs.getInt("edad");
                String pais = rs.getString("pais");
                String estado = rs.getString("estado");
                String ciudad = rs.getString("ciudad");
                String calle = rs.getString("calle");
                String celular = rs.getString("celular");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String rol = rs.getString("tipousuario");
                int idRol = rs.getInt("idrol");
                obj = new Usuario(idUser, nombre, apPaterno, apMaterno, edad, pais, estado, ciudad, calle, celular, telefono, email, rol, idRol);
                return obj;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return obj;
    }

    @Override
    public boolean update(Usuario ob) {
        return false;
        // TODO Auto-generated method stub

    }

    @Override
    public boolean delete(int id) {
        try{
            ps = connect.prepareStatement("DELETE FROM usuario WHERE iduser = ?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            ConnectionDB.closeDB(ps);
        }

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
        } finally {
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
        } finally {
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
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return 0;
    }

}

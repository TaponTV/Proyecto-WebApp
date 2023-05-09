package DataObjects.DAO;

import java.sql.*;
import java.util.*;
import DataObjects.DBConnection.ConnectionDB;
import DataObjects.interfaces.usuarioInterface;
import models.Usuario;

public class UsuarioDAO implements usuarioInterface{
	private Connection connect = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private Usuario obj = null;
	private static final String selectSQL = "SELECT * FROM Usuario";
	public static final String insertSQL = "INSERT INTO "
                + "Usuario(nombre,apPaterno,apMaterno,idGenero,edad,direccion,celular,telefono,email,pswrd,idRol) "
                + "VALUES (?,?,?,?,?,row(?,?,?,?),?,?,?,?,?)";
	
	public UsuarioDAO() {
            connect = ConnectionDB.getConnection();
	}
	
	public boolean create(Usuario ob) {
            try{
                
                ps = connect.prepareStatement(insertSQL);
                ps.setString(1, ob.getNombre());
                ps.setString(1, ob.getApPaterno());
                ps.setString(1, ob.getApMaterno());
                ps.setInt(1, ob.getIdGenero());
                ps.setInt(1, ob.getEdad());
                ps.setString(1, ob.getPais());
                ps.setString(1, ob.getEstado());
                ps.setString(1, ob.getCiudad());
                ps.setString(1, ob.getCalle());
                ps.setString(1, ob.getCelular());
                ps.setString(1, ob.getTelefono());
                ps.setString(1, ob.getEmail());
                ps.setString(1, ob.getPswrd());
                ps.setInt(1, ob.getIdRol());
                ps.execute();
               
                return true;
            }catch(SQLException ex){
                ex.printStackTrace();
                return false;
            }
	}
	
	public List<Usuario> read() {
            List<Usuario> list = new ArrayList<Usuario>();
            try {
		ps = connect.prepareStatement(selectSQL);
		rs = ps.executeQuery();
		while(rs.next()) {
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
                    obj = new Usuario(idUser,nombre,apPaterno,apMaterno,idGenero,edad,pais,estado,ciudad,calle,celular,telefono,email,pswrd,idRol); 
                    list.add(obj);
		}
            }catch(SQLException ex) {
		ex.printStackTrace();
		return null;
            }
            return list;
	}
	
	public Usuario showUser(int _idUser) {
		try {
			ps = connect.prepareStatement(selectSQL+" WHERE idUser = ?");
			ps.setInt(1, _idUser);
			rs = ps.executeQuery();
			while(rs.next()) {
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
				obj = new Usuario(idUser,nombre,apPaterno,apMaterno,idGenero,edad,pais,estado,ciudad,calle,celular,telefono,email,pswrd,idRol);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
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
    public boolean isAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	

}

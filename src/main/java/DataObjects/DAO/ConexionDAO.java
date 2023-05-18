package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;
import DataObjects.interfaces.conexionInterface;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Conexion;

public class ConexionDAO implements conexionInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Conexion obj = null;
    private List<Conexion> list;
    public static final String insertSQL = "INSERT INTO Conexion (idUser, fechaconexion, fechadesconexion) VALUES (?,?,?)";
    public static final String updateSQL = "UPDATE Conexion SET fechadesconexion = ? WHERE idConexion = ?";

    public ConexionDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Conexion ob) {
        try {
            ps = connect.prepareStatement(insertSQL);
            ps.setInt(1, ob.getIdUser());
            ps.setTimestamp(2, Timestamp.valueOf(ob.getFechaConexion()));
            ps.setTimestamp(3, Timestamp.valueOf(ob.getFechaDesconexion()));
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
    public List<Conexion> read() {

        return null;
    }

    @Override
    public boolean update(Conexion ob) {
        try {
            ps = connect.prepareStatement(updateSQL);
            ps.setTimestamp(1, Timestamp.valueOf(ob.getFechaDesconexion()));
            ps.setInt(2, ob.getIdConexion());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeDB(ps);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getRowID(int idUser, String tmsp) {
        try {
            ps = connect.prepareStatement("SELECT * FROM Conexion WHERE idUser = ? and fechaconexion = ?");
            ps.setInt(1, idUser);
            ps.setTimestamp(2, Timestamp.valueOf(tmsp));
            rs = ps.executeQuery();
            if (rs.next()) {
                int idRow = rs.getInt("idConexion");
                return idRow;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeDB(ps);
        }
        return 0;
    }

    @Override
    public int count() {
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Conexion");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Conexion> ListOne(int idUser) {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT fechaconexion, fechadesconexion FROM conexion WHERE idUser = ?");
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fechaconexion = rs.getString("fechaconexion");
                String fechadesconexion = rs.getString("fechadesconexion");
                obj = new Conexion(idUser, fechaconexion, fechadesconexion);
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

}

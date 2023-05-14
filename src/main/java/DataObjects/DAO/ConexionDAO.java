package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;
import DataObjects.interfaces.conexionInterface;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Conexion;

public class ConexionDAO implements conexionInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Conexion obj = null;
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
        // TODO Auto-generated method stub
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

}

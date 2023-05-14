package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.solicitudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Solicitud;

public class SolicitudDAO implements solicitudInterface {
    
    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    public SolicitudDAO(){
        connect = ConnectionDB.getConnection();
    }

    public boolean create(Solicitud ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Solicitud> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Solicitud ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int count() {
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Solicitud");
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

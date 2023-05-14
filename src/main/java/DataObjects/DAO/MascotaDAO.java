package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.mascotaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Mascota;

public class MascotaDAO implements mascotaInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    public MascotaDAO(){
        connect = ConnectionDB.getConnection();
    }
    
    public boolean create(Mascota ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Mascota> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Mascota ob) {
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
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Mascota");
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

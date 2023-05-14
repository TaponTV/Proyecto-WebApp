package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.veterinarioInterface;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Veterinario;

public class VeterinarioDAO implements veterinarioInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Veterinario obj = null;
    private final String insertSQL = "INSERT INTO Veterinario (idVeterinario,cedula,idUser,especialidad,universidad,fechaTitulacion) VALUES (?,?,?,?,?,?)";
    
    public VeterinarioDAO(){
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Veterinario ob) {
        try{
            ps = connect.prepareStatement(insertSQL);
            ps.setString(1, ob.getIdVeterinario());
            ps.setString(2, ob.getCedula());
            ps.setInt(3, ob.getIdUser());
            ps.setString(4, ob.getEspecialidad());
            ps.setString(5, ob.getUniversidad());
            ps.setDate(6, Date.valueOf(ob.getFechaTitulacion()));
            ps.execute();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
        }
    }

    @Override
    public List<Veterinario> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Veterinario ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getRowID(int idUser) {
        try {
            ps = connect.prepareStatement("SELECT * FROM Veterinario WHERE idUser = ?");
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            if (rs.next()) {
                String idRow = rs.getString("idVeterinario");
                return idRow;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeDB(ps);
        }
        return null;
    }

    @Override
    public int count() {
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Veterinario");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}

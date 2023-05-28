package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.mascotaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Mascota;

public class MascotaDAO implements mascotaInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private List<Mascota> list;
    private Mascota obj;
    
    public MascotaDAO(){
        connect = ConnectionDB.getConnection();
    }
    
    @Override
    public boolean create(Mascota ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Mascota> read(int ClientID) {
        try{
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT * FROM mascota WHERE idcliente = ?");
            ps.setInt(1, ClientID);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Mascota();
                obj.setIdMascota(rs.getInt("idmascota"));
                obj.setIdCliente(rs.getInt("idcliente"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEdad(rs.getInt("edad"));
                obj.setFechaNac(rs.getString("fechanac"));
                obj.setRaza(rs.getString("raza"));
                obj.setIdEspecie(rs.getInt("idespecie"));
                list.add(obj);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            ConnectionDB.closeDB(ps);
            ConnectionDB.closeDB(rs);
        }
        return list;
    }

    @Override
    public List<Mascota> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Mascota ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int PetID) {
        try{
            ps = connect.prepareStatement("DELETE FROM mascota WHERE idmascota = ?");
            ps.setInt(1, PetID);
            return ps.executeUpdate()>0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            ConnectionDB.closeDB(ps);
        }
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

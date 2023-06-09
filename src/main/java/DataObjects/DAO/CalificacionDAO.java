package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.calificacionInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Calificacion;

public class CalificacionDAO implements calificacionInterface {

    private Connection connect;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Calificacion obj;
    private List<Calificacion> list;

    public CalificacionDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Calificacion ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Calificacion> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Calificacion ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    /**
     * This method is used to list the comments made by a client. Makes a query
     * to the database, making use of an identifier and returning a list of type
     * "Calificacion"
     *
     * @param ClientID type Int
     * @return list type Calificacion
     */
    public List<Calificacion> ListOne(int idCliente) {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT * FROM Calificacion WHERE idcliente = ?");
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                createObj(rs);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(ps);
            ConnectionDB.closeDB(rs);
        }
    }

    @Override
    public List<Calificacion> ListOne(String idVeterinario) {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT * FROM Calificacion WHERE idVeterinario = ?");
            ps.setString(1, idVeterinario);
            rs = ps.executeQuery();
            while (rs.next()) {
                createObj(rs);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }

    private void createObj(ResultSet rs) throws SQLException {
        obj = new Calificacion();
        obj.setIdCalificacion(rs.getInt("idcalificacion"));
        obj.setIdVeterinario(rs.getString("idveterinario"));
        obj.setIdCliente(rs.getInt("idcliente"));
        obj.setIdPrivacidad(rs.getInt("idprivacidad"));
        obj.setCalificacion(rs.getInt("calificacion"));
        obj.setComentario(rs.getString("comentario"));

    }

    @Override
    public int Score(String idVeterinario) {
        try{
            ps = connect.prepareStatement("SELECT AVG(calificacion) as score FROM calificacion WHERE idVeterinario = ?");
            ps.setString(1, idVeterinario);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("score");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return 0;
    }

}

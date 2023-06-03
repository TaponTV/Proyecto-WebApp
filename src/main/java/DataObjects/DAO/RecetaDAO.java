package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.recetaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Receta;

public class RecetaDAO implements recetaInterface {

     private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Receta obj = null;
    private List<Receta> list;
    
    public RecetaDAO(){
        connect = ConnectionDB.getConnection();
    }
    
    public boolean create(Receta ob) {
        try{
            ps = connect.prepareStatement("INSERT INTO receta (idconsulta, medicamento, tipoadministracion, horario, detalles) VALUES (?,?,?,?,?)");
            ps.setInt(1, ob.getIdConsulta());
            ps.setString(2, ob.getMedicamento());
            ps.setString(3, ob.getTipoAdministracion());
            ps.setString(4, ob.getHorario());
            ps.setString(5, ob.getDetalles());
            return ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            ConnectionDB.closeDB(ps);
        }
    }

    public List<Receta> read(int idConsulta) {
        try{
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT * FROM receta WHERE idconsulta = ?");
            ps.setInt(1, idConsulta);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Receta();
                obj.setMedicamento(rs.getString("medicamento"));
                obj.setTipoAdministracion(rs.getString("tipoadministracion"));
                obj.setHorario(rs.getString("horario"));
                obj.setDetalles(rs.getString("detalles"));
                obj.setIdConsulta(idConsulta);
                list.add(obj);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return null;
    }

    public boolean update(Receta ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Receta> read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

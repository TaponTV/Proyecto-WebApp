package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.generosInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Generos;

public class GenerosDAO implements generosInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Generos obj = null;
    
    public GenerosDAO(){
        connect = ConnectionDB.getConnection();
    }

    public boolean create(Generos ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Generos> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Generos ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int check(String g) {
        try{
            ps = connect.prepareStatement("SELECT idGenero FROM Generos WHERE genero = ?");
            ps.setString(1, g);
            rs = ps.executeQuery();
            if(rs.next()){
                int idGenero = rs.getInt("idGenero");
                return idGenero;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            ConnectionDB.closeDB(ps);
            //ConnectionDB.closeDB(connect);
        }
        return 0;
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.clienteInterface;
import java.sql.*;
import models.Cliente;

public class ClienteDAO implements clienteInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Cliente obj = null;
    public static final String insertSQL = "INSERT INTO Cliente (idUser) VALUES (?)";

    public ClienteDAO() {
        connect = ConnectionDB.getConnection();
    }
    
    public boolean create(Cliente ob) {
        try {
            ps = connect.prepareStatement(insertSQL);
            ps.setInt(1, ob.getIdUser());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
        }
    }

    public List<Cliente> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Cliente ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}

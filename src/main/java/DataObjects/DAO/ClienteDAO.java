package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.clienteInterface;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;

public class ClienteDAO implements clienteInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Cliente obj = null;
    private static final String selectSQL = "";
    public static final String insertSQL = "INSERT INTO Cliente (idUser) VALUES (?)";

    public ClienteDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
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

    @Override
    public List<Cliente> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Cliente ob) {
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
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Cliente");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}

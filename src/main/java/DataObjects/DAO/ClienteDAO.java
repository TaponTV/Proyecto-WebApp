package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.clienteInterface;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;

public class ClienteDAO implements clienteInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Cliente obj;
    private List<Cliente> list;

    public ClienteDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Cliente ob) {
        try {
            ps = connect.prepareStatement("INSERT INTO Cliente (idUser) VALUES (?)");
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
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT \n"
                    + " Cliente.idCliente, "
                    + "	Usuario.idUser, \n"
                    + "	Usuario.nombre,\n"
                    + "	Usuario.apPaterno,\n"
                    + "	Usuario.apMaterno,\n"
                    + " Usuario.edad\n"
                    + "FROM Usuario\n"
                    + "JOIN Cliente\n"
                    + "ON Cliente.idUser = Usuario.idUser");
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Cliente();
                obj.setIdUser(rs.getInt("idUser"));
                obj.setNombre(rs.getString("nombre"));
                obj.setApPaterno(rs.getString("apPaterno"));
                obj.setApMaterno(rs.getString("apMaterno"));
                obj.setIdCliente(rs.getInt("idcliente"));
                obj.setEdad(rs.getInt("edad"));
                list.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return list;
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

package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.especieInterface;
import java.sql.*;
import java.util.ArrayList;
import models.Especie;

public class EspecieDAO implements especieInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private List<Especie> list;
    private Especie obj;

    public EspecieDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Especie ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Especie> read() {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT * FROM especie");
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Especie();
                obj.setIdEspecie(rs.getInt("idespecie"));
                obj.setEspecie(rs.getString("especie"));
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

    @Override
    public boolean update(Especie ob) {
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

}

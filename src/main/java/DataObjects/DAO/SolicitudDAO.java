package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.solicitudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Solicitud;

public class SolicitudDAO implements solicitudInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Solicitud obj;
    private List<Solicitud> list;

    public SolicitudDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Solicitud ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Solicitud> read() {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT solicitud.idsolicitud, c.nombre, v.nombre AS nombreV, solicitud.fecha, estado.estado \n"
                    + "FROM usuario c\n"
                    + "JOIN cliente ON c.idUser = cliente.idUser\n"
                    + "JOIN solicitud ON cliente.idCliente = solicitud.idCliente\n"
                    + "JOIN veterinario ON solicitud.idVeterinario = veterinario.idVeterinario\n"
                    + "JOIN usuario v ON veterinario.idUser = v.idUser\n"
                    + "JOIN estado ON solicitud.idEstado = estado.idestado;");
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Solicitud();
                obj.setIdSolicitud(rs.getInt("idSolicitud"));
                obj.setNombre(rs.getString("nombre"));
                obj.setvNombre(rs.getString("nombreV"));
                obj.setFecha(rs.getString("fecha"));
                obj.setStatus(rs.getString("estado"));
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
    public boolean update(Solicitud ob
    ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id
    ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int count() {
        try {
            ps = connect.prepareStatement("SELECT COUNT(*) FROM Solicitud");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return 0;
    }

    public List<Solicitud> ListDataVet(String InfoID) {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT solicitud.idSolicitud, usuario.nombre, solicitud.fecha, estado.estado FROM solicitud\n"
                    + "JOIN cliente\n"
                    + "ON cliente.idcliente = solicitud.idcliente\n"
                    + "JOIN usuario\n"
                    + "ON usuario.idUser = cliente.idUser\n"
                    + "JOIN estado\n"
                    + "ON estado.idestado = solicitud.idestado\n"
                    + "WHERE solicitud.idveterinario = ?");
            ps.setString(1, InfoID);
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Solicitud();
                obj.setIdSolicitud(rs.getInt("idSolicitud"));
                obj.setNombre(rs.getString("nombre"));
                obj.setFecha(rs.getString("fecha"));
                obj.setStatus(rs.getString("estado"));
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

}

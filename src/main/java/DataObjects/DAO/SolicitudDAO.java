package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.solicitudInterface;
import java.sql.Connection;
import java.sql.Date;
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
    private Solicitud obj = null;
    private List<Solicitud> list;

    public SolicitudDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Solicitud ob) {
        try {
            ps = connect.prepareStatement("INSERT INTO solicitud (idcliente, idveterinario,idmascota,idprioridad,idestado,fecha,descripcion) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, ob.getIdCliente());
            ps.setString(2, ob.getIdVeterinario());
            ps.setInt(3, ob.getIdMascota());
            ps.setInt(4, ob.getIdPrioridad());
            ps.setInt(5, ob.getIdEstado());
            ps.setDate(6, Date.valueOf(ob.getFecha()));
            ps.setString(7, ob.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
        }
    }

    @Override
    public List<Solicitud> read() {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT solicitud.idsolicitud, c.nombre AS cliente, v.nombre AS nombreV, solicitud.fecha, estado.estado \n"
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
    public boolean update(Solicitud ob) {
        try {
            ps = connect.prepareStatement("UPDATE solicitud "
                    + "SET idcliente = ?, "
                    + "idveterinario = ?, "
                    + "idmascota = ?,"
                    + "idprioridad = ?,"
                    + "idestado = ?,"
                    + "fecha = ?,"
                    + "descripcion = ? "
                    + "WHERE idsolicitud = ?");
            ps.setInt(1, ob.getIdCliente());
            ps.setString(2, ob.getIdVeterinario());
            ps.setInt(3, ob.getIdMascota());
            ps.setInt(4, ob.getIdPrioridad());
            ps.setInt(5, ob.getIdEstado());
            ps.setDate(6, Date.valueOf(ob.getFecha()));
            ps.setString(7, ob.getDescripcion());
            ps.setInt(8, ob.getIdSolicitud());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
            ConnectionDB.closeDB(rs);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            ps = connect.prepareStatement("DELETE FROM solicitud WHERE idSolicitud = ? ");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
        }
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

    public List<Solicitud> ListOne(String InfoID, int option) {
        try {
            String condition = "";
            if (option == 1) {
                condition = "WHERE solicitud.idveterinario = ?";
            } else if (option == 2) {
                condition = "WHERE solicitud.idcliente = ?";
            }
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT solicitud.idsolicitud, c.nombre AS cliente, c.celular as celcliente, v.nombre AS veterinario, solicitud.fecha, estado.estado, solicitud.descripcion, solicitud.idestado \n"
                    + "FROM usuario c\n"
                    + "JOIN cliente ON c.idUser = cliente.idUser\n"
                    + "JOIN solicitud ON cliente.idCliente = solicitud.idCliente\n"
                    + "JOIN veterinario ON solicitud.idVeterinario = veterinario.idVeterinario\n"
                    + "JOIN usuario v ON veterinario.idUser = v.idUser\n"
                    + "JOIN estado ON solicitud.idEstado = estado.idestado "
                    + condition);
            if (option == 1) {
                ps.setString(1, InfoID);
            } else if (option == 2) {
                ps.setInt(1, Integer.parseInt(InfoID));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                obj = new Solicitud();
                obj.setIdSolicitud(rs.getInt("idSolicitud"));
                obj.setNombre(rs.getString("cliente"));
                obj.setvNombre(rs.getString("veterinario"));
                obj.setCelular(rs.getString("celcliente"));
                obj.setFecha(rs.getString("fecha"));
                obj.setStatus(rs.getString("estado"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setIdEstado(rs.getInt("idestado"));
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

    public Solicitud show(int BellID) {
        try {
            ps = connect.prepareStatement("SELECT * FROM solicitud WHERE idsolicitud = ? ");
            ps.setInt(1, BellID);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj.setIdSolicitud(rs.getInt("idsolicitud"));
                obj.setIdCliente(rs.getInt("idcliente"));
                obj.setIdVeterinario(rs.getString("idveterinario"));
                obj.setIdMascota(rs.getInt("idmascota"));
                obj.setIdPrioridad(rs.getInt("idprioridad"));
                obj.setIdEstado(rs.getInt("idestado"));
                obj.setFecha(rs.getString("fecha"));
                obj.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return obj;
    }

    public boolean exist(int idpet) {
        try {
            ps = connect.prepareStatement("SELECT * FROM solicitud WHERE idmascota = ? and idestado = 1");
            ps.setInt(1, idpet);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return false;
    }

    @Override
    public boolean update(int id, int status) {
        try {
            ps = connect.prepareStatement("UPDATE solicitud SET idestado =? WHERE idsolicitud = ?");
            ps.setInt(1, status);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeDB(ps);
        }
    }

    @Override
    public int count(String idvet) {
        try {
            ps = connect.prepareStatement("SELECT count(*) FROM solicitud WHERE solicitud.idveterinario=?");
            ps.setString(1, idvet);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }

}

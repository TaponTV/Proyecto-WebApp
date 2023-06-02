package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.consultaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.Consulta;
import models.Solicitud;

public class ConsultaDAO implements consultaInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Consulta obj = null;
    private List<Consulta> list;

    public ConsultaDAO() {
        connect = ConnectionDB.getConnection();
    }

    @Override
    public boolean create(Consulta ob) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Consulta> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Consulta ob) {
        try {
            ps = connect.prepareStatement("UPDATE consulta SET idSolicitud = ?, fechaConsulta = ?, detalle = ? WHERE idConsulta = ?");
            ps.setInt(1, ob.getIdSolicitud());
            ps.setTimestamp(2, Timestamp.valueOf(ob.getFechaConsulta()));
            ps.setString(3, ob.getDetalle());
            ps.setInt(4, ob.getIdConsulta());
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
            ps = connect.prepareStatement("DELETE FROM consulta WHERE idConsulta = ? ");
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
        return 0;
    }

    public List<Consulta> ListOne(String InfoID, int option) {
        try {
            String condition = "";
            if (option == 1) {
                condition = "WHERE solicitud.idveterinario = ?";
            } else if (option == 2) {
                condition = "WHERE solicitud.idcliente = ?";
            }
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT idConsulta, usuario.nombre, mascota.nombre as mascota, especie.especie, fechaconsulta, detalle, solicitud.idSolicitud FROM consulta\n"
                    + "JOIN solicitud\n"
                    + "ON solicitud.idsolicitud = consulta.idsolicitud\n"
                    + "JOIN cliente\n"
                    + "ON cliente.idcliente = solicitud.idcliente\n"
                    + "JOIN usuario\n"
                    + "ON usuario.idUser = cliente.idUser\n"
                    + "JOIN mascota\n"
                    + "ON mascota.idmascota = solicitud.idmascota\n"
                    + "JOIN especie\n"
                    + "ON especie.idespecie = mascota.idespecie\n"
                    + condition);
            if (option == 1) {
                ps.setString(1, InfoID);
            } else if (option == 2) {
                ps.setInt(1, Integer.parseInt(InfoID));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                int idConsulta = rs.getInt("idConsulta");
                String nombreC = rs.getString("nombre");
                String nombreM = rs.getString("mascota");
                String nombreE = rs.getString("especie");
                String fechaConsulta = rs.getString("fechaconsulta");
                obj = new Consulta(idConsulta, fechaConsulta, nombreC, nombreM, nombreE);
                obj.setIdSolicitud(rs.getInt("idSolicitud"));
                obj.setDetalle(rs.getString("detalle"));
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }
    
    public List<Consulta> ListOne(int idpet){
        Solicitud tmp;
        try{
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT idconsulta, solicitud.idveterinario, nombre, apPaterno, apMaterno, fechaconsulta, detalle FROM consulta "
                    + "JOIN solicitud ON solicitud.idsolicitud = consulta.idsolicitud "
                    + "JOIN veterinario ON solicitud.idveterinario = veterinario.idveterinario "
                    + "JOIN usuario ON veterinario.iduser = usuario.iduser "
                    + "WHERE solicitud.idmascota = ? ");
            ps.setInt(1, idpet);
            rs = ps.executeQuery();
            while(rs.next()){
                obj = new Consulta();
                tmp = new Solicitud();
                obj.setIdConsulta(rs.getInt("idconsulta"));
                obj.setFechaConsulta(rs.getString("fechaconsulta"));
                obj.setDetalle(rs.getString("detalle"));
                tmp.setIdVeterinario(rs.getString("idveterinario"));
                tmp.setvNombre(rs.getString("nombre")+" "+rs.getString("apPaterno"));
                obj.setAux(tmp);
                list.add(obj);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }finally{
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }

    public Consulta show(int MeetID) {
        try {
            ps = connect.prepareStatement("SELECT * FROM Consulta WHERE idconsulta = ? ");
            ps.setInt(1, MeetID);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Consulta();
                obj.setIdConsulta(rs.getInt("idconsulta"));
                obj.setIdSolicitud(rs.getInt("idsolicitud"));
                obj.setFechaConsulta(rs.getString("fechaconsulta"));
                obj.setDetalle(rs.getString("detalle"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
        return obj;
    }

}

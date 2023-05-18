package DataObjects.DAO;

import DataObjects.DBConnection.ConnectionDB;
import java.util.List;

import DataObjects.interfaces.consultaInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Consulta;

public class ConsultaDAO implements consultaInterface {

    private Connection connect = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Consulta obj = null;
    private List<Consulta> list;

    public ConsultaDAO() {
        connect = ConnectionDB.getConnection();
    }

    public boolean create(Consulta ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Consulta> read() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean update(Consulta ob) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    public List<Consulta> ListOne(String idVet) {
        try {
            list = new ArrayList<>();
            ps = connect.prepareStatement("SELECT idConsulta, usuario.nombre, mascota.nombre, especie.especie, fechaconsulta FROM consulta\n"
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
                    + "WHERE solicitud.idveterinario = ?");
            ps.setString(1,idVet);
            rs = ps.executeQuery();
            while(rs.next()){
                int idConsulta = rs.getInt("idConsulta");
                String nombreC = rs.getString("nombre");
                String nombreM = rs.getString("nombre");
                String nombreE = rs.getString("especie");
                String fechaConsulta = rs.getString("fechaconsulta");
                obj = new Consulta(idConsulta, fechaConsulta, nombreC, nombreM, nombreE);
                list.add(obj);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            ConnectionDB.closeDB(rs);
            ConnectionDB.closeDB(ps);
        }
    }

}

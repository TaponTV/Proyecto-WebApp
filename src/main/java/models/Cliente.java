package models;

import DataObjects.DAO.ClienteDAO;
import java.io.*;

public class Cliente extends Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idCliente;
    private int idUser;
    private ClienteDAO data = new ClienteDAO();

    public Cliente() {

    }

    public Cliente(int idUser) {
        this.idUser = idUser;
        this.idCliente = data.idClient(idUser);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente() {
        this.idCliente = data.idClient(this.idUser);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Cliente con idUser: " + idUser;
    }

}

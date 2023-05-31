package DataObjects.interfaces;

import models.Cliente;

public interface clienteInterface extends GenericInterface<Cliente>{
    public int idClient(int idUser);
    public String nameClient(int idClient);
}

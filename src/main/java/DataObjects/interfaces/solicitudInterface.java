package DataObjects.interfaces;

import models.Solicitud;

public interface solicitudInterface extends GenericInterface<Solicitud>{

    public boolean update(int id, int status);
    public int count(String idvet);
}

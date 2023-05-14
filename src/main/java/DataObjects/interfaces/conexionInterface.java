package DataObjects.interfaces;

import models.Conexion;

public interface conexionInterface extends GenericInterface<Conexion>{
    public int getRowID(int idUser, String tmsp);
}

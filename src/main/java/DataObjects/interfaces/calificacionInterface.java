package DataObjects.interfaces;

import java.util.List;
import models.Calificacion;

public interface calificacionInterface extends GenericInterface<Calificacion>{
    public List<Calificacion> ListOne(int idCliente);
    public List<Calificacion> ListOne(String idVeterinario);
    public int Score(String idVeterinario);
}

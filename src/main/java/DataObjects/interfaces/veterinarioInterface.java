package DataObjects.interfaces;

import java.util.List;
import models.Veterinario;

public interface veterinarioInterface extends GenericInterface<Veterinario>{
    public String getRowID(int idUser);
    public List<Veterinario> read(String ciudad);
}

package DataObjects.interfaces;

import java.util.List;
import models.Mascota;

public interface mascotaInterface extends GenericInterface<Mascota> {

    public List<Mascota> read(int id);
    public Mascota getData(int id);
}

package DataObjects.interfaces;

import java.util.List;
import models.Mascota;

public interface mascotaInterface extends GenericInterface<Mascota> {

    List<Mascota> read(int id);
}

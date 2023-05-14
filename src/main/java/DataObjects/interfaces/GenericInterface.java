package DataObjects.interfaces;

import java.util.List;

public interface GenericInterface<T> {

    boolean create(T ob);

    List<T> read();
    
    int count();

    boolean update(T ob);

    boolean delete(int id);
}

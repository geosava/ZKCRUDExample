package CRUDExample.service;

/**
 * Created by o960 on 30/1/2015.
 */
import java.util.List;

public interface CRUDService {
    <T> List<T> getAll(Class<T> klass);

    <T> T save(T t);

    <T> void delete(T t);
}

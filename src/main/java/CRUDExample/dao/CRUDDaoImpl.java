package CRUDExample.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class CRUDDaoImpl implements CRUDDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> klass) {
        return em.createQuery("Select t from " + klass.getSimpleName() + " t")
                .getResultList();
    }

    public <T> T save(T t) {
        T newRecord = null;
        newRecord = em.merge(t);
        return newRecord;
    }

    public <T> void delete(T t) {
        em.remove(em.merge(t));
        em.flush();
    }
}

package CRUDExample.service;

/**
 * Created by o960 on 30/1/2015.
 */


import CRUDExample.dao.CRUDDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CRUDServiceImpl implements CRUDService {


    @Autowired
    private CRUDDao CRUDDao;

    @Transactional(readOnly = true)
    public <T> List<T> getAll(Class<T> klass) {
        return CRUDDao.getAll(klass);
    }


    @Transactional
    public <T> T save(T t)  {
        T newRecord = null;
        newRecord = CRUDDao.save(t);
        return newRecord;
    }

    @Transactional
    public <T> void delete(T t) {
        CRUDDao.delete(t);
    }
}

package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryImpl.class);
    @Override
    public Long save(StudentEntity e) {
        LOGGER.debug("START METHOD SAVE REPOSITORY");
        return null;
    }

    @Override
    public Boolean update(StudentEntity e) {
        LOGGER.debug("START METHOD UPDATE REPOSITORY");
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("START METHOD DELETE REPOSITORY");
        return null;
    }

    @Override
    public List<StudentEntity> selectAll() {
        LOGGER.debug("START METHOD SELECT ALL REPOSITORY");
        return new  ArrayList();
    }
}

package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import ma.pfe.repositories.StudentRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentMapper mapper;

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("START METHOD SAVE SERVICE");
        StudentEntity e = mapper.convertToEntity(dto);
        return repository.save(e);
    }

    @Override
    public Boolean update(StudentDto dto) {
        LOGGER.debug("START METHOD UPDATE SERVICE");
        StudentEntity e = mapper.convertToEntity(dto);
        return repository.update(e);
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("START METHOD DELETE SERVICE");
        return repository.deleteById(id);
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("START METHOD SELECT ALL SERVICE");
        List<StudentEntity> l = repository.selectAll();
        List<StudentDto> ld = mapper.convertToDtos(l);
        return ld;
    }
}

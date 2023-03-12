package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service1")
public class StudentServiceImpl implements StudentService{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository repository;
    private StudentMapper mapper;

    public StudentServiceImpl(@Qualifier("repo1") StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("START METHOD SAVE SERVICE dto : {}",dto);
        StudentDto result = mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
        return result.getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("START METHOD UPDATE SERVICE dto : {}",dto);
        StudentDto result = mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
        return result.getId();
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("START METHOD DELETE SERVICE id : {}",id);
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("START METHOD SELECT ALL SERVICE");
        return mapper.convertToDtos(repository.findAll());
    }
}

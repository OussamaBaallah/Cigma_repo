package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service1")
public class StudentServiceImpl implements StudentService{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Qualifier("repo1")
    private StudentRepository repository;
    private StudentMapper mapper= Mappers.getMapper(StudentMapper.class);

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("START METHOD SAVE SERVICE dto : {}",dto);
        StudentDto result = mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
        return result.getStudentId().getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("START METHOD UPDATE SERVICE dto : {}",dto);
        StudentDto result = mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
        return result.getStudentId().getId();
    }

    @Override
    public Boolean deleteById(StudentIdDto idDto) {
        LOGGER.debug("START METHOD DELETE SERVICE id : {}",idDto);
        repository.deleteById(mapper.studentIdDtoToStudentId(idDto));
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("START METHOD SELECT ALL SERVICE");
        return mapper.convertToDtos(repository.findAll());
    }

    @Override
    public StudentDto selectById(StudentIdDto idDto) {
        Optional result = repository.findById(mapper.studentIdDtoToStudentId(idDto));
        return mapper.convertToDto((StudentEntity) result.orElse(null));

      /*  if (result.isPresent())
        {
            return mapper.convertToDto((StudentEntity) result.get());
        }
        return null; */
    }
}

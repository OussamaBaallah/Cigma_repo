package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface StudentMapper {
    public StudentEntity convertToEntity(StudentDto dto);
    public StudentDto convertToDto(StudentEntity entity);
    public List<StudentDto> convertToDtos(List<StudentEntity> entities);
    StudentId studentIdDtoToStudentId(StudentIdDto studentIdDto);


}

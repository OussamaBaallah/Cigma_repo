package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.repositories.StudentRepositoryImpl;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryImpl.class);

    @Autowired
    private StudentService service;


    @PostMapping
    public Long save(StudentDto dto){
        LOGGER.debug("START METHOD SAVE CONTROLLER");
        return service.save(dto);
    }

    @PutMapping
    public Boolean update(StudentDto dto){
        LOGGER.debug("START METHOD UPDATE CONTROLLER");
        return service.update(dto);
    }

    @DeleteMapping
    public Boolean delete(Long id){
        LOGGER.debug("START METHOD DELETE CONTROLLER");
        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentDto> selectAll(){
        LOGGER.debug("START METHOD SELECT ALL CONTROLLER");
        return service.selectAll();
    }
}

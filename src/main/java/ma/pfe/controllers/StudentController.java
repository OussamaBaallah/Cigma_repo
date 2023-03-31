package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);


    private StudentService service;

    public StudentController(@Qualifier("service1") StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Long save(@RequestBody StudentDto dto){
        LOGGER.debug("START METHOD SAVE CONTROLLER dto : {}",dto);
        return service.save(dto);
    }

    @PutMapping
    public Long update(@RequestBody StudentDto dto){
        LOGGER.debug("START METHOD UPDATE CONTROLLER dto : {}",dto);
        return service.update(dto);
    }

    @DeleteMapping("/{id}/{code}")
    public Boolean delete(@PathVariable("id") long id,@PathVariable("code") String code){
        LOGGER.debug("START METHOD Delete By Id CONTROLLER: id {}, code {} ",id,code);
        StudentIdDto idcomp = new StudentIdDto(id,code);
        return service.deleteById(idcomp);
    }

    @GetMapping
    public List<StudentDto> selectAll(){
        LOGGER.debug("START METHOD SELECT ALL CONTROLLER");
        return service.selectAll();
    }
    @GetMapping("/{id}/{code}")
    public StudentDto selectById(@PathVariable("id") long id,@PathVariable("code") String code ){
        LOGGER.debug("START METHOD SELECT By Id CONTROLLER: id {}, code {} ",id,code);
        StudentIdDto idcomp = new StudentIdDto(id,code);
        return service.selectById(idcomp);
    }
}

package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
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

    @DeleteMapping("/{ids}")
    public Boolean delete(@PathVariable("ids") Long id){
        LOGGER.debug("START METHOD DELETE CONTROLLER id : {}",id);
        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentDto> selectAll(){
        LOGGER.debug("START METHOD SELECT ALL CONTROLLER");
        return service.selectAll();
    }
}

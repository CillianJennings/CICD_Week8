package ie.atu.week8validation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeID){
        if(employeeID.length() > 5 || employeeID.isBlank()){
            return ResponseEntity.badRequest().body("EmployeeID is invlalid");
        }

        Person person = personService.getPersonByEmployeeID(employeeID);

        if(person == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Person person){
        personService.savePerson(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }

}

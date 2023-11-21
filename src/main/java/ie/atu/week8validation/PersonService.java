package ie.atu.week8validation;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public void savePerson(Person person){
        System.out.println("Person saved: " + person);
    }

    public Person getPersonByEmployeeID(String employeeID){
        return new Person();
    }
}

package spbstu.CourseWork.main.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import spbstu.CourseWork.main.entity.Client;
import spbstu.CourseWork.main.exception.ClientNotFoundException;
import spbstu.CourseWork.main.service.ClientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-first-name/{firstName}")
    public ResponseEntity<List<Client>> findByFirstName(@PathVariable("firstName") String firstName){
        try {
            List<Client> clientList = clientService.findByFirstName(firstName);
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-last-name/{lastName}")
    public ResponseEntity<List<Client>> findByLastName(@PathVariable("lastName") String lastName){
        try {
            List<Client> clientList = clientService.findByLastname(lastName);
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-father-name/{fatherName}")
    public ResponseEntity<List<Client>> findByFatherName(@PathVariable("fatherName") String fatherName){
        try {
            List<Client> clientList = clientService.findByFatherName(fatherName);
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-passport-seria/{passportSeria}")
    public ResponseEntity<List<Client>> findByPassportSeria(@PathVariable("passportSeria") String passportSeria){
        try {
            List<Client> clientList = clientService.findByPassportSeria(passportSeria);
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/find-by-passport-num/{passportNum}")
    public ResponseEntity<List<Client>> findByPassportNum(@PathVariable("passportNum") String passportNum){
        try {
            List<Client> clientList = clientService.findByPassportNum(passportNum);
            return new ResponseEntity<>(clientList, HttpStatus.OK);
        }catch (ClientNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/update-client/{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody Map<String, String> json){
        String firstName = json.get("firstName");
        String lastName = json.get("lastName");
        String fatherName = json.get("fatherName");
        clientService.updateClient(id, firstName, lastName, fatherName);
    }

}

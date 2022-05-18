package spbstu.CourseWork.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbstu.CourseWork.main.entity.Client;
import spbstu.CourseWork.main.exception.ClientNotFoundException;
import spbstu.CourseWork.main.repository.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public Client findById(Integer id) {
        Optional<Client> ap = clientsRepository.findById(id);
        if(ap.isPresent()){
            return ap.get();
        }else{
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public List<Client> findByFirstName(String firstName) {
        return (List<Client>) clientsRepository.findByFirstName(firstName);
    }

    @Override
    public List<Client> findByLastname(String lastName) {
        return (List<Client>) clientsRepository.findByLastName(lastName);
    }

    @Override
    public List<Client> findByFatherName(String fatherName) {
        return (List<Client>) clientsRepository.findByFatherName(fatherName);
    }

    @Override
    public List<Client> findByPassportSeria(String seria) {
        return (List<Client>) clientsRepository.findByPassportSeria(seria);
    }

    @Override
    public List<Client> findByPassportNum(String num) {
        return (List<Client>) clientsRepository.findByPassportNum(num);
    }

    @Override
    public void updateClient(Integer id, String firstName, String lastName, String fatherName) {
        clientsRepository.updateClient(id, firstName, lastName, fatherName);
    }
}

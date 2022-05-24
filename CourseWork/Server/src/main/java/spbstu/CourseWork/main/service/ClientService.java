package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.entity.Client;

import java.util.List;

public interface ClientService {
    Client findById(Integer id);
    List<Client> findByFirstName(String firstName);
    List<Client> findByLastname(String lastName);
    List<Client> findAll();
    Client add(Client client);
    List<Client> findByFatherName(String fatherName);
    List<Client> findByPassportSeria(String seria);
    List<Client> findByPassportNum(String num);

    void updateClient(Integer id, String firstName, String lastName, String fatherName);

    void deleteById(Integer id);
}

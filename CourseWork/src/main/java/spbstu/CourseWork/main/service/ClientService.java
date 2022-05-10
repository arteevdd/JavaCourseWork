package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.entity.Client;

import java.util.List;

public interface ClientService {
    Client findById(Integer id);
    List<Client> findByFirstName(String firstName);
    List<Client> findByLastname(String lastName);
    List<Client> findByFatherName(String fatherName);
    List<Client> findByPassportSeria(String seria);
    List<Client> findByPassportNum(String num);

    //запрос на update ????
}

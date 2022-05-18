package spbstu.CourseWork.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spbstu.CourseWork.main.entity.User;
import spbstu.CourseWork.main.repository.*;

import java.util.Collections;

@Component
public class TestDataInit implements CommandLineRunner {

    @Autowired
    JournalRepository journalRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        booksRepository.findById(3);
//        bookTypesRepository.findById(3);
//        clientsRepository.findById(3);


//        userRepository.save(new User("user", passwordEncoder.encode("pwd"), Collections.singletonList("ROLE_USER")));
//        userRepository.save(new User("admin", passwordEncoder.encode("admin"), Collections.singletonList("ROLE_ADMIN")));
    }
}

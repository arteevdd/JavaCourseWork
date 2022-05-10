package spbstu.CourseWork.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import spbstu.CourseWork.main.entity.BookTypes;
import spbstu.CourseWork.main.entity.Books;
import spbstu.CourseWork.main.entity.Client;
import spbstu.CourseWork.main.entity.Journal;
import spbstu.CourseWork.main.repository.BookTypesRepository;
import spbstu.CourseWork.main.repository.BooksRepository;
import spbstu.CourseWork.main.repository.ClientsRepository;
import spbstu.CourseWork.main.repository.JournalRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CourseWorkApplication {

	private static final Logger log = LoggerFactory.getLogger(CourseWorkApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CourseWorkApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(BooksRepository booksRep,
								  BookTypesRepository bookTypesRep,
								  ClientsRepository clientRep,
								  JournalRepository journalRep) {
		return args -> {
////------------------------------------------Books---------------------------------------
////			Optional<Books> ap = booksRep.findById(3);
////			ap.ifPresent(value -> log.info(value.toString()));
//
////			Optional<Books> ap = booksRep.findByName("Забвение");
////			ap.ifPresent(value -> log.info(value.toString()));
//
////		    Iterable<Books> ap = booksRep.findByCnt(10);
////			List<Books> res = (List<Books>) ap;
////			log.info(res.toString());
//
//
//
////			Iterable<Books> ap = booksRep.findBookByBookTypeName("Приключения");
////			List<Books> res = (List<Books>) ap;
////			log.info(res.toString());
//
////			Iterable<Books> ap = booksRep.findBookByDayCount(30);
////			List<Books> res = (List<Books>) ap;
////			log.info(res.toString());
////----------------------------------------------------------------------------------------
////------------------------------------------BookTypes-------------------------------------
//
////			Optional<BookTypes> ap = bookTypesRep.findById(4);
////			ap.ifPresent(value -> log.info(value.toString()));
//
////			Optional<BookTypes> ap = bookTypesRep.findByName("Комедия");
////			ap.ifPresent(value -> log.info(value.toString()));
//
////			Iterable<BookTypes> ap = bookTypesRep.findByCnt(12);
////			List<BookTypes> res = (List<BookTypes>) ap;
////          log.info(res.toString());
//
////			Iterable<BookTypes> ap = bookTypesRep.findByDayCount(30);
////			List<BookTypes> res = (List<BookTypes>) ap;
////          log.info(res.toString());
//
//
//
////----------------------------------------------------------------------------------------
////------------------------------------------Client-------------------------------------
//
////			Optional<Client> ap = clientRep.findById(11);
////			ap.ifPresent(value -> log.info(value.toString()));
//
//
////			Iterable<Client> ap = clientRep.findByFirstName("Алексей");
////			List<Client> res =(List<Client>) ap;
////			log.info(res.toString());
//
//
////			Iterable<Client> ap = clientRep.findByLastName("Гуляев");
////			List<Client> res = (List<Client>) ap;
////			log.info(res.toString());
//
////			Iterable<Client> ap = clientRep.findByFatherName("Максимович");
////			List<Client> res = (List<Client>) ap;
////			log.info(res.toString());
//
////			Iterable<Client> ap = clientRep.findByPassportSeria("3342");
////			List<Client> res = (List<Client>) ap;
////			log.info(res.toString());
//
////			Iterable<Client> ap = clientRep.findByPassportNum("543783");
////			List<Client> res = (List<Client>) ap;
////			log.info(res.toString());
//
////----------------------------------------------------------------------------------------
////------------------------------------------Journal-------------------------------------
//
////			Optional<Journal> ap = journalRep.findById(2);
////			ap.ifPresent(value -> log.info(value.toString()));
//
////			Iterable<Journal> ap = journalRep.findByDataBeg(Timestamp.valueOf("2020-03-02 12:00:00"));
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
//
////			Iterable<Journal> ap = journalRep.findByDataEnd(Timestamp.valueOf("2021-02-01 12:00:00"));
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
//
////			Iterable<Journal> ap = journalRep.findByDataRet(Timestamp.valueOf("2021-07-01 17:00:00"));
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
//
//
////			Iterable<Journal> ap = journalRep.findJournalByBookName("Всадник без головы");
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
//
////			Iterable<Journal> ap = journalRep.findJournalByClientInitials("Алексей", "Савчук", "Анатольевич");
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
//
////			Iterable<Journal> ap = journalRep.findJournalByPassportSeriaAndPassportNum("3342", "543783");
////			List<Journal> res = (List<Journal>) ap;
////			log.info(res.toString());
		};
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
			return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}


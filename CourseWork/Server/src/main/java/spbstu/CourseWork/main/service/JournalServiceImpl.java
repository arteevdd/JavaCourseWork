package spbstu.CourseWork.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spbstu.CourseWork.main.dto.JournalDto;
import spbstu.CourseWork.main.entity.Books;
import spbstu.CourseWork.main.entity.Client;
import spbstu.CourseWork.main.entity.Journal;
import spbstu.CourseWork.main.exception.JournalNotFoundException;
import spbstu.CourseWork.main.repository.JournalRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService{
    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private BooksService booksService;
    @Autowired
    private ClientService clientService;

    @Override
    public Journal findById(Integer id) {
        Optional<Journal> ap = journalRepository.findById(id);
        if (ap.isPresent()){
            return ap.get();
        }else{
            throw new JournalNotFoundException("Journal not found");
        }
    }

    @Override
    public List<Journal> findByDataBeg(Timestamp dataBeg) {
        return (List<Journal>) journalRepository.findByDataBeg(dataBeg);
    }

    @Override
    public List<Journal> findByDataEnd(Timestamp dataEnd) {
        return (List<Journal>) journalRepository.findByDataEnd(dataEnd);
    }

    @Override
    public List<Journal> findByDataRet(Timestamp dataRet) {
        return (List<Journal>) journalRepository.findByDataRet(dataRet);
    }

    @Override
    public List<Journal> findAll() {
        return (List<Journal>) journalRepository.findAll();
    }

    @Override
    public List<Journal> findJournalByBookName(String name) {
        return (List<Journal>) journalRepository.findJournalByBookName(name);
    }

    @Override
    public List<Journal> findJournalByClientInitials(String firstName, String lastName, String fatherName) {
        return (List<Journal>) journalRepository.findJournalByClientInitials(firstName, lastName, fatherName);
    }

    @Override
    public List<Journal> findJournalByPassportSeriaAndPassportNum(String passportSeria, String passportNum) {
        return (List<Journal>) journalRepository.findJournalByPassportSeriaAndPassportNum(passportSeria, passportNum);
    }

    @Override
    public Journal add(JournalDto journalDto) {
        Integer bookId = journalDto.getBookId();
        Integer clientId = journalDto.getClientId();
        Timestamp dataBeg = journalDto.getDataBeg();
        Timestamp dataEnd = journalDto.getDataEnd();
        Timestamp dataRet = journalDto.getDataRet();

        Books books = booksService.findById(bookId);
        Client client = clientService.findById(clientId);
        Journal journal = new Journal(books, client, dataBeg, dataEnd, dataRet);
        journalRepository.save(journal);
        return journal;
     }

    @Override
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }
    @Override
    public void deleteJournalById(Integer id) {
        journalRepository.deleteJournalById(id);
    }
}

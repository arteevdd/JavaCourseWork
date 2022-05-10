package spbstu.CourseWork.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}

package spbstu.CourseWork.main.service;

import spbstu.CourseWork.main.dto.JournalDto;
import spbstu.CourseWork.main.entity.Journal;

import java.sql.Timestamp;
import java.util.List;

public interface JournalService {
    Journal findById(Integer id);
    List<Journal> findByDataBeg(Timestamp dataBeg);
    List<Journal> findByDataEnd(Timestamp dataEnd);
    List<Journal> findByDataRet(Timestamp dataRet);
    List<Journal> findAll();
    List<Journal> findJournalByBookName(String name);
    List<Journal> findJournalByClientInitials(String firstName, String lastName, String fatherName);
    List<Journal> findJournalByPassportSeriaAndPassportNum(String passportSeria, String passportNum);

    Journal add(JournalDto journalDto);
    Journal addJournal(Journal journal);
    void deleteJournalById(Integer id);
}

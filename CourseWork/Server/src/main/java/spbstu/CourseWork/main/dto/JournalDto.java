package spbstu.CourseWork.main.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JournalDto {
    private Integer bookId;
    private Integer clientId;
    private Timestamp dataBeg;
    private Timestamp dataEnd;
    private Timestamp dataRet;
}

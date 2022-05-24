package spbstu.CourseWork.main.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String passportSeria;
    private String passportNum;
}

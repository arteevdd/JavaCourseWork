package spbstu.CourseWork.main.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookTypesDto {
    private String name;
    private Integer cnt;
    private Integer fine;
    private Integer dayCount;
}

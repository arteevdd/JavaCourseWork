package spbstu.CourseWork.main.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BooksDto {
    private Integer id;
    private String name;
    private Integer cnt;
    private Integer typeId;
}

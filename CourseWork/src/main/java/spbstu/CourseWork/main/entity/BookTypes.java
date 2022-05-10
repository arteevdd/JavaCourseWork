package spbstu.CourseWork.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "book_types")
public class BookTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @Column(name = "fine", nullable = false)
    private Integer fine;

    @Column(name = "day_count", nullable = false)
    private Integer dayCount;

    @JsonIgnore
    @OneToMany(mappedBy = "typeId", cascade = CascadeType.ALL)
    private Collection<Books> bookTypes;

    public BookTypes() {
    }

    public BookTypes(Integer id, String name, Integer cnt, Integer fine, Integer dayCount) {
        this.id = id;
        this.name = name;
        this.cnt = cnt;
        this.fine = fine;
        this.dayCount = dayCount;
    }

    @Override
    public String toString() {
        return "BookTypes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnt=" + cnt +
                ", fine=" + fine +
                ", dayCount=" + dayCount +
                '}';
    }
}

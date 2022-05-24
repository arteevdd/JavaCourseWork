package spbstu.CourseWork.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private BookTypes typeId;

    @JsonIgnore
    @OneToMany(mappedBy = "bookId", cascade = CascadeType.ALL)
    private Collection<Journal> booksId;

    public Books() {
    }

    public Books(String name, Integer cnt, BookTypes typeId) {
        this.name = name;
        this.cnt = cnt;
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnt=" + cnt +
                ", typeId=" + typeId +
                '}';
    }
}

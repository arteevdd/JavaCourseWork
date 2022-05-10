package spbstu.CourseWork.main.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.CollationElementIterator;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "father_name", length = 20, nullable = false)
    private String fatherName;

    @Column(name = "passport_seria", length = 20, nullable = false)
    private String passportSeria;

    @Column(name = "passport_num", length = 20, nullable = false)
    private String passportNum;

    @JsonIgnore
    @OneToMany(mappedBy = "clientId",cascade = CascadeType.ALL)
    private Collection<Journal> journals;


    public Client() {
    }

    public Client(Integer id, String firstName, String lastName, String fatherName, String passportSeria, String passportNum) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.passportSeria = passportSeria;
        this.passportNum = passportNum;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", passportSeria='" + passportSeria + '\'' +
                ", passportNum='" + passportNum + '\'' +
                '}';
    }
}

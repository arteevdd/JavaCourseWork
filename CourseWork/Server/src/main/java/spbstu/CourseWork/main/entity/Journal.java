package spbstu.CourseWork.main.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Books bookId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client clientId;

    @Column(name = "data_beg", precision = 3, nullable = false )
    private Timestamp dataBeg;

    @Column(name = "data_end", precision = 3, nullable = false)
    private Timestamp dataEnd;

    @Column(name = "data_ret", precision = 3, nullable = false)
    private Timestamp dataRet;

    public Journal() {
    }

    public Journal(Books bookId, Client clientId, Timestamp dataBeg, Timestamp dataEnd, Timestamp dataRet) {
        this.bookId = bookId;
        this.clientId = clientId;
        this.dataBeg = dataBeg;
        this.dataEnd = dataEnd;
        this.dataRet = dataRet;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", clientId=" + clientId +
                ", dataBeg=" + dataBeg +
                ", dataEnd=" + dataEnd +
                ", dataRet=" + dataRet +
                '}';
    }
}

package neoflex.model.client;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @CsvBindByName
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private UUID id;

    @CsvBindByName
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @CsvBindByName
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @CsvBindByName
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @CsvBindByName
    @CsvDate("dd.MM.yyyy")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDay;
}
package neoflex.model.tariff;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "tariffs")
public class Tariff {
    @CsvBindByName
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private UUID id;

    @CsvBindByName
    @Column(name = "name", nullable = false)
    private String name;

    @CsvBindByName
    @Column(name = "term")
    private int term;

    @CsvBindByName
    @Column(name = "amount")
    private int amount;

    @CsvBindByName
    @Column(name = "interest_rate")
    private double interestRate;
}
package neoflex.model.credit;

import com.opencsv.bean.CsvBindByName;
import neoflex.model.client.Client;
import lombok.*;
import neoflex.model.tariff.Tariff;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "credits")
public class Credit {
    @CsvBindByName
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credit_id")
    private UUID id;

    @CsvBindByName
    @Column(name = "open_date", nullable = false)
    private LocalDate openDate;

    @CsvBindByName
    @Column(name = "contract_num", nullable = false)
    private String contractNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tariff_id", referencedColumnName = "tariff_id", nullable = false)
    private Tariff tariff;
}

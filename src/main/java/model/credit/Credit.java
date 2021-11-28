package model.credit;

import com.opencsv.bean.CsvBindByName;
import model.client.Client;
import lombok.*;
import model.tariff.Tariff;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Credit {
    @CsvBindByName
    private UUID id;

    @CsvBindByName
    private LocalDate openDate;

    @CsvBindByName
    private String contractNumber;

    private Client client;

    private Tariff tariff;
}

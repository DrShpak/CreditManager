package model.tariff;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Tariff {
    private UUID id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private int term;

    @CsvBindByName
    private int amount;

    @CsvBindByName
    private double interestRate;
}
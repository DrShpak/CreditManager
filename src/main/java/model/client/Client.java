package model.client;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
public class Client {
    private UUID id;

    @CsvBindByName
    private String firstName;

    @CsvBindByName
    private String middleName;

    @CsvBindByName
    private String lastName;

    @CsvBindByName
    @CsvDate("dd.MM.yyyy")
    private LocalDate birthDay;
}
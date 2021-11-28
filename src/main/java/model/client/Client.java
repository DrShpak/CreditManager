package model.client;

import model.credit.Credit;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Client {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDay;
    private List<Credit> credits;
}

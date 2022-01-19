package neoflex.services;

import neoflex.model.credit.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {
    List<Credit> getCreditsByClientId(UUID id);

    Credit closeCredit(UUID clientId, UUID creditId);

    Credit openCredit(UUID clientId, UUID tariffId);
}

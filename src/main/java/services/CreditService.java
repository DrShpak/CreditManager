package services;

import model.credit.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    public List<Credit> getCreditsByClientId(UUID id);

    public String closeCredit(UUID clientId, UUID creditId);

    public String openCredit(UUID clientId, UUID tariffId);
}

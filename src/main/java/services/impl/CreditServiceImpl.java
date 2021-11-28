package services.impl;

import model.credit.Credit;
import services.CreditService;

import java.util.List;
import java.util.UUID;

public class CreditServiceImpl implements CreditService {
    @Override
    public List<Credit> getCreditsByClientId(UUID id) {
        return null;
    }

    @Override
    public String closeCredit(UUID clientId, UUID creditId) {
        return null;
    }

    @Override
    public String openCredit(UUID clientId, UUID tariffId) {
        return null;
    }
}

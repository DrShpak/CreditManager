package neoflex.repository.impl;

import neoflex.model.credit.Credit;
import neoflex.repository.CreditRepository;

import java.util.ArrayList;
import java.util.List;

public class CreditRepoImpl implements CreditRepository {
    private final List<Credit> credits = new ArrayList<>();

    @Override
    public List<Credit> findAll() {
        return credits;
    }

    @Override
    public void add(Credit credit) {
        credits.add(credit);
    }

    @Override
    public boolean remove(Credit credit) {
        return credits.remove(credit);
    }
}

package repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import model.credit.Credit;
import repository.CreditRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

package repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import model.tariff.Tariff;
import repository.TariffRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TariffRepoImpl implements TariffRepository {
    @Override
    public List<Tariff> findAll() {
        try {
            return readAll();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private List<Tariff> readAll() throws FileNotFoundException {
        return new CsvToBeanBuilder<Tariff>(new FileReader(".csv"))
                .withType(Tariff.class).build().parse();
    }
}

package repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import model.tariff.Tariff;
import repository.TariffRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.UUID;

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
        //        tariffs.forEach(tariff -> tariff.setId(UUID.randomUUID()));
        return new CsvToBeanBuilder<Tariff>(new FileReader("src/main/resources/tariffs.csv"))
                .withType(Tariff.class).build().parse();
    }
}

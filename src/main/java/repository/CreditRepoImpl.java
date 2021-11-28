package repository;

import com.opencsv.bean.CsvToBeanBuilder;
import model.credit.Credit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CreditRepoImpl implements CreditRepository {


    @Override
    public List<Credit> findAll() {
        try {
            var credits = readAll();
            var tariffs = new TariffRepoImpl().findAll();
            //todo тут типо надо руками заполнить тарифы и клиенты кредитам, так как это всё в разных файлах лежит
            //можно в доке opencsv поискать как делать чтение из нескольких файлов
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private List<Credit> readAll() throws FileNotFoundException {
        return new CsvToBeanBuilder<Credit>(new FileReader(".csv"))
                .withType(Credit.class).build().parse();
    }
}

package repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import model.client.Client;
import repository.ClientRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ClientRepoImpl implements ClientRepository {
    @Override
    public List<Client> findAll() {
        try {
            return readAll();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private List<Client> readAll() throws FileNotFoundException {
        return new CsvToBeanBuilder<Client>(new FileReader(".csv"))
                .withType(Client.class).build().parse();
    }
}

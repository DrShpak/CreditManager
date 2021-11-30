package repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import model.client.Client;
import repository.ClientRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.UUID;

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
        var clients = new CsvToBeanBuilder<Client>(new FileReader("src/main/resources/clients.csv"))
                .withType(Client.class).build().parse();

        clients.forEach(client -> client.setId(UUID.randomUUID()));
        return clients;
    }
}

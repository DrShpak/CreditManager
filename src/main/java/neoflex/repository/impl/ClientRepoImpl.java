package neoflex.repository.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import neoflex.model.client.Client;
import neoflex.repository.ClientRepository;

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

//        clients.forEach(client -> client.setId(UUID.randomUUID()));
        return new CsvToBeanBuilder<Client>(new FileReader("src/main/resources/clients.csv"))
                .withType(Client.class).build().parse();
    }
}

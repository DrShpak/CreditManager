package repository;

import model.client.Client;
import model.credit.Credit;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
}

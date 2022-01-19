package neoflex.repository;

import neoflex.model.client.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
}

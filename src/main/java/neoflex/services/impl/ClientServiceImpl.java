package neoflex.services.impl;

import neoflex.model.client.Client;
import neoflex.model.tariff.Tariff;
import neoflex.repositoryHibernate.ClientRepository;
import neoflex.repositoryHibernate.TariffRepository;
import neoflex.services.ClientService;
import neoflex.services.TariffService;

import java.util.stream.StreamSupport;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepo;

    public ClientServiceImpl(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client[] getListClients() {
        return StreamSupport.stream(clientRepo.findAll().spliterator(), false).toArray(Client[]::new);
    }
}

package repository;

import model.client.Client;
import model.Credit;
import model.Tariff;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class CreditManager {
    private List<Credit> credits;
    private List<Tariff> tariffs;
    private List<Client> clients;



    public CreditManager() {

    }

    //todo
    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public List<Credit> getClientCreditsById(UUID id) {
        var client = clients.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        if (client.isPresent())
            return client.get().getCredits();
        else
            throw new NoSuchElementException("msg about error");
    }

    public List<Credit> getCredits() {
        return credits;
    }

    protected List<Client> getClients() {
        return clients;
    }

    public void closeCredit(UUID clientId, UUID creditId) {
        clients.stream()
                .filter(x -> x.getId().equals(clientId))
                .findFirst()
                .ifPresent(x -> x.getCredits().removeIf(y -> y.getId().equals(creditId)));
    }

    public void applyCredit() {

    }

    private List<Tariff> readTariffsFromFile() {
        return null;
    }
}

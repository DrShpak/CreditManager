package services.impl;

import model.credit.Credit;
import repository.ClientRepository;
import repository.CreditRepository;
import repository.TariffRepository;
import services.CreditService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreditServiceImpl implements CreditService {
    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;
    private final TariffRepository tariffRepository;

    public CreditServiceImpl(CreditRepository creditRepository, ClientRepository clientRepository, TariffRepository tariffRepository) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<Credit> getCreditsByClientId(UUID id) {
        return creditRepository.
                findAll().
                stream().
                filter(x -> x.getClient().getId() == id).
                collect(Collectors.toList());
    }

    @Override
    public Credit closeCredit(UUID clientId, UUID creditId) {
        var credit = creditRepository.
                findAll().
                stream().
                filter(x -> x.getId() == creditId).
                findFirst().
                get();
        creditRepository.remove(credit);
        return credit;
    }

    @Override
    public Credit openCredit(UUID clientId, UUID tariffId) {
        var credit = new Credit(
                UUID.randomUUID(),
                LocalDate.now(),
                String.valueOf(creditRepository.findAll().size()),
                clientRepository.findAll().stream().filter(x -> x.getId() == clientId).findAny().get(),
                tariffRepository.findAll().stream().filter(x -> x.getId() == clientId).findAny().get()
        );
        creditRepository.add(credit);
        return credit;
    }
}

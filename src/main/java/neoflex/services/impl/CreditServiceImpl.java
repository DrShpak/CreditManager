package neoflex.services.impl;

import neoflex.model.credit.Credit;
import neoflex.repositoryHibernate.ClientRepository;
import neoflex.repositoryHibernate.CreditRepository;
import neoflex.repositoryHibernate.TariffRepository;
import neoflex.services.CreditService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        return StreamSupport.stream(creditRepository.
                findAll().spliterator(), false).
                filter(x -> x.getClient().getId().equals(id)).
                collect(Collectors.toList());
    }

    @Override
    public Credit closeCredit(UUID clientId, UUID creditId) {
        //noinspection OptionalGetWithoutIsPresent
        var credit = StreamSupport.stream(creditRepository.
                findAll().spliterator(), false).
                filter(x -> x.getId().equals(creditId)).
                findFirst().
                get();
        creditRepository.delete(credit);
        return credit;
    }

    @Override
    public Credit openCredit(UUID clientId, UUID tariffId) {
        //noinspection OptionalGetWithoutIsPresent
        var credit = new Credit(
                UUID.randomUUID(),
                LocalDate.now(),
                String.valueOf(creditRepository.count()),
                StreamSupport.stream(clientRepository.findAll().spliterator(), false).filter(x -> x.getId().equals(clientId)).findAny().get(),
                StreamSupport.stream(tariffRepository.findAll().spliterator(), false).filter(x -> x.getId().equals(tariffId)).findAny().get()
        );
        return creditRepository.save(credit);
    }
}

package neoflex.services.impl;

import neoflex.model.tariff.Tariff;
import neoflex.repositoryHibernate.TariffRepository;
import neoflex.services.TariffService;

import java.util.stream.StreamSupport;

public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepo;

    public TariffServiceImpl(TariffRepository tariffRepo) {
        this.tariffRepo = tariffRepo;
    }

    @Override
    public Tariff[] getListTariffs() {
        return StreamSupport.stream(tariffRepo.findAll().spliterator(), false).toArray(Tariff[]::new);
    }
}

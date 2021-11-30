package services.impl;

import model.tariff.Tariff;
import repository.TariffRepository;
import services.TariffService;

public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepo;

    public TariffServiceImpl(TariffRepository tariffRepo) {
        this.tariffRepo = tariffRepo;
    }

    @Override
    public Tariff[] getListTariffs() {
        return tariffRepo.findAll().toArray(Tariff[]::new);
    }
}

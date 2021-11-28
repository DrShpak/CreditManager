package services.impl;

import repository.TariffRepository;
import services.TariffService;

public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepo;

    public TariffServiceImpl(TariffRepository tariffRepo) {
        this.tariffRepo = tariffRepo;
    }

    @Override
    public String getAllTariffs() {
        return tariffRepo.findAll().toString();
    }
}

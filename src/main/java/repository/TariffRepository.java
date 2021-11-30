package repository;

import model.tariff.Tariff;

import java.util.List;

public interface TariffRepository {
    List<Tariff> findAll();
}

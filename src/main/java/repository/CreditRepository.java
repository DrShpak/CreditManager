package repository;

import model.credit.Credit;

import java.util.List;

public interface CreditRepository {
    public List<Credit> findAll();

}

package repository;

import model.credit.Credit;

import java.util.List;

public interface CreditRepository {
    List<Credit> findAll();
    void add(Credit credit);
    boolean remove(Credit credit);
}

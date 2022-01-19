package neoflex.repositoryHibernate;

import neoflex.model.tariff.Tariff;
import org.springframework.data.repository.CrudRepository;

public interface TariffRepository extends CrudRepository<Tariff, Integer> {

}

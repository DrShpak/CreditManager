package neoflex.repositoryHibernate;

import neoflex.model.credit.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepository extends CrudRepository<Credit, Integer> {

}

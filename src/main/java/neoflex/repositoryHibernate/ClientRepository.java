package neoflex.repositoryHibernate;

import neoflex.model.client.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}

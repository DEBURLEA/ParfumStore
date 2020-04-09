package dhbwka.wwi.vertsys.rest.ParfumStore;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Spring Data Repository für die Hersteller-Entität.

@RepositoryRestResource(collectionResourceRel= "hersteller", path= "hersteller")
public interface HerstellerRepository extends PagingAndSortingRepository<Hersteller, Long>{

}


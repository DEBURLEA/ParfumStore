package dhbwka.wwi.vertsys.rest.ParfumStore;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Spring Data Repository für die Parfum-Entität.
@RepositoryRestResource(collectionResourceRel= "parfum", path= "parfum")
public interface ParfumRepository extends PagingAndSortingRepository<Parfum, Long>{

}

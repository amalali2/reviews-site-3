package reviewsitefullstack.demo;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository <Review, Long> {

	Review findById(Long id);
	
	
	
}

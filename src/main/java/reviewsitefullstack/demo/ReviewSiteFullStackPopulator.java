package reviewsitefullstack.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
public class ReviewSiteFullStackPopulator implements CommandLineRunner {
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CommentRepository commentRepo;
	
	@Resource
	TagRepository tagRepo;

	public ReviewSiteFullStackPopulator() {}

	@Override
	public void run(String... args) throws Exception {
		
		
		Category asianCuisine = categoryRepo.save(new Category ("Asian Cuisine"));
		Category italianCuisine = categoryRepo.save(new Category ("Italian Cuisine"));
		Category dessertsAndCoffee = categoryRepo.save(new Category ("Coffee & Desserts"));
		
		Review mandu = reviewRepo.save(new Review (1L, "Mandu Palace", "/img/dumplings.jpg",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
				+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
				+ "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non "
				+ "proident, sunt in culpa qui officia deserunt mollit anim id est laborum", asianCuisine));
		Review pasta = reviewRepo.save(new Review (2L, "Pastaria", "/img/pasta.jpg", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
						+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
						+ "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non "
						+ "proident, sunt in culpa qui officia deserunt mollit anim id est laborum", italianCuisine));
		Review redVelvet = reviewRepo.save(new Review (3L, "Red Velvet Cafe", "/img/cafe.jpg", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
						+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
						+ "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non "
						+ "proident, sunt in culpa qui officia deserunt mollit anim id est laborum", dessertsAndCoffee));
		
		Comment comment1 = commentRepo.save(new Comment("user1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", redVelvet)); 
		Comment comment2 =  commentRepo.save(new Comment("user2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", mandu));
		Comment comment3 =  commentRepo.save(new Comment("user3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", pasta));
		
		Tag columbus = tagRepo.save(new Tag("Columbus"));
		Tag cleveland = tagRepo.save(new Tag("Clevland"));
		Tag chicago = tagRepo.save(new Tag("Chicago"));
		
		
		
		
		
		
		
		}
	

}

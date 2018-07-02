package reviewsitefullstack.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSiteFullstackPopulatorTest {
	

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;
	
	@Test
	public void populatorShouldSaveAndLoadCategory() {
		
		Category testCategory = categoryRepo.save(new Category("test"));
		Category underTest = categoryRepo.findOne(1L);
		assertThat(underTest, is(testCategory));		
		
	}
	
	@Test
	public void populatorShouldGenerateCategoryId() {
		
		Category underTest = categoryRepo.findOne(1L);
		assertThat(underTest, is (underTest));
		
	}
	
	@Test
	public void populatorShouldSaveAndLoadReviews() {
		Review testReview = reviewRepo.save(new Review(1L, "test", "test2", "test1", null, 0));
		Review underTest = reviewRepo.findOne(1L);
		assertThat(underTest, is(equalTo(testReview)));
	
	}
	
	@Test
	public void populatorShouldGenerateReviewId() {
		
		Review underTest = reviewRepo.findOne(1L);
		assertThat(underTest, is (underTest));
		
	}
	
	@Test
	public void populatorShouldEstablishRelationshipBetweenCategoryToReview() {
		Review underTestReview = reviewRepo.save(new Review(1L, "test", "test2", "test1", null, 0, new Category("test"));
		Category underTestCategory = categoryRepo.save(new Category("test")); 
		
		assertTrue(underTestCategory.getReviews().contains(underTestReview));
	}
	
				
}

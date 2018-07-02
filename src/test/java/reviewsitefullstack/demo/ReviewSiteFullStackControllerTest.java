package reviewsitefullstack.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewSiteFullStackController.class)

public class ReviewSiteFullStackControllerTest {
	
	@Resource
	MockMvc mvc;
	
	@MockBean
	ReviewRepository repo;
	
	@MockBean
	CategoryRepository repo2;
	
	@Mock
	Review review;
	
	@Test
	
		public void getReviewsShouldReturnReviewsView () throws Exception {
		
		mvc.perform(get("/reviews")).andExpect(view().name(is(equalTo("reviews"))));
	
	}
	
	@Test
	
		public void getReviewsShouldBeOk () throws Exception {
		
		mvc.perform(get("/reviews")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	
		public void getReviewsShouldReturnAllProducts() throws Exception {
		
		mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(repo.findAll())));
		
	}
	

	
	@Test
	
		public void getReviewShouldBeOk() throws Exception {
		
		mvc.perform(get("/reviews?id=1")).andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	
	public void getReviewsShouldReturnOneProduct() throws Exception {
	
		
		mvc.perform(get("/reviews?id=1")).andExpect(model().attribute("review", is(repo.findOne(42L))));
		
	}
	
	@Test
	
	public void getCategoriessShouldReturnCategoriessView () throws Exception {
	
	mvc.perform(get("/categories")).andExpect(view().name(is(equalTo("categories"))));

	}

	@Test

	public void getCategoriesShouldBeOk () throws Exception {
	
	mvc.perform(get("/categories")).andExpect(status().is2xxSuccessful());
	
	}

	@Test

	public void getCategoriesShouldReturnAllProducts() throws Exception {
	
	mvc.perform(get("/categories")).andExpect(model().attribute("categories", is(repo.findAll())));
	
	}


	@Test

	public void getOneCategoryShouldBeOk() throws Exception {
	
	mvc.perform(get("/categories?id=1")).andExpect(status().is2xxSuccessful());
	
	}

	@Test

	public void getOneCategoryShouldReturnOneProduct() throws Exception {

	
	mvc.perform(get("/cateogories?id=1")).andExpect(model().attribute("review", is(repo.findOne(42L))));
	
	}

}
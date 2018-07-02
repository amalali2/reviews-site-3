package reviewsitefullstack.demo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewSiteFullStackController {
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping(value = "reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviews",reviewRepo.findAll());
		return "reviews";
	}
	
	@RequestMapping("/reviews/{id}")
	public String getOneReview(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("reviews", reviewRepo.findOne(id));
		return "review";
	}
	
	@RequestMapping(value = "categories")
	public String getCategories(Model model) {
		model.addAttribute("categories",categoryRepo.findAll());
		return "categories";
	}
	
	@RequestMapping("/categories/{id}")
	public String getOneCategory(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("categories", categoryRepo.findOne(id));
		return "category";
	}
	
	@RequestMapping("/index.html")
    public String index() {
        return "index.html";
    
    }

}

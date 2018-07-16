package reviewsitefullstack.demo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewSiteFullStackController {
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	private CommentRepository commentRepo;
	
	@Resource
	TagRepository tagRepo;

	
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
	
    @RequestMapping("/index")
    public String home(Model model) {
       return "index";
    
   } 
        
    @RequestMapping(value = "/reviews/{id}", method = RequestMethod.POST)
	public String addComment(@PathVariable(name = "id") Long id, String comment) {
    	commentRepo.save(new Comment(comment, null, reviewRepo.findOne(id)));
		return "redirect:/reviews/{id}";
	}
    
    @RequestMapping("/tags")
	public String getActors(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tags/{id}")
	public String getActor(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tag";

	}
}




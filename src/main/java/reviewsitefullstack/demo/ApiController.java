package reviewsitefullstack.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	TagRepository tagRepo;
	
	@Autowired
	CommentRepository commentRepo;

	@RequestMapping("/reviews")
	public Collection<Review> getTags() {
		return (Collection<Review>) reviewRepo.findAll();
	}

	@RequestMapping("/reviews/{id}/comments")
	public Collection<Comment> getComments(@PathVariable(name = "id") Long id) {
		return (Collection<Comment>) reviewRepo.findById(id).getComments();
	}

	@RequestMapping(value = "/reviews/{id}/comments", method = RequestMethod.DELETE)
	public Collection<Comment> deleteComment(@PathVariable(name = "id") String name, @RequestParam(value = "id") Long id) {
		commentRepo.delete(id);
		return reviewRepo.findById(id).getComments();
	}
}


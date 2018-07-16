package reviewsitefullstack.demo;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@ManyToMany
	private Collection<Review> reviews;
	
	@Id
	@GeneratedValue
	private Long id;
	private String location;
	
	public Tag() {}
	
	public Tag(String location, Review...reviews) {
		this.location = location;
		this.reviews = Arrays.asList(reviews);
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	public Long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}
	
	
	
}
package reviewsitefullstack.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

		@Id
		@GeneratedValue
		private Long id;
		private String description;

		@OneToMany(mappedBy="category")
		private Collection<Review> reviews;
		
		public Category(String description) {
			this.description = description;
		}
		
		public Category(String description, Review... reviews) {
			super();
			this.description = description;
			this.reviews = new HashSet<>(Arrays.asList(reviews));
		}

		public String getDescription() {
			return description;
		}

		public Long getId() {
			return id;
		}
		
		public Category() {}
		
		public Collection<Review> getReviews() {
			return reviews;
		}

		@Override
		public String toString() {
			return description;
		}
}

	

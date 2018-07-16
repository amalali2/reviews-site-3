package reviewsitefullstack.demo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imgUrl;
	
	@Lob
	private String content;
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "review")
	private List<Comment> comments;
	
	@ManyToMany(mappedBy = "reviews")
	private Collection<Tag> tags;
	
	private Review() {}

	public Review(Long id, String title, String imgUrl, String content, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.category = category;
		
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public String getContent() {
		return content;
	}


	public Category getCategory() {
		return category;
	}
	
	public List<Comment> getComments() {
		return comments;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", imgUrl=" + imgUrl + ", content=" + content + category ;
	}
	
}

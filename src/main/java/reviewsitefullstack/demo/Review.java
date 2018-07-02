package reviewsitefullstack.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imgUrl;
	
	@Lob
	private String content;
	private int stars;

	@ManyToOne
	private Category category;
	
	private Review() {}


	public Review(Long id, String title, String imgUrl, String content, Category category, int stars) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.category = category;
		this.stars = stars;
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

	public int getStars() {
		return stars;
	}

	public Category getCategory() {
		return category;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", imgUrl=" + imgUrl + ", content=" + content + ", stars="
				+ stars + ", category=" + category + "]";
	}
	
}

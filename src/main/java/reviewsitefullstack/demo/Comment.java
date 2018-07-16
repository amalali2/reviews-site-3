package reviewsitefullstack.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long id;
	
	String username;
	String comment;
	
	@ManyToOne
	private Review review;
	
	public Comment() {}
	
	public Comment(String username, String comment, Review review) {
		this.username = username;
		this.comment = comment;
		this.review = review;
	}
	
	public long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public String getComment() {
		return comment;
	}


	@Override
	public String toString() {
		return "Comment [username=" + username + ", comment=" + comment ;
	}
	
}

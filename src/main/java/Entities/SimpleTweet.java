package Entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;
import Interfaces.Tweet;

@Entity
public class SimpleTweet implements Tweet{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private User author;
	@Column
	private Timestamp posted;
	@Column
	private String content;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, content, id, posted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleTweet other = (SimpleTweet) obj;
		return Objects.equals(author, other.author) && Objects.equals(content, other.content) && id == other.id
				&& Objects.equals(posted, other.posted);
	}

	@Override
	public String toString() {
		return "SimpleTweet [id=" + id + ", author=" + author + ", posted=" + posted + ", content=" + content + "]";
	}
	
}

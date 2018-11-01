package Entities;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;
import Interfaces.Tweet;

@Entity
public class ReplyTweet implements Tweet{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private User author;
	@Column
	private Timestamp posted;
	@Column
	private String content;
	@Column
	private Tweet inReplyTo;

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

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, content, id, inReplyTo, posted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyTweet other = (ReplyTweet) obj;
		return Objects.equals(author, other.author) && Objects.equals(content, other.content) && id == other.id
				&& Objects.equals(inReplyTo, other.inReplyTo) && Objects.equals(posted, other.posted);
	}

	@Override
	public String toString() {
		return "ReplyTweet [id=" + id + ", author=" + author + ", posted=" + posted + ", content=" + content
				+ ", inReplyTo=" + inReplyTo + "]";
	}

	
	
}

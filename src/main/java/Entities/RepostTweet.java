package Entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

import Interfaces.Tweet;

@Entity
public class RepostTweet implements Tweet{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column
	private User author;
	@Column
	private Timestamp posted;
	@Column
	private Tweet repostOf;

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

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, posted, repostOf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostTweet other = (RepostTweet) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(posted, other.posted)
				&& Objects.equals(repostOf, other.repostOf);
	}

	@Override
	public String toString() {
		return "RepostTweet [id=" + id + ", author=" + author + ", posted=" + posted + ", repostOf=" + repostOf + "]";
	}

}

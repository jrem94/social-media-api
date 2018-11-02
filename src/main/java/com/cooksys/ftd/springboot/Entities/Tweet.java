package com.cooksys.ftd.springboot.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@ManyToOne
	private User author;
	private Timestamp posted;
	private String content;
	@ManyToMany
	private List<Tweet> inReplyTo;
	@ManyToMany
	private List<Tweet> repostOf;
	private boolean isNotDeleted = true;

	public Integer getId() {
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

	public List<Tweet> getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(List<Tweet> inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public List<Tweet> getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(List<Tweet> repostOf) {
		this.repostOf = repostOf;
	}

	public boolean isNotDeleted() {
		return isNotDeleted;
	}

	public void setNotDeleted(boolean isNotDeleted) {
		this.isNotDeleted = isNotDeleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, content, id, inReplyTo, isNotDeleted, posted, repostOf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		return Objects.equals(author, other.author) && Objects.equals(content, other.content)
				&& Objects.equals(id, other.id) && Objects.equals(inReplyTo, other.inReplyTo)
				&& isNotDeleted == other.isNotDeleted && Objects.equals(posted, other.posted)
				&& Objects.equals(repostOf, other.repostOf);
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", author=" + author + ", posted=" + posted + ", content=" + content + ", inReplyTo="
				+ inReplyTo + ", repostOf=" + repostOf + ", isNotDeleted=" + isNotDeleted + "]";
	}

}

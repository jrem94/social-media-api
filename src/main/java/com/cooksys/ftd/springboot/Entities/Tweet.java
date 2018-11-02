package com.cooksys.ftd.springboot.Entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

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

}

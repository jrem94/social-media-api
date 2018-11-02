package com.cooksys.ftd.springboot.Entities;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Context {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@OneToMany
	private Tweet target;
	private ArrayList<Tweet> before;
	private ArrayList<Tweet> after;
	
	public Context() {}
	
	public Context(Tweet target, ArrayList<Tweet> before, ArrayList<Tweet> after) {
		this.target = target;
		this.before = before;
		this.after = after;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tweet getTarget() {
		return target;
	}

	public void setTarget(Tweet target) {
		this.target = target;
	}

	public ArrayList<Tweet> getBefore() {
		return before;
	}

	public void setBefore(ArrayList<Tweet> before) {
		this.before = before;
	}

	public ArrayList<Tweet> getAfter() {
		return after;
	}

	public void setAfter(ArrayList<Tweet> after) {
		this.after = after;
	}

	@Override
	public int hashCode() {
		return Objects.hash(after, before, target);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Context other = (Context) obj;
		return Objects.equals(after, other.after) && Objects.equals(before, other.before)
				&& Objects.equals(target, other.target);
	}

	@Override
	public String toString() {
		return "Context [target=" + target + ", before=" + before + ", after=" + after + "]";
	}
	
}

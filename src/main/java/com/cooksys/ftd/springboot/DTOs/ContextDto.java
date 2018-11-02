package com.cooksys.ftd.springboot.DTOs;

import java.util.ArrayList;

import com.cooksys.ftd.springboot.Entities.Tweet;

public class ContextDto {

	private Tweet target;
	private ArrayList<Tweet> before;
	private ArrayList<Tweet> after;

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

}
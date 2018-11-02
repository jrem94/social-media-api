package com.cooksys.ftd.springboot.Entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hashtag {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String label;
	private Timestamp firstUsed;
	private Timestamp lastUsed;

	public Hashtag() {
	}

	public Hashtag(String label, Timestamp firstUsed, Timestamp lastUsed) {
		this.label = label;
		this.firstUsed = firstUsed;
		this.lastUsed = lastUsed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFirstUsed() {
		return firstUsed;
	}

	public void setFirstUsed(Timestamp firstUsed) {
		this.firstUsed = firstUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstUsed, id, label, lastUsed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashtag other = (Hashtag) obj;
		return Objects.equals(firstUsed, other.firstUsed) && Objects.equals(id, other.id)
				&& Objects.equals(label, other.label) && Objects.equals(lastUsed, other.lastUsed);
	}

	@Override
	public String toString() {
		return "Hashtag [id=" + id + ", label=" + label + ", firstUsed=" + firstUsed + ", lastUsed=" + lastUsed + "]";
	}

}

package com.cooksys.ftd.springboot.Entities;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Profile {

	private String firstname;
	private String lastname;
	private String email;
	private String phone;

	public Profile() {
	}

	public Profile(String firstname, String lastname, String email, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, lastname, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Profile [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}

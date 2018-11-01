package Entities;

import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class Credentials {

	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	public Credentials() {}
	
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}
	
}

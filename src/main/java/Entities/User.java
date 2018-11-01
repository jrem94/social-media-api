package Entities;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(unique = true)
	private String username;
	@Embedded
	private Profile profile;
	@Embedded
	private Credentials credentials;
	@Column(updatable = false)
	private Timestamp joined;
	
	public User() {}
	
	public User(String username, Profile profile, Timestamp joined) {
		this.username = username;
		this.profile = profile;
		this.joined = joined;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	@Override
	public int hashCode() {
		return Objects.hash(joined, profile, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(joined, other.joined) && Objects.equals(profile, other.profile)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", profile=" + profile + ", joined=" + joined + "]";
	}
	
}

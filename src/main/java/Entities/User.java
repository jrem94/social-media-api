package Entities;

import java.sql.Timestamp;
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
	@Column
	private boolean isActive;
	
	public User() {}
	
	public User(String username, Profile profile, Timestamp joined) {
		this.username = username;
		this.profile = profile;
		this.joined = joined;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
}

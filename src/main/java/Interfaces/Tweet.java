package Interfaces;

import java.sql.Timestamp;
import Entities.User;

public interface Tweet {
	
	int getId();
	
	void setId(Integer id);
	
	User getAuthor();
	
	void setAuthor(User author);
	
	Timestamp getPosted();
	
	void setPosted(Timestamp posted);
	
}

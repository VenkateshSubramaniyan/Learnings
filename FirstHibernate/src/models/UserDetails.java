package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int userId;
	

	String userName;

	public UserDetails(String userName) {
		super();
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}

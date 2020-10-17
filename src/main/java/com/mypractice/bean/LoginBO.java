package com.mypractice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="employee")
final public class LoginBO {
	
	@Column(name="userID")
	@NotEmpty(message = "{user.validation.msg}")
	private String userID;
	@Column(name="userpass")
	@NotEmpty(message = "{password.validation.msg}")
	private String userpass;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	@Override
	public String toString() {
		return "LoginBO [userID=" + userID + ", userpass=" + userpass + "]";
	}
	public LoginBO( String userID,
			 String userpass) {
		super();
		this.userID = userID;
		this.userpass = userpass;
	}
	public LoginBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

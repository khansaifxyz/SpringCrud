package com.mypractice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "EmpRegister")
public final class RegisterBO {

	//@Id
	//@Column(name = "emp_id", updatable = false, nullable = false)
	private int empid;
	
	@Column(name = "FIRST_NAME", columnDefinition = "varchar(50)")
	@NotEmpty(message = "{firstname.validation.msg}")
	private String firstName;
	
	@Column(name = "LAST_NAME", columnDefinition = "varchar(50)")
	@NotEmpty(message = "{lastname.validation.msg}")
	private String lastName;
	
	@Column(name = "PASSWORD", columnDefinition = "varchar(20)")
	@NotEmpty(message = "{password.validation.msg}")
	private String password;
	
	@NotEmpty(message = "{confirmpassword.validation.msg}")
	private String confirmPassword;
	
	@Column(name = "EMAIL", columnDefinition = "varchar(50)")
	@Email(message = "{email.validation.msg}")
	private String email;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "RegisterBO [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", email=" + email + "]";
	}

}

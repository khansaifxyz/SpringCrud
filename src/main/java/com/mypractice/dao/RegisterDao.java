package com.mypractice.dao;

import java.util.List;

import com.mypractice.bean.LoginBO;
import com.mypractice.bean.RegisterBO;

public interface RegisterDao {

	public int saveEmployee(RegisterBO registerBO);

	public RegisterBO getEmployeeById(int id);

	public int updateEmployee(RegisterBO registerBO);

	public int deleteEmployee(int empid);

	public LoginBO loginUser(LoginBO loginBO);

	public List<RegisterBO> getAllEmployees();


	//RegisterBO getEmployeeById(int empid);

	
}

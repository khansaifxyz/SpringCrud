package com.mypractice.dao;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mypractice.bean.LoginBO;
import com.mypractice.bean.RegisterBO;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	private JdbcTemplate jdbcTemplate;

	public RegisterDaoImpl(DataSource dataSource)

	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(RegisterBO registerBO) {

		String sql = "insert into EmpRegister values(?,?,?,?,?)";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { registerBO.getEmpid(), registerBO.getFirstName(),
					registerBO.getLastName(), registerBO.getPassword(), registerBO.getEmail() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public LoginBO loginUser(LoginBO loginBO) {
		

		try {
			String sql = "select userID as userID,userpass as userpass  from employee where userID=? and userpass=?";

			LoginBO login = jdbcTemplate.queryForObject(sql,
					new Object[] { loginBO.getUserID(), loginBO.getUserpass() },
					(rs, rowNum) -> new LoginBO(rs.getString("userID"), rs.getString("userpass")));

			return login;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int updateEmployee(RegisterBO registerBO) {
		
		String sql="update empregister set FIRST_NAME=?,LAST_NAME=?, EMAIL=? where EMP_ID=?";
		int updateDate=jdbcTemplate.update(sql,new Object[] {registerBO.getFirstName(),registerBO.getLastName(),registerBO.getEmail(),registerBO.getEmpid()});
		
		return updateDate;
	}

	@Override
	public int deleteEmployee(int empid) {
		String sql="delete from empregister where emp_id=?";
		
		try {
			
			int counter=jdbcTemplate.update(sql,new Object[] {empid});
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public  RegisterBO getEmployeeById(int id) {
		
		String sql = "select * from empregister where EMP_ID=?";
		
		RegisterBO registerBO = (RegisterBO) jdbcTemplate.queryForObject(sql, new Object[]
	        { id }, new RowMapper<Object>()
	        {
	            @Override
	            public RegisterBO mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	RegisterBO registerBO = new RegisterBO();
	            	registerBO.setEmpid(id);
	            	registerBO.setFirstName(rs.getString(2));
	            	registerBO.setLastName(rs.getString(3));
	            	registerBO.setPassword(rs.getString(4));
	            	registerBO.setEmail(rs.getString(5));
	                return registerBO;
	            }
	        });System.out.println(registerBO);
	        return registerBO;
	}

	@Override
	public List<RegisterBO> getAllEmployees() {

		String sql = "select * from empregister";
		
		List<RegisterBO> employeelist = jdbcTemplate.query(sql, new ResultSetExtractor<List<RegisterBO>>() {

			@Override
			public List<RegisterBO> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<RegisterBO> list = new ArrayList<>();

				while (rs.next()) {

					RegisterBO register = new RegisterBO();
					register.setEmpid(rs.getInt(1));
					register.setFirstName(rs.getString(2));
					register.setLastName(rs.getString(3));
					register.setPassword(rs.getString(4));
					register.setEmail(rs.getString(5));

					list.add(register);
				}
				//list.forEach(System.out::println);
				
				return list;
			}
		});
		///System.out.println(employeelist);
		return employeelist;
	}

/*	@Override
	public RegisterBO getEmployeeById(int empid) {
		
		String sql="Select * from empregister where emp_id=?";
		
		jdbcTemplate.queryForObject(sql, new Object[] {id} new RowMapper() {
			
			public 
		}))
		return null;*/
	//}
}

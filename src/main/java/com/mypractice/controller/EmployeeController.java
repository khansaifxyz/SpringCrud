package com.mypractice.controller;

import java.util.function.Predicate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mypractice.bean.LoginBO;
import com.mypractice.bean.RegisterBO;
import com.mypractice.dao.RegisterDao;

@Controller
@RequestMapping("/employee")
final public class EmployeeController {

	@Autowired
	private RegisterDao registerDao;

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeePage(Model model) {
		model.addAttribute("loginBean", new LoginBO());
		return "employee";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String chkUsrLogin(@ModelAttribute("loginBean") @Validated LoginBO loginBO, BindingResult bindingResult,
			ModelMap map) {

		if (bindingResult.hasErrors()) {

			return "employee";
		}
		Predicate<LoginBO> checkUser = l -> registerDao.loginUser(loginBO) != null;

		if (checkUser.test(loginBO)) {
			map.put("listEmployee", registerDao.getAllEmployees());
			return "dashboard";
		} else {
			map.put("msg", "Invalid User");
			return "employee";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("registerBean", new RegisterBO());
		return "register";

	}

	@RequestMapping(value = "/saveRegister", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute("registerBean") @Valid RegisterBO registerBO,
			BindingResult bindingResult, ModelMap map) {

		if (bindingResult.hasErrors()) {
			return "register";
		}

		int counter = registerDao.saveEmployee(registerBO);
		if (counter > 0) {
			map.put("listEmployee",registerDao.getAllEmployees());
			return "redirect:/employee/dashboard.do";
		}
		return "register";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id,
			 ModelMap map) {
		System.out.println(id);
		map.addAttribute("registerBean", new RegisterBO());
		map.addAttribute("employeeList", registerDao.getEmployeeById(id));
		return "empUpdate";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateEmployee")
	public String updateEmployee(RegisterBO registerBO, BindingResult bindingResult, ModelMap map) {
		int counter = registerDao.updateEmployee(registerBO);
		map.put("listEmployee", registerDao.getAllEmployees());
		return "redirect:/employee/dashboard.do";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id,ModelMap map) {
		registerDao.deleteEmployee(id);
		map.put("listEmployee", registerDao.getAllEmployees());
		return "redirect:/employee/dashboard.do";
	}
	
	
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/dashboard")
	public String redirectPage(ModelMap map) {
		map.put("listEmployee", registerDao.getAllEmployees());
		return "dashboard" ;
	}
}

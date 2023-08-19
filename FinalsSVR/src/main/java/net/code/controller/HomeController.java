package net.code.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.code.MailUtil;
import net.code.dao.StudentLoginDao;
import net.code.model.Students;




@Controller
public class HomeController {
	@Autowired
	private Students students;
	@Autowired
	private StudentLoginDao StudentLogin;

	@RequestMapping("/email")
	public String email(Model model, @RequestParam("email") String email,@RequestParam("studentname") String studentname, 
			@RequestParam("studentpass") String studentpass) {
		
		String salt = BCrypt.gensalt(10);
		String hpassword = BCrypt.hashpw(studentpass, salt);
		
		students.setEmail(email);
		students.setStudentname(studentname);
		students.setStudentpass(hpassword); 
		
		Students validation = StudentLogin.findByEmail(email);
		students.setAdminid(students.getFullid());
		if(validation == null) {
		int result = StudentLogin.SaveRegistration(students);
		if(result > 0) {
			System.out.println("saved");	}
		return "redirect:/welcome";
		}
		model.addAttribute("msg","Email Already In Use");
		return "add";
				}
	
	@RequestMapping("/edit")
	public String edit(Model model, @RequestParam("idnumber") int idnumber) {
		Students students = StudentLogin.findByUserId(idnumber);
		model.addAttribute("students", students);
		return "edit";
		}
	
	@RequestMapping("/update")
	public String update(Model model, @RequestParam("idnumber") int idnumber, @RequestParam("email") String email, 
			@RequestParam("studentname") String studentname) {
		
		
		Students validation = StudentLogin.findByEmail(email);
		if(validation == null) {
			students.setEmail(email);
			students.setStudentname(studentname);
			students.setIdnumber(idnumber);
			StudentLogin.updateStudentRegistration(students);
			return "redirect:/welcome";
					}
		else if(validation != null) {
			model.addAttribute("msg", "Email already in Use");
			return "edit";
		}
		return "edit";
		}
	
	@RequestMapping("/addteach")
	public String addteach() {
		return "addteach";
		}
	@RequestMapping("/addition")
	public String addition(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		String salt = BCrypt.gensalt(10);
		String hpassword = BCrypt.hashpw(password, salt);

		students.setUsername(username);
		students.setPassword(hpassword);
		 
		int result = StudentLogin.SaveRegistrationAdmin(students);
		if(result > 0) {
			System.out.println("saved");	}
		return "redirect:/welcome";
	}


	@RequestMapping("/index")
	public String index() {
		return "index";
		}
	@RequestMapping("/add")
	public String add() {
		return "add";
		}
		
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
		}	
	@RequestMapping("/reset")
		public String reset() {
			StudentLogin.ResetAttendance(students.getFullid());
			return "redirect:/welcome";
			}
	@RequestMapping("/choose")
	public String choose() {
		return "choose";
		}
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		List<Students> listOfUsers = StudentLogin.listAllUsersAdmin(students.getFullid());
		model.addAttribute("listOfUsers", listOfUsers);
	
		return "/welcome";
		}
	@RequestMapping("/attendance")
	public String attendance() {
		
		return "attendance";
		}
	
	@RequestMapping("/attend")
	public String attend(Model model,@RequestParam("email")String email,
						   				@RequestParam("studentpass")String studentpass) {
			
			Students students = StudentLogin.findByEmail(email);
			if(students == null) {
				model.addAttribute("msg" , "Invalid Login Credentials");
				return "index";
			}

			boolean checkPassword = BCrypt.checkpw(studentpass,students.getStudentpass());
			if(!checkPassword) {
				model.addAttribute("msg" , "Invalid Login Credentials");
				return "index";
			}
			StudentLogin.AddAttendance(students.getIdnumber());
			StudentLogin.findByUserId(students.getIdnumber());
			model.addAttribute("students", students);
			return "attendance";
			}

@RequestMapping("/checkadmin")
public String checkadmin(Model model,@RequestParam("adminname")String adminname,
					   				@RequestParam("adminpass")String adminpass, @RequestParam("key") String key) {
	
	
	Students validate = StudentLogin.findByAdmin(adminname);
	
	if(validate == null) {
		model.addAttribute("msg" , "Invalid Login Credentials");
		return "admin";
	}

	boolean checkPassword = BCrypt.checkpw(adminpass,validate.getPassword());
	
	if(!checkPassword) {
		
			model.addAttribute("msg" , "Invalid Login Credentials");
			return "admin";
		}
		String recipient = adminname;
		MailUtil.sendMessage(recipient,key);
		model.addAttribute("recipient", recipient);
		students.setKey(key);
		model.addAttribute("key", students.getKey());
		students.setFullid(validate.getAdminid());
		return "redirect:/otp";
	}

		
	@RequestMapping("/otp")
	public String otp(Model model) {
		model.addAttribute("key", students.getKey());
		return "otp";
		}

		@RequestMapping("/otpcheck")
		public String otpcheck(Model model, @RequestParam("otp") String otp, @RequestParam("key") String key) {
			if(!otp.equals(key)){
				model.addAttribute("msg", "passwords do not match");
				return "redirect:/otp";
			}
			return "redirect:/welcome";
			}


@RequestMapping("/delete")
public String delete(@RequestParam("idnumber") int idnumber) {
	StudentLogin.deleteStudent(idnumber);

	return "redirect:/welcome";
	}
}
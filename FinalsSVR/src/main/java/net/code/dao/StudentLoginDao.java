package net.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import net.code.model.Students;

@Component
public interface StudentLoginDao {
	public List<Students> listAllUsersAdmin(int idnumber);
	public Students findByAdmin(String adminname);
	public int SaveRegistrationAdmin(Students students);
	public void updateStudentRegistration(Students students);
	public void deleteStudent(int idnumber);
	public int ResetAttendance(int adminid);
	public Students findByEmail(String email);
	public boolean StudentLogin(String email,String studentpass);
	public boolean Adminlogin(String username,String password);
	public int AddAttendance(int idnumber);
	public Students validateEmail(int idnumber,String studentpass);
	public List<Students> listAllUsers();
	public Students findByUserId(int userId);
	public int SaveRegistration(Students students);
	}


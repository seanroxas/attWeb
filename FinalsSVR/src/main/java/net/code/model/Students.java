package net.code.model;

import org.springframework.stereotype.Component;

@Component
public class Students {
	
	public int adminid;
	public String username;
	public String password;
	public int fullid;
	public String key;
	
	public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public int getFullid() {
		return fullid;
	}
	public void setFullid(int fullid) {
		this.fullid = fullid;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String email;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentpass() {
		return studentpass;
	}
	public void setStudentpass(String studentpass) {
		this.studentpass = studentpass;
	}
	public int idnumber;
	
	public int getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}
	public String studentpass;
	
	public int status;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String studentname;

	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
}

package net.code.dao;

import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.code.model.Students;






@Repository
public class StudentLoginDaoImpl implements StudentLoginDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean StudentLogin(String email,String studentpass){
		 return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT * FROM emergingtech.dbstuds WHERE email = ? and studentpass = ?)"
				 ,Boolean.class, email,studentpass);
	}
	@Override
	public boolean Adminlogin(String username,String password){
		 return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT * FROM emergingtech.admin WHERE username = ? and password = ?)"
				 ,Boolean.class, username,password);
	}
	@Override
    public Students findByEmail(String email) {
        String sql="SELECT * FROM emergingtech.dbstuds WHERE email = '" + email + "'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Students>() {

			@Override
			public Students extractData(ResultSet rs) throws SQLException, DataAccessException {
		                if (rs.next()) {
		                	Students students = new Students();
							students.setIdnumber(rs.getInt("idnumber"));
							students.setEmail(rs.getString("email"));
							students.setStudentname(rs.getString("studentname"));
							students.setStudentpass(rs.getString("studentpass"));
							students.setStatus(rs.getInt("status"));
							students.setAdminid(rs.getInt("profid"));
							return students;
		                }
		                return null;
		            }
        });
    }
	 
	@Override
    public Students findByAdmin(String adminname) {
        String sql="SELECT * FROM emergingtech.admin WHERE username = '" + adminname + "'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Students>() {

			@Override
			public Students extractData(ResultSet rs) throws SQLException, DataAccessException {
		                if (rs.next()) {
		                	Students students = new Students();
							students.setAdminid(rs.getInt("adminId"));
							students.setUsername(rs.getString("username"));
							students.setPassword(rs.getString("password"));
							return students;
		                }
		                return null;
		            }
        });
    }
	
	@Override
	public List<Students> listAllUsersAdmin(int idnumber){
		 String sql="SELECT * FROM emergingtech.dbstuds where profid = '" + idnumber + "'";
		 List<Students> listOfUsers = jdbcTemplate.query(sql, new RowMapper<Students>()
				 {
					@Override
					public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Students students = new Students();
						students.setIdnumber(rs.getInt("idnumber"));
						students.setEmail(rs.getString("email"));
						students.setStudentname(rs.getString("studentname"));
						students.setStudentpass(rs.getString("studentpass"));
						students.setStatus(rs.getInt("status"));
						students.setAdminid(rs.getInt("profid"));
						return students;
					}
				 });
		return listOfUsers;
	}
	
	@Override
	public int AddAttendance(int idnumber) {
		String sql="update emergingtech.dbstuds set status = '1' WHERE idnumber = '"+idnumber+"'";
		return jdbcTemplate.update(sql);
	}
	@Override
	public int ResetAttendance(int adminid) {
		String sql="update emergingtech.dbstuds set status = '0' Where profid= '"+adminid+"'";
		return jdbcTemplate.update(sql);
	}
	@Override
	public Students validateEmail(int idnumber,String studentpass){
		String sql="Select * From emergingtech.students where idnumber = '"+ idnumber +"' and studentpass= '" +studentpass+"'";
		return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Students.class));
	}

@Override
public List<Students> listAllUsers(){
	 String sql="SELECT * FROM emergingtech.dbstuds";
	 List<Students> listOfUsers = jdbcTemplate.query(sql, new RowMapper<Students>()
			 {
				@Override
				public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Students students = new Students();
					students.setIdnumber(rs.getInt("idnumber"));
					students.setEmail(rs.getString("email"));
					students.setStudentname(rs.getString("studentname"));
					students.setStudentpass(rs.getString("studentpass"));
					students.setStatus(rs.getInt("status"));
					return students;
				}
			 });
	return listOfUsers;
}

@Override
public Students findByUserId(int idnumber) {
	String sql="SELECT * FROM emergingtech.dbstuds WHERE idnumber = '" + idnumber + "'";
	return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Students.class));
}


@Override
public int SaveRegistration(Students students) {
	String sql="INSERT INTO emergingtech.dbstuds(email,studentname,studentpass,profid) VALUES ('"+students.getEmail() + "'"
			+ ",'"+students.getStudentname() + "','" + students.getStudentpass() + "','" + students.getAdminid() +"')";
	return jdbcTemplate.update(sql);
}

@Override
public int SaveRegistrationAdmin(Students students) {
	String sql="INSERT INTO emergingtech.admin(username,password) VALUES ('"+students.getUsername() + "','" + students.getPassword() + "')";
	return jdbcTemplate.update(sql);
}
@Override
public void deleteStudent(int idnumber) {
	String sql="Delete from emergingtech.dbstuds WHERE idnumber=?";
	jdbcTemplate.update(sql, idnumber);
	
}
@Override
public void updateStudentRegistration(Students students) {
	String sql="UPDATE emergingtech.dbstuds SET email=?, studentname=? WHERE idnumber=?";
	jdbcTemplate.update(sql, students.getEmail(), students.getStudentname(), students.getIdnumber());
}
}


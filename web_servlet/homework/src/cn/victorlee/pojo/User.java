package cn.victorlee.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	private char is_admin = 'n';
	private char is_cicos = 'n';
	private String student_id;
	private String student_name;
	private String email;
	private String register_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Date());
	private char status = '1';
	private String validate_code = "no define";

	public User() {
		super();
	}

	public User(String account, String password, char is_admin, char is_cicos,
			String student_id, String student_name, String email,
			String register_time, char status, String validate_code) {
		super();
		this.account = account;
		this.password = password;
		this.is_admin = is_admin;
		this.is_cicos = is_cicos;
		this.student_id = student_id;
		this.student_name = student_name;
		this.email = email;
		this.register_time = register_time;
		this.status = status;
		this.validate_code = validate_code;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(char is_admin) {
		this.is_admin = is_admin;
	}

	public char getIs_cicos() {
		return is_cicos;
	}

	public void setIs_cicos(char is_cicos) {
		this.is_cicos = is_cicos;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getValidate_code() {
		return validate_code;
	}

	public void setValidate_code(String validate_code) {
		this.validate_code = validate_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password
				+ ", is_admin=" + is_admin + ", is_cicos=" + is_cicos
				+ ", student_id=" + student_id + ", student_name="
				+ student_name + ", email=" + email + ", register_time="
				+ register_time + ", status=" + status + ", validate_code="
				+ validate_code + "]";
	}

}

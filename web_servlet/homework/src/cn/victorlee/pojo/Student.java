package cn.victorlee.pojo;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String student_id;
	private String student_name;
	private char is_cicos = 'n';
	private char sex = '男';
	private String university;
	private String department;
	private String clazz;
	private String entrance = "2013-09-01";
	private String graduation = "2017-07-01";

	public Student() {
		super();
	}

	public Student(String student_id, String student_name, char is_cicos,
			char sex, String university, String department, String clazz,
			String entrance, String graduation) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.is_cicos = is_cicos;
		this.sex = sex;
		this.university = university;
		this.department = department;
		this.clazz = clazz;
		this.entrance = entrance;
		this.graduation = graduation;
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

	public char getIs_cicos() {
		return is_cicos;
	}

	public void setIs_cicos(char is_cicos) {
		this.is_cicos = is_cicos;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name="
				+ student_name + ", is_cicos=" + is_cicos + ", sex=" + sex
				+ ", university=" + university + ", department=" + department
				+ ", clazz=" + clazz + ", entrance=" + entrance
				+ ", graduation=" + graduation + "]";
	}

}

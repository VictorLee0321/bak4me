package cn.victorlee.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	// primary key ---
	private String cicos_id;
	private String course_name;
	private int exp_num;
	// --- primary key
	private String example_name;
	private String university;
	private String department;
	private String clazz;
	private String last_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Date());
	private String term = "2016-09-01";

	public Course() {
		super();
	}

	public Course(String cicos_id, String course_name, int exp_num,
			String example_name, String university, String department,
			String clazz, String last_time, String term) {
		super();
		this.cicos_id = cicos_id;
		this.course_name = course_name;
		this.exp_num = exp_num;
		this.example_name = example_name;
		this.university = university;
		this.department = department;
		this.clazz = clazz;
		this.last_time = last_time;
		this.term = term;
	}

	public String getCicos_id() {
		return cicos_id;
	}

	public void setCicos_id(String cicos_id) {
		this.cicos_id = cicos_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getExp_num() {
		return exp_num;
	}

	public void setExp_num(int exp_num) {
		this.exp_num = exp_num;
	}

	public String getExample_name() {
		return example_name;
	}

	public void setExample_name(String example_name) {
		this.example_name = example_name;
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

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Course [cicos_id=" + cicos_id + ", course_name=" + course_name
				+ ", exp_num=" + exp_num + ", example_name=" + example_name
				+ ", university=" + university + ", department=" + department
				+ ", clazz=" + clazz + ", last_time=" + last_time + ", term="
				+ term + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cicos_id == null) ? 0 : cicos_id.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result
				+ ((course_name == null) ? 0 : course_name.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((example_name == null) ? 0 : example_name.hashCode());
		result = prime * result + exp_num;
		result = prime * result
				+ ((last_time == null) ? 0 : last_time.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		result = prime * result
				+ ((university == null) ? 0 : university.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		
		if (this.cicos_id.equals(other.cicos_id) && this.course_name.equals(other.course_name) && this.exp_num == other.exp_num) {
			return true;
		}
		
		if (cicos_id == null) {
			if (other.cicos_id != null)
				return false;
		} else if (!cicos_id.equals(other.cicos_id))
			return false;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (course_name == null) {
			if (other.course_name != null)
				return false;
		} else if (!course_name.equals(other.course_name))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (example_name == null) {
			if (other.example_name != null)
				return false;
		} else if (!example_name.equals(other.example_name))
			return false;
		if (exp_num != other.exp_num)
			return false;
		if (last_time == null) {
			if (other.last_time != null)
				return false;
		} else if (!last_time.equals(other.last_time))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (university == null) {
			if (other.university != null)
				return false;
		} else if (!university.equals(other.university))
			return false;
		return true;
	}
	
	

}

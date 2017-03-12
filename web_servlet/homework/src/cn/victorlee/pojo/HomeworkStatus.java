package cn.victorlee.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeworkStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	// primary key ---
	private String student_id;
	private String cicos_id;
	private String course_name;
	private int exp_num;
	// --- primary key
	private String file_name;
	private String exp_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(new Date());
	private char is_overtime = 'n';
	private String exp_path;

	public HomeworkStatus() {
		super();
	}

	public HomeworkStatus(String student_id, String cicos_id,
			String course_name, int exp_num, String file_name, String exp_time,
			char is_overtime, String exp_path) {
		super();
		this.student_id = student_id;
		this.cicos_id = cicos_id;
		this.course_name = course_name;
		this.exp_num = exp_num;
		this.file_name = file_name;
		this.exp_time = exp_time;
		this.is_overtime = is_overtime;
		this.exp_path = exp_path;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
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

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getExp_time() {
		return exp_time;
	}

	public void setExp_time(String exp_time) {
		this.exp_time = exp_time;
	}

	public char getIs_overtime() {
		return is_overtime;
	}

	public void setIs_overtime(char is_overtime) {
		this.is_overtime = is_overtime;
	}

	public String getExp_path() {
		return exp_path;
	}

	public void setExp_path(String exp_path) {
		this.exp_path = exp_path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HomeworkStatus [student_id=" + student_id + ", cicos_id="
				+ cicos_id + ", course_name=" + course_name + ", exp_num="
				+ exp_num + ", file_name=" + file_name + ", exp_time="
				+ exp_time + ", is_overtime=" + is_overtime + ", exp_path="
				+ exp_path + "]";
	}

}

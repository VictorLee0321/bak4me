package cn.victorlee.pojo;

public class CourseNET3 {

	private String course_name;
	private int exp_num;
	private String last_time;

	public CourseNET3() {
		super();
	}

	public CourseNET3(String course_name, int exp_num, String last_time) {
		super();
		this.course_name = course_name;
		this.exp_num = exp_num;
		this.last_time = last_time;
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

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

}

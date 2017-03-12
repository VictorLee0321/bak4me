package cn.victorlee.pojo;

public class StudentIDN2 {

	private String student_id;
	private String student_name;

	public StudentIDN2() {
		super();
	}

	public StudentIDN2(String student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((student_id == null) ? 0 : student_id.hashCode());
		result = prime * result
				+ ((student_name == null) ? 0 : student_name.hashCode());
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
		StudentIDN2 other = (StudentIDN2) obj;
		
		if (this.student_id.equals(other.getStudent_id()) && this.student_name.equals(other.getStudent_name()))
			return true;
		
		if (student_id == null) {
			if (other.student_id != null)
				return false;
		} else if (!student_id.equals(other.student_id))
			return false;
		if (student_name == null) {
			if (other.student_name != null)
				return false;
		} else if (!student_name.equals(other.student_name))
			return false;
		return true;
	}

}


public class Student {

	public String name;
	public int idNum;

	public Student(String name, int id){
		this.name = name;
		this.idNum = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return idNum == student.idNum &&
				name.equals(student.name);
	}

	@Override
	public String toString() {
		return "Student [Name=" + this.name + ", ID=" + this.idNum + "]%n";
	}


}

public class Student extends UniversityMember {

    Advisor advisor = new Advisor();

    public String studentYear;
    public int studentNumber;
    public static int IDNUMBER = 1000;

    public Student() {
        studentNumber = 0;
        studentYear = "";
    }

    public Student(String name, Advisor advisor, String year) {
        super.setMemberName(name);
        this.advisor = advisor;
        this.studentYear = year;
        this.setStudentNumber();

    }

    public Advisor getAdv() {
        return advisor;
    }

    public void setAdv(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber() {
        this.studentNumber = IDNUMBER;
        Student.IDNUMBER++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (super.getMemberName() != other.memberName)
            return false;
        if (studentNumber != other.studentNumber)
            return false;
        if (studentYear == null) {
            if (other.studentYear != null)
                return false;
        } else if (!studentYear.equals(other.studentYear))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "with ID number " + getStudentNumber() + " is in the " + getStudentYear() + " class";
    }

}
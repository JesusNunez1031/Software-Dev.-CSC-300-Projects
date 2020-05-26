import java.util.ArrayList;

public class Advisor extends UniversityMember {

    public String department;
    public ArrayList<Student> advStudentList = new ArrayList<Student>();

    public Advisor(){
        department = "";
    }

    public Advisor(String name, String department) {
        super.setMemberName(name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void addStudentToAdvisor(Student student) {
        advStudentList.add(student);
    }

    public Student getStudentFromAdvisorList(int index) {
        return advStudentList.get(index);
    }

    public int getNumStudentsInAdvisorList(){
        return advStudentList.size();
    }

    @Override
    public String toString() {
        return super.toString() + "of the " + getDepartment() + " Department ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Advisor other = (Advisor) obj;
        if (department == null) {
            if (other.department != null)
                return false;
        if(super.memberName.equals(other.memberName))
            return false;    
        } else if (!department.equals(other.department))
            return false;
        return true;
    }

}
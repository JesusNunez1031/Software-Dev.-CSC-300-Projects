public class UniversityMember {

    public String memberName;

    public UniversityMember() {
        memberName = "";
    }

    public UniversityMember(final String name) {
        setMemberName(name);
    }

    // Getter function
    public String getMemberName() {
        return memberName;
    }

    // Setter function for name
    public void setMemberName(final String name) {
        this.memberName = name;
    }

    @Override
    public String toString() {
        return  " " + memberName + " ";
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UniversityMember other = (UniversityMember) obj;
        if (memberName == null) {
            if (other.memberName != null)
                return false;
        } else if (!memberName.equals(other.memberName))
            return false;
        return true;
    }

}
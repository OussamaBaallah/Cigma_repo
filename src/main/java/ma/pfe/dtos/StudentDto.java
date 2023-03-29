package ma.pfe.dtos;


import java.util.List;

public class StudentDto {


    private StudentIdDto studentId;
    private String name;
    private List<CourseDto> courses;
    private AddressDto addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentIdDto getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentIdDto studentId) {
        this.studentId = studentId;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public AddressDto getAddresses() {
        return addresses;
    }

    public void setAddresses(AddressDto addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", addresses=" + addresses +
                '}';
    }
}

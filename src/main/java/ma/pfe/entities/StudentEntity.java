package ma.pfe.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class StudentEntity {
    @EmbeddedId
    private StudentId studentId;
    @Column(name = "student_name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue",column = @Column(name = "rue_student")),
            @AttributeOverride(name = "avenue",column = @Column(name = "avenue_student"))
    })
    private Address addresses;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "list_courses_student")
    private List<CourseEntity> courses;

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                ", courses=" + courses +
                '}';
    }
}

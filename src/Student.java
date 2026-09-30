import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Öğrenci Modeli (STUDENTS tablosu)
 */
public class Student extends BasePerson {
    private String studentNo;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private Program program;
    private int enrollmentYear;
    private int classYear;
    private StudentStatus status;
    private String photoUrl;
    private LocalDateTime createdAt;

    public Student() { super(); }

    public Student(UUID id, String nationalId, String firstName, String lastName, String email, String phone,
                   String studentNo, LocalDate birthDate, Gender gender, String address,
                   Program program, int enrollmentYear, int classYear, StudentStatus status,
                   String photoUrl, LocalDateTime createdAt) {
        super(id, nationalId, firstName, lastName, email, phone);
        this.studentNo = studentNo;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.program = program;
        this.enrollmentYear = enrollmentYear;
        this.classYear = classYear;
        this.status = status;
        this.photoUrl = photoUrl;
        this.createdAt = createdAt;
    }

    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }

    public int getEnrollmentYear() { return enrollmentYear; }
    public void setEnrollmentYear(int enrollmentYear) { this.enrollmentYear = enrollmentYear; }

    public int getClassYear() { return classYear; }
    public void setClassYear(int classYear) { this.classYear = classYear; }

    public StudentStatus getStatus() { return status; }
    public void setStatus(StudentStatus status) { this.status = status; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Öğrenci: " + getFullName() + " (" + studentNo + ") | " +
               "Program: " + (program != null ? program.getName() : "-") + " | " +
               "Sınıf: " + classYear + " | Durum: " + status.getLabel();
    }
}

import java.time.LocalDate;
import java.util.UUID;

/**
 * Öğretim Üyesi Modeli (INSTRUCTORS tablosu)
 */
public class Instructor extends BasePerson {
    private String employeeNo;
    private AcademicTitle title;
    private String specialization;
    private LocalDate hireDate;
    private boolean active;
    private Department department;

    public Instructor() { super(); }

    public Instructor(UUID id, String nationalId, String firstName, String lastName, String email, String phone,
                      String employeeNo, AcademicTitle title, String specialization, LocalDate hireDate,
                      boolean active, Department department) {
        super(id, nationalId, firstName, lastName, email, phone);
        this.employeeNo = employeeNo;
        this.title = title;
        this.specialization = specialization;
        this.hireDate = hireDate;
        this.active = active;
        this.department = department;
    }

    public String getEmployeeNo() { return employeeNo; }
    public void setEmployeeNo(String employeeNo) { this.employeeNo = employeeNo; }

    public AcademicTitle getTitle() { return title; }
    public void setTitle(AcademicTitle title) { this.title = title; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public String getTitleAndName() {
        return (title != null ? title.getTitleText() + " " : "") + getFullName();
    }

    @Override
    public String toString() {
        return getTitleAndName() + " (" + employeeNo + ")";
    }
}

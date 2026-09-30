import java.util.UUID;

/**
 * Bölüm Modeli (DEPARTMENTS tablosu)
 */
public class Department {
    private UUID id;
    private String code;
    private String name;
    private Faculty faculty;
    private Instructor headInstructor;
    private String phone;
    private String email;
    private boolean active;

    public Department() {}

    public Department(UUID id, String code, String name, Faculty faculty,
                      Instructor headInstructor, String phone, String email, boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.faculty = faculty;
        this.headInstructor = headInstructor;
        this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public Instructor getHeadInstructor() { return headInstructor; }
    public void setHeadInstructor(Instructor headInstructor) { this.headInstructor = headInstructor; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return name + " [" + code + "]";
    }
}

import java.util.UUID;

/**
 * Ortak Kişi Sınıfı (OOP - Inheritance)
 * Instructor ve Student sınıflarının ortak alanlarını barındıran soyut sınıf.
 */
public abstract class BasePerson {
    private UUID id;
    private String nationalId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public BasePerson() {}

    public BasePerson(UUID id, String nationalId, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

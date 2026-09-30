import java.util.UUID;

/**
 * Öğretim Programı Modeli (PROGRAMS tablosu)
 */
public class Program {
    private UUID id;
    private String code;
    private String name;
    private Department department;
    private DegreeLevel degreeLevel;
    private int totalCredits;
    private int durationYears;
    private String language;
    private boolean active;

    public Program() {}

    public Program(UUID id, String code, String name, Department department,
                   DegreeLevel degreeLevel, int totalCredits, int durationYears,
                   String language, boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.department = department;
        this.degreeLevel = degreeLevel;
        this.totalCredits = totalCredits;
        this.durationYears = durationYears;
        this.language = language;
        this.active = active;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public DegreeLevel getDegreeLevel() { return degreeLevel; }
    public void setDegreeLevel(DegreeLevel degreeLevel) { this.degreeLevel = degreeLevel; }

    public int getTotalCredits() { return totalCredits; }
    public void setTotalCredits(int totalCredits) { this.totalCredits = totalCredits; }

    public int getDurationYears() { return durationYears; }
    public void setDurationYears(int durationYears) { this.durationYears = durationYears; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return name + " (" + degreeLevel.getLabel() + ")";
    }
}

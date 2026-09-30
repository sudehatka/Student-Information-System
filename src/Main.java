import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Öğrenci Bilgi Sistemi (SIS)
 * Ana Program & Simülasyon
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ÖĞRENCİ BİLGİ SİSTEMİ SİMÜLASYONU ===\n");

        // 1. Bir akademisyen oluşturup sisteme ekliyoruz
        Instructor dean = new Instructor(
                UUID.randomUUID(),
                "12345678901",
                "Ali",
                "Güneş",
                "ali.gunes@universite.edu.tr",
                "02120001122",
                "EMP-2024",
                AcademicTitle.PROF_DR,
                "Yazılım Mimarisi",
                LocalDate.of(2015, 9, 1),
                true,
                null
        );

        // 2. Fakülte ve Bölüm kurulumu
        Faculty engFaculty = new Faculty(
                UUID.randomUUID(),
                "ENG",
                "Mühendislik Fakültesi",
                dean,
                "02120000000",
                "eng@universite.edu.tr",
                true,
                LocalDateTime.now()
        );

        Department softEngDept = new Department(
                UUID.randomUUID(),
                "SWE",
                "Yazılım Mühendisliği",
                engFaculty,
                dean,
                "02120000001",
                "swe@universite.edu.tr",
                true
        );
        dean.setDepartment(softEngDept);

        // 3. Öğretim Programı tanımı
        Program sweBachelor = new Program(
                UUID.randomUUID(),
                "SWE-BS",
                "Yazılım Mühendisliği Lisans Programı",
                softEngDept,
                DegreeLevel.LISANS,
                240,
                4,
                "TR",
                true
        );

        // 4. Akademik Dönem bilgisi
        AcademicTerm term = new AcademicTerm(
                UUID.randomUUID(),
                "2026-GUZ",
                "2026-2027 Güz Dönemi",
                "2026-2027",
                Semester.GUZ,
                LocalDate.of(2026, 9, 21),
                LocalDate.of(2027, 1, 15),
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 20),
                LocalDate.of(2026, 10, 5),
                true
        );

        // 5. Dersler ve Ön Koşul kuralı
        Course prog1 = new Course(
                UUID.randomUUID(), "SWE101", "Programlamaya Giriş",
                softEngDept, 6, 3, 2, CourseType.ZORUNLU, "TR", "Temel Algoritmalar", true
        );

        Course oop = new Course(
                UUID.randomUUID(), "SWE201", "Nesne Yönelimli Tasarım",
                softEngDept, 6, 3, 2, CourseType.ZORUNLU, "TR", "OOP Mimarisi", true
        );

        CoursePrerequisite prerequisite = new CoursePrerequisite(
                UUID.randomUUID(), oop, prog1, PrerequisiteType.ZORUNLU, "DD"
        );

        // 6. Program Müfredatı (ProgramCourse - DB Şeması Eşleştirmesi)
        ProgramCourse pc1 = new ProgramCourse(
                UUID.randomUUID(), sweBachelor, prog1, 1, CourseType.ZORUNLU, true
        );
        ProgramCourse pc2 = new ProgramCourse(
                UUID.randomUUID(), sweBachelor, oop, 3, CourseType.ZORUNLU, true
        );

        // 7. Öğrenci Listesi oluşturma ve Sude Hatkaoğlu kaydı
        List<Student> studentList = new ArrayList<>();

        Student student = new Student(
                UUID.randomUUID(),
                "11223344556",
                "Sude",
                "Hatkaoglu",
                "sude.hatkaoglu@std.universite.edu.tr",
                "05559876543",
                "2026101001",
                LocalDate.of(2004, 6, 10),
                Gender.K, // DB Şemasındaki enum(E, K) formatı (veya Gender.FEMALE)
                "Kadıköy, İstanbul",
                sweBachelor,
                2026,
                1,
                StudentStatus.AKTIF,
                "https://uni.edu.tr/img/sude_hatkaoglu.jpg",
                LocalDateTime.now()
        );

        studentList.add(student);

        // 8. Konsol Çıktısı (Simülasyonun ekrana basılması)
        System.out.println("Aktif Dönem: " + term);
        System.out.println("Ön Koşul Kuralı: " + prerequisite);
        System.out.println("\nProgram Müfredatı (ProgramCourse):");
        System.out.println("   * " + pc1);
        System.out.println("   * " + pc2);

        System.out.println("\n--- Kayıt Edilen Öğrenci Listesi ---");
        for (Student s : studentList) {
            System.out.println(s);
            System.out.println("   * Cinsiyet              : " + s.getGender().getLabel());
            System.out.println("   * Bağlı Olduğu Fakülte  : " + s.getProgram().getDepartment().getFaculty().getName());
            System.out.println("   * Fakülte Dekanı        : " + s.getProgram().getDepartment().getFaculty().getDean().getTitleAndName());
            System.out.println("   * Kayıt Tarihi          : " + s.getCreatedAt());
        }
    }
}

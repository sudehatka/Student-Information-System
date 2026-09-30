# 🎓 Student Information System (SIS)
### Software Design and Architecture (SDA) / Object Oriented Design — Assignment 1

![Java Version](https://img.shields.io/badge/Java-21%2B%20%2F%2025-orange?logo=openjdk&logoColor=white)
![Design Pattern](https://img.shields.io/badge/Architecture-JavaBean%20%2F%20OOP-blue)
![OOP Principles](https://img.shields.io/badge/OOP-Inheritance%20%26%20Encapsulation-purple)
![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen)
![Deadline](https://img.shields.io/badge/Deadline-September%2028-red)

---

## 📝 About the Project

This project is designed to model a university's **Student Information System (SIS)**. It is developed in accordance with the provided relational database schema (ER Diagram) and follows Object-Oriented Programming (**OOP**) principles and **JavaBean** standards throughout the system.

> 💡 **Version Note:** This repository will be continuously updated throughout the semester with new assignments and features provided by our instructor, such as database integration and additional system functionality. The current version contains the project's basic infrastructure.

---

## 🌟 Features (Version 1.0)

The current version contains the core structure of the project:

- 🧱 **Full OOP Architecture & Inheritance:** Common personal identity fields (`id`, `nationalId`, `firstName`, `lastName`, `email`, `phone`) are abstracted into `BasePerson`, from which `Student` and `Instructor` inherit. All classes implement `private` fields, getter/setter methods, and constructors in accordance with JavaBean conventions.
- 🔗 **Foreign Key Simulation:** Java's built-in `java.util.UUID` class and direct object references (`Association / Aggregation`) are used to simulate foreign key relationships and provide realistic ID management between entities.
- 📜 **Separated Enum Structures:** Enums such as `Gender`, `CourseType`, `StudentStatus`, `AcademicTitle`, `DegreeLevel`, `Semester`, and `PrerequisiteType` are defined as separate classes to ensure data consistency and type safety.
- 👥 **Student Registration Simulation:** Students can be dynamically added to the system using an `ArrayList<Student>`, and registered students are displayed in a clean, readable format with their linked faculty, dean, and program details.

---

## 📂 Project Structure

```text
📦 student-information-system
 ┣ 📂 src
 ┃ ┣ 🏛️ Entity Classes
 ┃ ┃ ┣ 📄 BasePerson.java            # Abstract person base class (Inheritance)
 ┃ ┃ ┣ 📄 AcademicTerm.java           # ACADEMIC_TERMS table
 ┃ ┃ ┣ 📄 Course.java                 # COURSES table
 ┃ ┃ ┣ 📄 CoursePrerequisite.java     # COURSE_PREREQUISITES table
 ┃ ┃ ┣ 📄 Department.java             # DEPARTMENTS table
 ┃ ┃ ┣ 📄 Faculty.java                # FACULTIES table
 ┃ ┃ ┣ 📄 Instructor.java             # INSTRUCTORS table (extends BasePerson)
 ┃ ┃ ┣ 📄 Program.java                # PROGRAMS table
 ┃ ┃ ┣ 📄 ProgramCourse.java          # PROGRAM_COURSES table
 ┃ ┃ ┗ 📄 Student.java                # STUDENTS table (extends BasePerson)
 ┃ ┃
 ┃ ┣ 🏷️ Enums
 ┃ ┃ ┣ 📄 AcademicTitle.java          # öğr.gör., dr., dr.öğr.üyesi, doç.dr., prof.dr.
 ┃ ┃ ┣ 📄 CourseType.java             # zorunlu, seçmeli, ASD
 ┃ ┃ ┣ 📄 DegreeLevel.java            # önlisans, lisans, yüksek_lisans, doktora
 ┃ ┃ ┣ 📄 Gender.java                 # MALE, FEMALE
 ┃ ┃ ┣ 📄 PrerequisiteType.java       # ZORUNLU, ONERILEN
 ┃ ┃ ┣ 📄 Semester.java               # güz, bahar, yaz okulu
 ┃ ┃ ┗ 📄 StudentStatus.java          # aktif, mezun, kayıt donduruldu, ayrıldı
 ┃ ┃
 ┃ ┗ 🚀 Entry Point
 ┃   ┗ 📄 Main.java                   # Main simulation runner
 ┣ 📂 out                             # Compiled bytecode (.class files)
 ┣ 📄 .gitignore                      # Git ignore rules for build artifacts
 ┗ 📄 README.md                       # Project documentation
```

---

## 🎯 Database Schema to Java OOP Mapping

| Database Table | Java Model Class | Inheritance / FK Relationship | Enum Fields |
| :--- | :--- | :--- | :--- |
| *(Common Person)* | `BasePerson` *(abstract)* | Base class for person entities | - |
| `INSTRUCTORS` | `Instructor` | `extends BasePerson`<br>`department` ➔ `Department` | `AcademicTitle` |
| `FACULTIES` | `Faculty` | `dean` ➔ `Instructor` | - |
| `DEPARTMENTS` | `Department` | `faculty` ➔ `Faculty`<br>`headInstructor` ➔ `Instructor` | - |
| `PROGRAMS` | `Program` | `department` ➔ `Department` | `DegreeLevel` |
| `STUDENTS` | `Student` | `extends BasePerson`<br>`program` ➔ `Program` | `Gender`, `StudentStatus` |
| `COURSES` | `Course` | `department` ➔ `Department` | `CourseType` |
| `COURSE_PREREQUISITES` | `CoursePrerequisite` | `course` ➔ `Course`<br>`prerequisiteCourse` ➔ `Course` | `PrerequisiteType` |
| `ACADEMIC_TERMS` | `AcademicTerm` | - | `Semester` |
| `PROGRAM_COURSES` | `ProgramCourse` | `program` ➔ `Program`<br>`course` ➔ `Course` | `CourseType` |

---

## 🚀 Installation & Usage

If you want to compile and run the project directly from your terminal without using an IDE, follow these steps:

### 1. Compile the source code:

```bash
javac -encoding UTF-8 -d out src/*.java
```

### 2. Run the program:

```bash
java -cp out Main
```

---

## 📊 Sample Output

```text
=== ÖĞRENCİ BİLGİ SİSTEMİ SİMÜLASYONU ===

Aktif Dönem: 2026-2027 Güz Dönemi (2026-2027 / Güz)
Ön Koşul Kuralı: SWE201 dersi için ön koşul -> SWE101 (Min Not: DD)

Program Müfredatı (ProgramCourse):
   * SWE-BS | Dönem: 1 -> Programlamaya Giriş
   * SWE-BS | Dönem: 3 -> Nesne Yönelimli Tasarım

--- Kayıt Edilen Öğrenci Listesi ---
Öğrenci: Sude Hatkaoglu (2026101001) | Program: Yazılım Mühendisliği Lisans Programı | Sınıf: 1 | Durum: Aktif
   * Cinsiyet              : Kadın
   * Bağlı Olduğu Fakülte  : Mühendislik Fakültesi
   * Fakülte Dekanı        : Prof. Dr. Ali Güneş
   * Kayıt Tarihi          : 2026-10-01T01:14:13.575426100
```

---

## 📤 Submission & Git Workflow

1. Initialize Git repository and commit your files:
   ```bash
   git init
   git add .
   git commit -m "feat: complete Student Information System class design and simulation"
   ```
2. Link your GitHub remote repository and push:
   ```bash
   git branch -M main
   git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/<YOUR_REPOSITORY_NAME>.git
   git push -u origin main
   ```
3. Share the repository link with class representative **Enes** before **September 28**.

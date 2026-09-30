-- =============================================================================
-- Student Information System (SIS) - Database Schema DDL
-- Software Design and Architecture (SDA) - Assignment 1
-- Reference: Course ER Diagram
-- =============================================================================

-- Extension for UUID generation
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Custom ENUM Types
CREATE TYPE degree_level_enum AS ENUM ('önlisans', 'lisans', 'yüksek_lisans', 'doktora');
CREATE TYPE gender_enum AS ENUM ('E', 'K');
CREATE TYPE student_status_enum AS ENUM ('aktif', 'mezun', 'askı', 'ayrıldı');
CREATE TYPE instructor_title_enum AS ENUM ('öğr.gör.', 'dr.', 'dr.öğr.üyesi', 'doç.dr.', 'prof.dr.');
CREATE TYPE course_type_enum AS ENUM ('zorunlu', 'seçmeli', 'ASD');
CREATE TYPE prerequisite_type_enum AS ENUM ('zorunlu', 'önerilen');
CREATE TYPE semester_enum AS ENUM ('güz', 'bahar', 'yaz');

-- 1. FACULTIES (Fakülteler)
CREATE TABLE faculties (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    dean_id UUID, -- Foreign Key to instructors
    phone VARCHAR(20),
    email VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- 2. DEPARTMENTS (Bölümler)
CREATE TABLE departments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    faculty_id UUID NOT NULL REFERENCES faculties(id),
    head_instructor_id UUID, -- Foreign Key to instructors
    phone VARCHAR(20),
    email VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE
);

-- 3. INSTRUCTORS (Öğretim Üyeleri)
CREATE TABLE instructors (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    employee_no VARCHAR(20) NOT NULL UNIQUE,
    national_id VARCHAR(11) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    department_id UUID REFERENCES departments(id),
    title instructor_title_enum NOT NULL,
    specialization TEXT,
    hire_date DATE,
    is_active BOOLEAN DEFAULT TRUE
);

-- Add circular Foreign Key constraints between faculties, departments, and instructors
ALTER TABLE faculties 
    ADD CONSTRAINT fk_faculty_dean FOREIGN KEY (dean_id) REFERENCES instructors(id);

ALTER TABLE departments 
    ADD CONSTRAINT fk_department_head FOREIGN KEY (head_instructor_id) REFERENCES instructors(id);

-- 4. PROGRAMS (Öğretim Programları)
CREATE TABLE programs (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    department_id UUID NOT NULL REFERENCES departments(id),
    degree_level degree_level_enum NOT NULL,
    total_credits INT NOT NULL,
    duration_years INT NOT NULL,
    language VARCHAR(10) DEFAULT 'TR',
    is_active BOOLEAN DEFAULT TRUE
);

-- 5. STUDENTS (Öğrenci Kayıtları)
CREATE TABLE students (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    student_no VARCHAR(20) NOT NULL UNIQUE,
    national_id VARCHAR(11) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE,
    gender gender_enum NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(20),
    address TEXT,
    program_id UUID NOT NULL REFERENCES programs(id),
    enrollment_year INT NOT NULL,
    class_year INT CHECK (class_year BETWEEN 1 AND 4),
    status student_status_enum NOT NULL DEFAULT 'aktif',
    photo_url VARCHAR(255),
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- 6. COURSES (Ders Kataloğu)
CREATE TABLE courses (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(15) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,
    department_id UUID NOT NULL REFERENCES departments(id),
    credits INT NOT NULL,
    theory_hours INT DEFAULT 0,
    lab_hours INT DEFAULT 0,
    course_type course_type_enum NOT NULL,
    language VARCHAR(10) DEFAULT 'TR',
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE
);

-- 7. COURSE_PREREQUISITES (Ders Önkoşulları)
CREATE TABLE course_prerequisites (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    course_id UUID NOT NULL REFERENCES courses(id),
    prerequisite_course_id UUID NOT NULL REFERENCES courses(id),
    type prerequisite_type_enum NOT NULL DEFAULT 'zorunlu',
    min_grade VARCHAR(3) DEFAULT 'DD',
    CONSTRAINT unique_course_prerequisite UNIQUE (course_id, prerequisite_course_id)
);

-- 8. ACADEMIC_TERMS (Akademik Dönemler)
CREATE TABLE academic_terms (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    academic_year VARCHAR(9) NOT NULL,
    semester semester_enum NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    registration_start DATE,
    registration_end DATE,
    add_drop_end DATE,
    is_active BOOLEAN DEFAULT TRUE
);

-- 9. PROGRAM_COURSES (Program Müfredatı)
CREATE TABLE program_courses (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    program_id UUID NOT NULL REFERENCES programs(id),
    course_id UUID NOT NULL REFERENCES courses(id),
    semester_order INT NOT NULL CHECK (semester_order BETWEEN 1 AND 8),
    course_type course_type_enum NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    CONSTRAINT unique_program_course UNIQUE (program_id, course_id, semester_order)
);

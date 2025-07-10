package com.csr.repository;

import com.csr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can add custom query methods if needed
    Student findByStudentId(String studentId);
}

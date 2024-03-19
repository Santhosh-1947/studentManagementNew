package com.sampleManagement.StudentManagementSys.Repository;

import com.sampleManagement.StudentManagementSys.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByUserNameAndPassword(String username, String password);

}

package com.sampleManagement.StudentManagementSys.Controller;


import com.sampleManagement.StudentManagementSys.Entity.Student;
import com.sampleManagement.StudentManagementSys.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }


    @GetMapping("/{RollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer RollNo) {
        Student gettingStudent = studentService.getStudentByRollNo(RollNo);
        return ResponseEntity.ok(gettingStudent);
    }

    @DeleteMapping("/{RollNo}/delete")
    public ResponseEntity<String> deleteStudentDetails(@PathVariable Integer RollNo){
        studentService.deleteStudentDetails(RollNo);
        return ResponseEntity.ok("Student Details Deleted");
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> students=studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student loginpermit) {
        Student permittedStudent = studentService.login(loginpermit.getUserName(), loginpermit.getPassword());

        if (permittedStudent != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @PutMapping("/{rollNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer rollNo, @RequestBody Student updatestudent)
    {
        Student updatedName= studentService.updateStudent(rollNo, updatestudent);
        return ResponseEntity.ok(updatedName);

    }


}


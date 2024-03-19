package com.sampleManagement.StudentManagementSys.Entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;
    private String studentName;
    private String email;
    private String userName;
    private String password;

}

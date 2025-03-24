package org.example.service;

import org.example.database.DatabaseManager;
import org.example.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    public static List<Student> filterStudentsByMonthJava(int month) {
        return DatabaseManager.getAllStudents()
                .stream()
                .filter(student -> student.getBirthDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }
}

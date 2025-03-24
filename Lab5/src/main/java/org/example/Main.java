package org.example;

import org.example.database.DatabaseManager;
import org.example.model.Student;
import org.example.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер місяця для пошуку студентів: ");
        int month = scanner.nextInt();

        System.out.println("\nФільтрація на рівні SQL:");
        List<Student> studentsFromDb = DatabaseManager.getStudentsByMonth(month);
        studentsFromDb.forEach(System.out::println);

        System.out.println("\nФільтрація на рівні Java:");
        List<Student> studentsFromJava = StudentService.filterStudentsByMonthJava(month);
        studentsFromJava.forEach(System.out::println);
    }
}

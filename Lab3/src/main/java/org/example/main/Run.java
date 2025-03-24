package org.example.main;

import org.example.model.*;
import org.example.controller.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        Human rector = new Human("Іван", "Петров", "Олексійович", Sex.MALE) {};
        University university = UniversityCreator.createUniversity("Національний університет", rector);

        Human dean = new Human("Марія", "Іванова", "Сергіївна", Sex.FEMALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Факультет інформатики", dean);
        university.addFaculty(faculty);

        System.out.println("Університет створено!");
    }
}

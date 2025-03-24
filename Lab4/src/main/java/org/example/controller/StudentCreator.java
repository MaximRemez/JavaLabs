package org.example.controller;

import org.example.model.*;

class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}

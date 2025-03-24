package org.example.model;

import java.util.Objects;

public class Student extends Human {
    public Student(String firstName, String lastName, String middleName, Sex gender) {
        super(firstName, lastName, middleName, gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getLastName(), student.getLastName()) &&
                Objects.equals(getMiddleName(), student.getMiddleName()) &&
                getGender() == student.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getGender());
    }
}

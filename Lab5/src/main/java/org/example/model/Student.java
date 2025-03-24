package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String recordBookNumber;

    public Student(int id, String firstName, String lastName, String middleName, LocalDate birthDate, String recordBookNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, %s %s %s, Дата народження: %s, № Залікової книжки: %s",
                id, lastName, firstName, middleName, birthDate, recordBookNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) && Objects.equals(middleName, student.middleName) &&
                birthDate.equals(student.birthDate) && recordBookNumber.equals(student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, birthDate, recordBookNumber);
    }
}

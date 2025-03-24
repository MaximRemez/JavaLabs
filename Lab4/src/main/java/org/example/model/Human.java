package org.example.model;

import java.util.Objects;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Sex gender;

    public Human(String firstName, String lastName, String middleName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    // Додаємо геттери
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                Objects.equals(middleName, human.middleName) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, gender);
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + gender + ")";
    }
}

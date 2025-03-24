package tests;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.example.utils.JsonManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonManagerTest {

    private static final String FILE_PATH = "university.json";

    @Test
    public void testJsonSerializationAndDeserialization() {
        // Створюємо тестовий університет
        University oldUniversity = createTestUniversity();

        // Записуємо в JSON
        JsonManager.saveToJson(oldUniversity, FILE_PATH);

        // Читаємо з JSON
        University newUniversity = JsonManager.loadFromJson(FILE_PATH);

        // Перевіряємо, що університети рівні
        assertEquals(oldUniversity, newUniversity);
    }

    private University createTestUniversity() {
        Human rector = new Human("Іван", "Петров", "Олексійович", Sex.MALE) {};
        University university = new University("Тестовий університет", rector);

        for (int i = 1; i <= 2; i++) {
            Human dean = new Human("Декан" + i, "Прізвище", "Ім'я", Sex.FEMALE) {};
            Faculty faculty = new Faculty("Факультет " + i, dean);

            for (int j = 1; j <= 2; j++) {
                Human headOfDepartment = new Human("ЗавКаф" + j, "Прізвище", "Ім'я", Sex.MALE) {};
                Department department = new Department("Кафедра " + j, headOfDepartment);

                for (int k = 1; k <= 2; k++) {
                    Human headOfGroup = new Human("Староста" + k, "Прізвище", "Ім'я", Sex.FEMALE) {};
                    Group group = new Group("Група " + k, headOfGroup);

                    for (int m = 1; m <= 2; m++) {
                        Student student = new Student("Студент" + m, "Прізвище", "Ім'я", Sex.MALE);
                        group.addStudent(student);
                    }

                    department.addGroup(group);
                }

                faculty.addDepartment(department);
            }

            university.addFaculty(faculty);
        }

        return university;
    }
}

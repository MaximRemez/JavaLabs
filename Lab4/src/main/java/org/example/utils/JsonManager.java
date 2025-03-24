package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToJson(University university, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
            System.out.println("✅ Університет успішно збережено у файл: " + filePath);
        } catch (IOException e) {
            System.err.println("❌ Помилка при записі у файл: " + filePath);
            e.printStackTrace();
        }
    }

    public static University loadFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            University university = gson.fromJson(reader, University.class);
            System.out.println("✅ Університет успішно завантажено з файлу: " + filePath);
            return university;
        } catch (IOException e) {
            System.err.println("❌ Помилка при читанні файлу: " + filePath);
            e.printStackTrace();
            return null;
        }
    }
}

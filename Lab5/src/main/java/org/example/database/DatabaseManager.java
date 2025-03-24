package org.example.database;

import org.example.model.Student;
import org.example.utils.Config;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    static {
        try (Connection conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute("RUNSCRIPT FROM 'src/main/resources/database.sql'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE MONTH(birth_date) = ?";

        try (Connection conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, month);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("middle_name"),
                            rs.getDate("birth_date").toLocalDate(),
                            rs.getString("record_book_number")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}

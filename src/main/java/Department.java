import dbutils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Department implements Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private ResultSet allStudents;

    public ResultSet getStudents() {
        return allStudents;
    }

    @Override
    public void notifySubscribers() {
        allStudents = getAllStudents();
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void addStudent(Student student) {
        try (Connection connection = new ConnectionFactory().createConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students (student_name, average_score) VALUES (?, ?)");
            statement.setString(1, student.getName());
            statement.setDouble(2, student.getAverageScore());
            statement.execute();
            allStudents = getAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentScore(Student student, Double score) {
        try (Connection connection = new ConnectionFactory().createConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM students WHERE student_name = ? AND average_score = ?");
            statement.setString(1, student.getName());
            statement.setDouble(2, student.getAverageScore());
            ResultSet studentToUpdate = statement.executeQuery();

            if (studentToUpdate.next()) {
                statement = connection.prepareStatement("UPDATE students SET average_score = ? WHERE student_id = ?");
                statement.setDouble(1, score);
                statement.setInt(2, studentToUpdate.getInt(1));
                statement.execute();
                allStudents = getAllStudents();
            } else {
                System.out.println("There is no such student in DB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Student student) {
        try (Connection connection = new ConnectionFactory().createConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM students WHERE student_name = ? AND average_score = ?");
            statement.setString(1, student.getName());
            statement.setDouble(2, student.getAverageScore());
            ResultSet studentToDelete = statement.executeQuery();

            if (studentToDelete.next()) {
                statement = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");
                statement.setInt(1, studentToDelete.getInt(1));
                statement.executeUpdate();
                allStudents = getAllStudents();
            } else {
                System.out.println("There is no such student in DB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getAllStudents() {
        ResultSet rs = null;
        try (Connection connection = new ConnectionFactory().createConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
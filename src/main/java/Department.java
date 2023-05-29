// add student
// update student
// delete student


import dbutils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Department implements Publisher {

    private final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void notifySubscribers() {
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
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

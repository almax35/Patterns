import java.sql.ResultSet;
import java.sql.SQLException;

public class RectalImpl implements Rectal {
    private final ResultSet studentsData;
    private final Department department;

    public RectalImpl(ResultSet studentsData, Department department) {
        this.studentsData = studentsData;
        this.department = department;
    }

    public void checkStudents() {
        try {
            while (studentsData.next()) {
                String studentName = studentsData.getString(2);
                double studentScore = studentsData.getDouble(3);
                if (studentScore < 2.5) {
                    department.deleteStudent(new Student(studentName, studentScore));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

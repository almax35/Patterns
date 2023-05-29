import java.sql.ResultSet;

public class Rectal implements Subscriber {
    private ResultSet studentsData;

    @Override
    public void update(Object state) {
        // ResultSet rs = state.selectAllStudents();
    }

    public void checkStudents() {
        // проверяет средний балл и в случае, если балл ниже 2.5, то забирает на срочную службу,
        // но делает это через прокси
    }
}

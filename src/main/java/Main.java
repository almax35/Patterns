public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        RectalProxy rectalProxy = new RectalProxy();
        department.addSubscriber(rectalProxy);
        department.addStudent(new Student("Ivanov", 3.5));
        department.addStudent(new Student("Student N", 2.0));
        department.notifySubscribers();
        rectalProxy.checkStudents();
    }
}

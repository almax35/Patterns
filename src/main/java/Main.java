public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        RectalProxy rectalProxy = new RectalProxy();
        department.addSubscriber(rectalProxy);
        department.notifySubscribers();
        rectalProxy.checkStudents();
    }
}

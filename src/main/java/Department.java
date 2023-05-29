// add student
// update student
// delete student


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
}

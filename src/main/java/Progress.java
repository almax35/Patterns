import java.util.ArrayList;
import java.util.List;

public class Progress implements Publisher, Subscriber {
    private List<Subscriber> subscribers = new ArrayList<>();

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

    // update db to new data from department
    @Override
    public void update(Object state) {
        // notify subscribers
    }

    public void selectAllStudents() {

    }
}

public interface Publisher {
    void notifySubscribers();

    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);
}

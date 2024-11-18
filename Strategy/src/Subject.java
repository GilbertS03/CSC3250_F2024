public interface Subject {
    void subscribe(Observer obs);
    void unsubscribe(Observer obs);
    void notifyObservers(String s);
}

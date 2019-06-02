package SimpleDesign.Observer;

public class ConcreteObserver extends Observer{
    private String ObserverState ;
    private String name;
    @Override
    public void update(Subject subject) {
        this.ObserverState = subject.subjectState;
        System.out.println(ObserverState);
    }

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.Attach(new ConcreteObserver("jacky"));
        subject.Attach(new ConcreteObserver("lucy"));
        subject.subjectState = "how are you";
        subject.Notify();
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Przykład wzorca Observer w Javie.
 * Wszystkie klasy są umieszczone w jednym pliku dla uproszczenia.
 */
public class ObserverPatternDemo {

    /** Interfejs Obserwatora. */
    interface Observer {
        void update(String message);
    }

    /** Interfejs Podmiotu (Subject). */
    interface Subject {
        void attach(Observer o);
        void detach(Observer o);
        void notifyObservers();
    }

    /** Konkretna implementacja Subject. */
    static class ConcreteSubject implements Subject {
        private final List<Observer> observers = new ArrayList<>();
        private String state;

        @Override
        public void attach(Observer o) {
            observers.add(o);
        }

        @Override
        public void detach(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(state);
            }
        }

        /**
         * Ustawia nowy stan i powiadamia obserwatorów.
         */
        public void setState(String message) {
            this.state = message;
            notifyObservers();
        }
    }

    /** Konkretna implementacja Observer. */
    static class ConcreteObserver implements Observer {
        private final String name;

        ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " otrzymał powiadomienie: " + message);
        }
    }

    /** Metoda main demonstrująca działanie wzorca. */
    public static void main(String[] args) {
        ConcreteSubject newsAgency = new ConcreteSubject();

        Observer alice = new ConcreteObserver("Alicja");
        Observer bob = new ConcreteObserver("Bob");

        newsAgency.attach(alice);
        newsAgency.attach(bob);

        newsAgency.setState("Nowy artykuł jest już dostępny!");
        newsAgency.setState("Druga wiadomość!");

        // Oczekiwany wynik:
        // Alicja otrzymał powiadomienie: Nowy artykuł jest już dostępny!
        // Bob otrzymał powiadomienie: Nowy artykuł jest już dostępny!
        // Alicja otrzymał powiadomienie: Druga wiadomość!
        // Bob otrzymał powiadomienie: Druga wiadomość!
    }
}

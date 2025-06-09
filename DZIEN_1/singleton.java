
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //prywatna ststyczna instancja
    private static volatile Main instance;
    private Main() {
        System.out.println("Konstruktor Singleton");
    }
    public static Main getInstance() {
        if (instance == null) {
            synchronized (Main.class) {
                if (instance == null) {
                    instance = new Main();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Działanie Singletona");
    }

    public static void main(String[] args) {

       Main s1 =  Main.getInstance();
       s1.doSomething();

        Main s2 =  Main.getInstance();
        s2.doSomething();

        System.out.println(s1==s2);
    }
}

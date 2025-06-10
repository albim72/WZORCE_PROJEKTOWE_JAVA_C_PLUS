//Factory
public class Espresso implements Drink {
    @Override
    public String getDescription() {
        return "Kawa Espresso";
    }

    @Override
    public double cost() {
        return 11.5;
    }

    @Override
    public void brew() {
        System.out.println("Parzę espresso... zaczekaj");
    }
}

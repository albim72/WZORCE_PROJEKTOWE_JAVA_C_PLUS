//Factory
public class Americano implements Drink {
    @Override
    public String getDescription() {
        return "Kawa Americano";
    }

    @Override
    public double cost() {
        return 12.66;
    }

    @Override
    public void brew() {
        System.out.println("Parzę kawę Americano..... zaczekaj");
    }
}

//Builder
public class CustomLatte implements Drink {
    private final boolean foam,soyMilk,doubleShot;

    public CustomLatte(boolean foam, boolean soyMilk, boolean doubleShot) {
        this.foam = foam;
        this.soyMilk = soyMilk;
        this.doubleShot = doubleShot;
    }

    @Override
    public String getDescription() {
        return "Latte" +
                (doubleShot ? "(double shot)":"") +
                (soyMilk ? "z mlekiem sojowym":"") +
                (foam ? " z pianką ":"");
    }

    @Override
    public double cost() {
        double c = 10.0;
        if (doubleShot) c+= 2.5;
        if (soyMilk) c+= 3.8;
        if (foam) c+= 1.5;
        return c;
    }

    @Override
    public void brew() {
        System.out.println("parzę latte warstwowo.... ");
    }
}

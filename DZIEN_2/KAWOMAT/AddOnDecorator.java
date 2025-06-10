//Decorator
public abstract class AddOnDecorator implements Drink {
    protected final Drink base;

    public AddOnDecorator(Drink base) {
        this.base = base;
    }

    @Override
    public void brew() {
        base.brew();
    }
}

class VanillaSyrup extends AddOnDecorator {
    public VanillaSyrup(Drink base) {super(base);}

    @Override
    public String getDescription() {
        return base.getDescription() + " + syrop waniliowy!";
    }

    @Override
    public double cost() {
        return base.cost() + 1.8;
    }
}
class ExtraShot extends AddOnDecorator {
    public ExtraShot(Drink base) {super(base);}

    @Override
    public String getDescription() {
        return base.getDescription() + " + ekstra shot!";
    }

    @Override
    public double cost() {
        return base.cost() + 3.1;
    }
}

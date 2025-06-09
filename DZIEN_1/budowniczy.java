class Pizza{
    protected String ciasto;
    protected String sos;
    protected String dodatki;

    public void showPizza(){
        System.out.println("Pizza: " + ciasto + ", z sosem " + sos + " i dodatkami: " + dodatki);
    }
}

class DeluxePizza extends Pizza{
    private String extraSer;

    public DeluxePizza(String ciasto, String sos, String dodatki,String extraSer) {
        this.ciasto = ciasto;
        this.sos = sos;
        this.dodatki = dodatki;
        this.extraSer = extraSer;
    }

    @Override
    public void showPizza() {
        super.showPizza();
        System.out.println(" + ExtraSer: " + extraSer);
    }
}

class PizzaBuilder{
    protected String ciasto;
    protected String sos;
    protected String dodatki;

    public PizzaBuilder setCiasto(String ciasto) {
        this.ciasto = ciasto;
        return this;
    }

    public PizzaBuilder setSos(String sos) {
        this.sos = sos;
        return this;
    }

    public PizzaBuilder setDodatki(String dodatki) {
        this.dodatki = dodatki;
        return this;
    }

    public Pizza build(){
        if (ciasto == null || sos == null) {
            throw new IllegalStateException("Ciasto i sos wymagane");
        }
        Pizza p = new  Pizza();
        p.ciasto = ciasto;
        p.sos = sos;
        p.dodatki = dodatki;
        return p;
    }
}

class DeluxePizzaBuilder extends PizzaBuilder{
    private String extraSer;
    public DeluxePizzaBuilder setExtraSer(String extraSer) {
        this.extraSer = extraSer;
        return this;
    }

    @Override
    public DeluxePizza build() {
        if (ciasto == null || sos == null || extraSer == null) {
            throw new IllegalStateException("Ciasto i sos oraz extra ser wymagane");
        }
        return new DeluxePizza(ciasto,sos,dodatki,extraSer);
    }
}


public class Main {
    public static void main(String[] args) {

        try{
            DeluxePizza pizza= new DeluxePizzaBuilder()
                    .setCiasto("grube")
                    .setSos("czosnkowy")
                    .setDodatki("cebula, tuńczyk")
                    .setExtraSer("parmezan")
                    .build();
            pizza.showPizza();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

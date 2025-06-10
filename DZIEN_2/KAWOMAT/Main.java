//uruchomienie wszystkiego
public class Main {
    public static void main(String[] args) {
        //Factory
        Drink myLatte = new LatteBuilder()
                .usingSoyMilk()
                .withFoam()
                .build();

        myLatte = new ExtraShot(new VanillaSyrup(myLatte));
        myLatte.brew();
        System.out.println(myLatte.getDescription() + " kosztuje: " + myLatte.cost() + "zł\n");

        //Facade - kontrolujący hardware
        HardwareFacade hw = new HardwareFacade();
        hw.brewEspressoProcess();
    }
}

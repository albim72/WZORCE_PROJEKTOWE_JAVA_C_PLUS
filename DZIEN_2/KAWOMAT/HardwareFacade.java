//Facade
//ukryte klasy sprzętowe
class Boiler {void heatWater() {
    System.out.println(" [Boiler] Grzeję wodę...");
}}

class Pump {void pumpWater() {
    System.out.println(" [Pump] Pompuję wodę...");
}}

class Grinder {void grindBeans() {
    System.out.println(" [Grinder] Mielę ziarna...");
}}

public class HardwareFacade {
    private final Boiler boiler = new Boiler();
    private final  Pump pump = new Pump();
    private final  Grinder grinder = new Grinder();
    
    public void brewEspressoProcess() {
        grinder.grindBeans();
        boiler.heatWater();
        pump.pumpWater();
        System.out.println(" [Facade] Espresso gotowe!");
    }
}

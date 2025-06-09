public class Main {
    public static void main(String[] args) {
        try {
            DeluxePizza pizza = new DeluxePizza.Builder()
                    .setCiasto("grube")
                    .setSos("czosnkowy")
                    .setDodatki("salami, cebula")
                    .setExtraSer("parmezan")
                    .build();

            pizza.showPizza();
        } catch (IllegalStateException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

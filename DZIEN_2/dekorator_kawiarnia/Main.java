
public class Main {
    public static void main(String[] args) {
        Napoj napoj = new Espresso();
        napoj = new Mleko(napoj);
        napoj = new Czekolada(napoj);

        System.out.println("Zamówienie: " + napoj.pobierzOpis());
        System.out.println("Cena: " + String.format("%.2f",napoj.koszt()) + "zł");
    }
}

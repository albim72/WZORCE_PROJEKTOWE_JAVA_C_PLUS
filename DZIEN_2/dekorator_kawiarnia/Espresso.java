public class Espresso implements Napoj{
    @Override
    public String pobierzOpis() {
        return "Kawa Espresso";
    }

    @Override
    public double koszt() {
        return 12.99;
    }
}

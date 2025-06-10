public class Mleko extends NapojDekorator{
    public Mleko(Napoj napoj) {
        super(napoj);
    }

    @Override
    public String pobierzOpis() {
        return napoj.pobierzOpis() + ", mleko";
    }

    @Override
    public double koszt() {
        return napoj.koszt() + 2.2;
    }
}

public class Czekolada extends NapojDekorator{
    public Czekolada(Napoj napoj) {
        super(napoj);
    }

    @Override
    public String pobierzOpis() {
        return napoj.pobierzOpis() + ", czekolada" ;
    }

    @Override
    public double koszt() {
        return napoj.koszt() + 2.8;
    }
}

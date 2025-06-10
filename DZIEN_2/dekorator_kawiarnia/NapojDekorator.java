public abstract class NapojDekorator implements Napoj {
    protected Napoj napoj;
    public NapojDekorator(Napoj napoj) {
        this.napoj = napoj;
    }
    
    public abstract String pobierzOpis();
}

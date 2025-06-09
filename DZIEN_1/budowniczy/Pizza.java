public class Pizza {
    protected String ciasto;
    protected String sos;
    protected String dodatki;

    protected Pizza(Builder<?> builder) {
        this.ciasto = builder.ciasto;
        this.sos = builder.sos;
        this.dodatki = builder.dodatki;
    }

    public void showPizza() {
        System.out.println("Pizza z " + ciasto + ", sosem " + sos + ", dodatkami: " + dodatki);
    }

    // Generyczny Builder typu T – do dziedziczenia
    public static class Builder<T extends Builder<T>> {
        protected String ciasto;
        protected String sos;
        protected String dodatki;

        public T setCiasto(String ciasto) {
            this.ciasto = ciasto;
            return self();
        }

        public T setSos(String sos) {
            this.sos = sos;
            return self();
        }

        public T setDodatki(String dodatki) {
            this.dodatki = dodatki;
            return self();
        }

        public Pizza build() {
            if (ciasto == null || sos == null) {
                throw new IllegalStateException("Pizza musi mieć ciasto i sos.");
            }
            return new Pizza(this);
        }

        protected T self() {
            return (T) this;
        }
    }
}

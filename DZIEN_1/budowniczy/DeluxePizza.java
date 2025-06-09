public class DeluxePizza extends Pizza {
    private final String extraSer;

    private DeluxePizza(Builder builder) {
        super(builder);
        this.extraSer = builder.extraSer;
    }

    @Override
    public void showPizza() {
        super.showPizza();
        System.out.println(" + extra ser: " + extraSer);
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private String extraSer;

        public Builder setExtraSer(String extraSer) {
            this.extraSer = extraSer;
            return this;
        }

        @Override
        public DeluxePizza build() {
            if (ciasto == null || sos == null || extraSer == null) {
                throw new IllegalStateException("DeluxePizza wymaga ciasta, sosu i extra sera.");
            }
            return new DeluxePizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}

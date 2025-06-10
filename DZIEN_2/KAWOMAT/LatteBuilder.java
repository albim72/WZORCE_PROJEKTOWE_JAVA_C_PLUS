//Builder
public class LatteBuilder {
    private boolean foam,soyMilk,doubleShot;
    public LatteBuilder withFoam() {
        foam = true;
        return this;
    }
    public LatteBuilder usingSoyMilk() {
        soyMilk = true;
        return this;
    }
    public LatteBuilder doubleShot() {
        doubleShot = true;
        return this;
    }
    public CustomLatte build() {
        return new CustomLatte(foam,soyMilk,doubleShot);
    }
}

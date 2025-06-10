//klasa z metodą wytwórczą
public class DrinkFactory {
    public Drink createDrink(String type){
        return switch (type.toLowerCase()){
            case "espresso" -> new Espresso();
            case "americano" -> new Americano();
            default -> throw new IllegalArgumentException("Invalid drink type" +  type);
        };
    }
}

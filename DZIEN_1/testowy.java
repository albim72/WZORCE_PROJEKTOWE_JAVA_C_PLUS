import java.util.Calendar;

class Main{
    public static void main(String[] args) {
        String name = "Marcin";
        int age = 53;

        System.out.println("imię: " + name + " wiek:" + age);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("currentYear: " + currentYear);

        int birthYear = currentYear - age;
        System.out.println("birthYear: " + birthYear);
    }
}

package Common;

import com.github.javafaker.Faker;

public class GenerateTestData {

    public static String generateValidPassword() {
        String pwd;
        do {
            pwd = faker.internet().password(8, 10, true, true, true);
        } while (!pwd.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"));
        return pwd;
    }

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName().replaceAll("[^a-zA-Z]", "");
    public static String lastName = faker.name().lastName().replaceAll("[^A-Za-z]", "");
    public static int randomNumber = faker.number().numberBetween(1000, 9999);
    public static String email = firstName + "." + lastName + randomNumber + "@gmail.com";
    public static String password = generateValidPassword();
    public static String confirmPassword = password;

}

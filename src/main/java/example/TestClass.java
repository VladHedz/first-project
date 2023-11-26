package example;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestClass {

    public static void main(String[] args) {
        Faker fakerEN = Faker.instance(new Locale("en-US"));
        Faker fakerUA = Faker.instance(new Locale("uk-UA"));
        System.out.println(fakerEN.name().firstName());
        System.out.println(fakerUA.name().firstName());
        System.out.println(Faker.instance().bothify("????????@gmail.com"));
    }
}

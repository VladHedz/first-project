package example;

import com.github.javafaker.Faker;

public class TestClass {

    public static void main(String[] args) {
        System.out.println(Faker.instance().name().name());
    }
}

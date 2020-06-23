package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {

    @Test
    public void faker_test(){
        Faker faker = new Faker();

        String name = faker.name().fullName();
        System.out.println("name = " + name);

        String firstName = faker.name().firstName();
        System.out.println("first name = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("last name = " + lastName);

        String streetAddress = faker.address().streetAddress();
        System.out.println("Street Address = " + streetAddress);

        String gameOfThrones = faker.gameOfThrones().quote();
        System.out.println("gameOfThrones = " + gameOfThrones);

        String chuckNorris = faker.chuckNorris().fact();
        System.out.println("chuckNorris = " + chuckNorris);
    }

}

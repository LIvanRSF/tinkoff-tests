package cloud.autotests.helpers;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String fullName = faker.name().fullName() + " " + faker.name().lastName();
}

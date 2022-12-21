package Day06_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    @Test
    public void fakerExample(){
        Faker faker= new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.address().fullAddress());
    }

}

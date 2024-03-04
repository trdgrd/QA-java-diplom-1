import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private static Random random = new Random();
    private Bun bun;
    private String name;
    private Float price;

    public BunTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBunValue() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(6), random.nextFloat()},
                {RandomStringUtils.randomAlphabetic(6), random.nextFloat()}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getBunNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        assertEquals(price, bun.getPrice());
    }

}
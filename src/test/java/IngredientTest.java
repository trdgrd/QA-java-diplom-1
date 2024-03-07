import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private static Random random = new Random();
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private Float price;

    public IngredientTest(IngredientType type, String name, Float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredientValue() {
        return new Object[][]{
                {IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(6), random.nextFloat()},
                {IngredientType.FILLING, RandomStringUtils.randomAlphabetic(6), random.nextFloat()}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        assertEquals(price, ingredient.getPrice());
    }

}
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        String expected = "SAUCE";
        assertEquals(expected, IngredientType.SAUCE.name());
    }

    @Test
    public void ingredientTypeFillingTest() {
        String expected = "FILLING";
        assertEquals(expected, IngredientType.FILLING.name());
    }
}

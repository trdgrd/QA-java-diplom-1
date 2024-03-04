import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private static Random random = new Random();
    private Burger burger;
    private String randomName = RandomStringUtils.randomAlphabetic(6);
    private Float randomPrice = random.nextFloat();

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Mockito.when(bun.getName()).thenReturn(randomName);
        Mockito.when(bun.getPrice()).thenReturn(randomPrice);
        burger.setBuns(bun);
        assertEquals(randomName, burger.bun.getName());
        assertEquals(randomPrice, burger.bun.getPrice());
    }

    @Test
    public void addIngredientTest() {
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(randomName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(randomPrice);
        burger.addIngredient(firstIngredient);
        assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
        assertEquals(randomName, burger.ingredients.get(0).getName());
        assertEquals(randomPrice, burger.ingredients.get(0).getPrice());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(firstIngredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(firstIngredient));
        assertEquals(0, burger.ingredients.indexOf(secondIngredient));
    }

}
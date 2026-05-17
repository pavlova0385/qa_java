package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    @Test
    public void getFoodReturnsFoodFromPredator() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", predator, 3);

        assertEquals(expectedFood, lion.getFood());
        Mockito.verify(predator).eatMeat();
    }

    @Test
    public void getKittensReturnsInjectedValue() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion("Самка", predator, 2);

        assertEquals(2, lion.getKittens());
    }

    @Test
    public void constructorThrowsExceptionForIncorrectSex() {
        Predator predator = Mockito.mock(Predator.class);

        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", predator, 1)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }
}
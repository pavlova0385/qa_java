package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);

        assertEquals(expectedFood, lion.getFood());
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самка", feline);

        assertEquals(2, lion.getKittens());
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void constructorThrowsExceptionForIncorrectSex() {
        Feline feline = Mockito.mock(Feline.class);

        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", feline)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage()
        );
    }
}
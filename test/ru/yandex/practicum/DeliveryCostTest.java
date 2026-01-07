package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.*;

public class DeliveryCostTest {
    
    @Test
    public void testStandardParcelCost() {
        StandardParcel parcel = new StandardParcel("Книга", 2, "Москва", 1);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(4, cost);
    }
    
    @Test
    public void testStandardParcelCostHeavy() {
        StandardParcel parcel = new StandardParcel("Мебель", 50, "Санкт-Петербург", 5);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(100, cost);
    }
    
    @Test
    public void testStandardParcelCostZeroWeight() {
        StandardParcel parcel = new StandardParcel("Документы", 0, "Казань", 10);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(0, cost);
    }
    
    @Test
    public void testFragileParcelCost() {
        FragileParcel parcel = new FragileParcel("Ваза", 3, "Москва", 1);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(12, cost);
    }
    
    @Test
    public void testFragileParcelCostHeavy() {
        FragileParcel parcel = new FragileParcel("Зеркало", 20, "Новосибирск", 15);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(80, cost);
    }
    
    @Test
    public void testPerishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1, 3);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(3, cost);
    }
    
    @Test
    public void testPerishableParcelCostHeavy() {
        PerishableParcel parcel = new PerishableParcel("Овощи", 30, "Екатеринбург", 8, 5);
        int cost = parcel.calculateDeliveryCost();
        Assertions.assertEquals(90, cost);
    }
}

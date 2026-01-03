package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.*;

import java.util.List;

public class DeliveryCostTest {
    
    // Тесты для вычисления стоимости доставки
    
    @Test
    public void testStandardParcelCost() {
        StandardParcel parcel = new StandardParcel("Книга", 2, "Москва", 1);
        int cost = parcel.calculateDeliveryCost();
        // 100 + 2 * 10 = 120
        Assertions.assertEquals(120, cost);
    }
    
    @Test
    public void testStandardParcelCostHeavy() {
        StandardParcel parcel = new StandardParcel("Мебель", 50, "Санкт-Петербург", 5);
        int cost = parcel.calculateDeliveryCost();
        // 100 + 50 * 10 = 600
        Assertions.assertEquals(600, cost);
    }
    
    @Test
    public void testStandardParcelCostZeroWeight() {
        StandardParcel parcel = new StandardParcel("Документы", 0, "Казань", 10);
        int cost = parcel.calculateDeliveryCost();
        // 100 + 0 * 10 = 100
        Assertions.assertEquals(100, cost);
    }
    
    @Test
    public void testFragileParcelCost() {
        FragileParcel parcel = new FragileParcel("Ваза", 3, "Москва", 1);
        int cost = parcel.calculateDeliveryCost();
        // 200 + 3 * 15 = 245
        Assertions.assertEquals(245, cost);
    }
    
    @Test
    public void testFragileParcelCostHeavy() {
        FragileParcel parcel = new FragileParcel("Зеркало", 20, "Новосибирск", 15);
        int cost = parcel.calculateDeliveryCost();
        // 200 + 20 * 15 = 500
        Assertions.assertEquals(500, cost);
    }
    
    @Test
    public void testPerishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1);
        int cost = parcel.calculateDeliveryCost();
        // 150 + 1 * 12 = 162
        Assertions.assertEquals(162, cost);
    }
    
    @Test
    public void testPerishableParcelCostHeavy() {
        PerishableParcel parcel = new PerishableParcel("Овощи", 30, "Екатеринбург", 8);
        int cost = parcel.calculateDeliveryCost();
        // 150 + 30 * 12 = 510
        Assertions.assertEquals(510, cost);
    }
    
    // Тесты для метода isExpired
    
    @Test
    public void testPerishableParcelNotExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1);
        // Текущий день = 3, срок годности = 3 дня, значит еще не испортилось
        Assertions.assertFalse(parcel.isExpired(3));
    }
    
    @Test
    public void testPerishableParcelExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1);
        // Текущий день = 5, срок годности = 3 дня, значит испортилось
        Assertions.assertTrue(parcel.isExpired(5));
    }
    
    @Test
    public void testPerishableParcelExpiredBoundary() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1);
        // Текущий день = 4, срок годности = 3 дня, граничный случай - испортилось
        Assertions.assertTrue(parcel.isExpired(4));
    }
    
    @Test
    public void testPerishableParcelNotExpiredSameDay() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1);
        // Текущий день = 1, срок годности = 3 дня, не испортилось
        Assertions.assertFalse(parcel.isExpired(1));
    }
    
    // Тесты для ParcelBox
    
    @Test
    public void testParcelBoxAddParcel() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(100);
        StandardParcel parcel1 = new StandardParcel("Книга", 30, "Москва", 1);
        StandardParcel parcel2 = new StandardParcel("Одежда", 50, "Санкт-Петербург", 2);
        
        box.addParcel(parcel1);
        box.addParcel(parcel2);
        
        List<StandardParcel> parcels = box.getAllParcels();
        Assertions.assertEquals(2, parcels.size());
        Assertions.assertEquals(80, box.getCurrentWeight());
    }
    
    @Test
    public void testParcelBoxExceedMaxWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(50);
        StandardParcel parcel1 = new StandardParcel("Книга", 30, "Москва", 1);
        StandardParcel parcel2 = new StandardParcel("Одежда", 30, "Санкт-Петербург", 2);
        
        box.addParcel(parcel1);
        box.addParcel(parcel2); // Должна быть отклонена
        
        List<StandardParcel> parcels = box.getAllParcels();
        Assertions.assertEquals(1, parcels.size());
        Assertions.assertEquals(30, box.getCurrentWeight());
    }
    
    @Test
    public void testParcelBoxBoundaryWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(50);
        StandardParcel parcel1 = new StandardParcel("Книга", 30, "Москва", 1);
        StandardParcel parcel2 = new StandardParcel("Одежда", 20, "Санкт-Петербург", 2);
        
        box.addParcel(parcel1);
        box.addParcel(parcel2); // Граничный случай: 30 + 20 = 50, должно добавиться
        
        List<StandardParcel> parcels = box.getAllParcels();
        Assertions.assertEquals(2, parcels.size());
        Assertions.assertEquals(50, box.getCurrentWeight());
    }
    
    @Test
    public void testParcelBoxFragileParcels() {
        ParcelBox<FragileParcel> box = new ParcelBox<>(100);
        FragileParcel parcel1 = new FragileParcel("Ваза", 40, "Москва", 1);
        FragileParcel parcel2 = new FragileParcel("Зеркало", 50, "Санкт-Петербург", 2);
        
        box.addParcel(parcel1);
        box.addParcel(parcel2); // Должна быть отклонена (40 + 50 = 90, но превышает 100? Нет, 90 < 100, должно добавиться)
        
        List<FragileParcel> parcels = box.getAllParcels();
        Assertions.assertEquals(2, parcels.size());
        Assertions.assertEquals(90, box.getCurrentWeight());
    }
}

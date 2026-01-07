package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelTest {
    
    @Test
    public void testPerishableParcelNotExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1, 3);
        Assertions.assertFalse(parcel.isExpired(3));
    }
    
    @Test
    public void testPerishableParcelExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1, 3);
        Assertions.assertTrue(parcel.isExpired(5));
    }
    
    @Test
    public void testPerishableParcelExpiredBoundary() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1, 3);
        Assertions.assertTrue(parcel.isExpired(4));
    }
    
    @Test
    public void testPerishableParcelNotExpiredSameDay() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 1, "Москва", 1, 3);
        Assertions.assertFalse(parcel.isExpired(1));
    }
    
    @Test
    public void testPerishableParcelCustomExpiryDays() {
        PerishableParcel parcel = new PerishableParcel("Овощи", 5, "Санкт-Петербург", 1, 5);
        Assertions.assertFalse(parcel.isExpired(5));
        Assertions.assertTrue(parcel.isExpired(7));
    }
}


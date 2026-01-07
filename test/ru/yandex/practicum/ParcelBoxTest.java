package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.*;

import java.util.List;

public class ParcelBoxTest {
    
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
        box.addParcel(parcel2);
        
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
        box.addParcel(parcel2);
        
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
        box.addParcel(parcel2);
        
        List<FragileParcel> parcels = box.getAllParcels();
        Assertions.assertEquals(2, parcels.size());
        Assertions.assertEquals(90, box.getCurrentWeight());
    }
}


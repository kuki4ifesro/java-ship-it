package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels;
    private int maxWeight;
    private int currentWeight;
    
    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.parcels = new ArrayList<>();
        this.currentWeight = 0;
    }
    
    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Предупреждение: посылка <<" + parcel.getDescription() + 
                             ">> не может быть добавлена. Превышен максимальный вес коробки.");
            return;
        }
        parcels.add(parcel);
        currentWeight += parcel.getWeight();
    }
    
    public List<T> getAllParcels() {
        return new ArrayList<>(parcels);
    }
    
    public int getCurrentWeight() {
        return currentWeight;
    }
    
    public int getMaxWeight() {
        return maxWeight;
    }
}


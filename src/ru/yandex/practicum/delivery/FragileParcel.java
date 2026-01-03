package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    
    @Override
    protected String getPackagePrefix() {
        return "Посылка <<" + description + ">> обёрнута в защитную плёнку";
    }
    
    @Override
    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }
    
    @Override
    public int calculateDeliveryCost() {
        return 200 + weight * 15;
    }
    
    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    }
}


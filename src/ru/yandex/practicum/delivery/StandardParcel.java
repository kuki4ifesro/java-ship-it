package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    
    @Override
    protected String getPackagePrefix() {
        return null;
    }
    
    @Override
    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }
    
    @Override
    public int calculateDeliveryCost() {
        return 100 + weight * 10;
    }
}


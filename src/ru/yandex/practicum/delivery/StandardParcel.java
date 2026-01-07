package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    
    @Override
    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }
    
    @Override
    protected int getBaseCost() {
        return 2;
    }
}


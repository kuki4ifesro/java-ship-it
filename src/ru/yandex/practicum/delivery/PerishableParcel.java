package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int expiryDays;
    
    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int expiryDays) {
        super(description, weight, deliveryAddress, sendDay);
        this.expiryDays = expiryDays;
    }
    
    @Override
    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }
    
    @Override
    protected int getBaseCost() {
        return 3;
    }
    
    public boolean isExpired(int currentDay) {
        return (currentDay - sendDay) > expiryDays;
    }
}


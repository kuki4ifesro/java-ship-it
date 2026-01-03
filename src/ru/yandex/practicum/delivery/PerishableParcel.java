package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private static final int EXPIRY_DAYS = 3;
    
    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay) {
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
        return 150 + weight * 12;
    }
    
    public boolean isExpired(int currentDay) {
        return (currentDay - sendDay) > EXPIRY_DAYS;
    }
}


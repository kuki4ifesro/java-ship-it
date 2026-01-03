package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    
    protected static final String PACKAGED_MESSAGE = " упакована";
    
    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
    
    public void packageItem() {
        String prefix = getPackagePrefix();
        if (prefix != null && !prefix.isEmpty()) {
            System.out.println(prefix);
        }
        System.out.println("Посылка <<" + description + ">>" + PACKAGED_MESSAGE);
    }
    
    protected abstract String getPackagePrefix();
    
    public abstract void deliver();
    
    public abstract int calculateDeliveryCost();
    
    public String getDescription() {
        return description;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    
    public int getSendDay() {
        return sendDay;
    }
}

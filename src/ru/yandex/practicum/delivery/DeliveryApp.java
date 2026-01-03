package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        
        int type = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        
        System.out.println("Введите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Введите адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        
        System.out.println("Введите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        
        Parcel parcel = null;
        switch (type) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                break;
            case 2:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                break;
            case 3:
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay);
                break;
            default:
                System.out.println("Неверный тип посылки.");
                return;
        }
        
        allParcels.add(parcel);
        System.out.println("Посылка добавлена.");
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки всех посылок: " + totalCost);
    }

}


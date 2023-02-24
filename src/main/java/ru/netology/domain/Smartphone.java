package ru.netology.domain;

public class Smartphone extends Product {
    private String smartphoneMaker;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String smartphoneMaker) {
        super(id, name, price);
        this.smartphoneMaker = smartphoneMaker;
    }

    public String getSmartphoneMaker() {
        return smartphoneMaker;
    }

    public void setSmartphoneMaker(String smartphoneMaker) {
        this.smartphoneMaker = smartphoneMaker;
    }
}

package com.company.award;



public class Award {
    static {
        System.out.println("Static init block for Award");
    }
    {
        System.out.println("Instance initialization " + this.getValue());
    }

    private final int value;
    private double soli;

    public Award(int value) {
        this.value = value;
        System.out.println("Constructor init " + this.value);
    }

    public Award(int value, double soli) {
        this.value = value;
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }

    public void setSoli(double soli) {
        this.soli = soli;
    }

    public double getSoli() {
        return soli;
    }
}

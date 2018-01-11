package com.company.nominator;



public class Nominator {
    static {
        System.out.println("Static init block for Nominator");
    }

    private String name;
    private Integer nominatorAwardQuantityLimit;
    private float nominatorAwardAmountLimit;


    public void setName(String name) {
        this.name = name;
    }

    public void setNominatorAwardQuantityLimit(Integer nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardAmountLimit(float nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public String getName() {

        return name;
    }

    public Integer getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public float getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public Nominator(String name) {
        this.name = name;
    }

    public Nominator(String name, Integer nominatorAwardQuantityLimit, float nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }
}

package com.company.nominee;
import com.company.award.Award;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Nominee {
    static {
        System.out.println("Static init block for Nominee");
    }
    private String name;
    private Integer nomineeAwardQuantityLimit;
    private float nomineeAwardAmountLimit;

    public void setNomineeAwardQuantityLimit(Integer nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardAmountLimit(float nomineeAwardAmountLimit) {
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public Integer getNomineeAwardQuantityLimit() {

        return nomineeAwardQuantityLimit;
    }

    public float getNomineeAwardAmountLimit() {
        return nomineeAwardAmountLimit;
    }

    public Nominee(String name) {
        this.name = name;
    }

    public Nominee(String name, Integer nomineeAwardQuantityLimit, float nomineeAwardAmountLimit) {
        this.name = name;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
        this.nomineeAwardAmountLimit = nomineeAwardAmountLimit;
    }

    public String getName() {
        return name;
    }




    public void receiveAward(Award award) {
        if (award.getSoli() == 0.0) {
            System.out.println("Award value calculated without soli: " + award.getValue());
        }
        else {
            System.out.println("Award value calculated with soli: " + award.getValue() * award.getSoli());
            System.out.println("Soli: " + award.getSoli());
            System.out.println("Decreased amount: " + ((award.getValue() - award.getValue() * award.getSoli())/award.getValue())*100 + "%");
        }
    }

    public double newFormula(Award award) {
        int population = 3;
        Random random = new Random();
        int randomIntNumber = random.nextInt(100);
        double randomDoubleNumber = random.nextDouble();
        double newDouble = new BigDecimal(randomDoubleNumber).setScale(2, RoundingMode.UP).doubleValue();
        System.out.println("randomIntNumber = " + randomIntNumber);
        System.out.println("randomDoubleNumber = " + newDouble);
        double firstPartOfFormula = (Math.pow(randomIntNumber,2)*award.getValue()*(1-award.getValue()));
        double secondPartOfFormula = Math.pow(newDouble,2);
        double quantity = (firstPartOfFormula/secondPartOfFormula)/(1+(((firstPartOfFormula/secondPartOfFormula)-1)/population));

        System.out.println("firstPartOfFormula = " + firstPartOfFormula);
        System.out.println("secondPartOfFormula = " + secondPartOfFormula);
        System.out.println("Result calculated by simplified formula: " + quantity);
        System.out.println("Quantity equals: " + ((Math.pow(randomIntNumber,2)*award.getValue()*(1-award.getValue()))/(Math.pow(newDouble,2)))
                /(1 + ((((Math.pow(randomIntNumber,2)*award.getValue()*(1-award.getValue()))/(Math.pow(newDouble,2)))-1)/population)));

        return quantity;
    }
}

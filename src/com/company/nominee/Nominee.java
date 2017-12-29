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

    public int population = 3;

    Random random = new Random();
    public int z = random.nextInt(100);
    public double c = random.nextDouble();
    double newDouble = new BigDecimal(c).setScale(2, RoundingMode.UP).doubleValue();

    public double newFormula(Award award) {
        System.out.println("z = " + z);
        System.out.println("c = " + newDouble);
        double a = (Math.pow(z,2)*award.getValue()*(1-award.getValue()));
        double b = Math.pow(newDouble,2);
        double quantity = (a/b)/(1+(((a/b)-1)/population));

        System.out.println("a = " + ((Math.pow(z,2)*award.getValue()*(1-award.getValue()))));
        System.out.println("b = " + (Math.pow(newDouble,2)));
        System.out.println("Result calculated by simplified formula: " + (a/b)/(1+(((a/b)-1)/population)));
        System.out.println("Quantity equals: " + ((Math.pow(z,2)*award.getValue()*(1-award.getValue()))/(Math.pow(newDouble,2)))
                /(1 + ((((Math.pow(z,2)*award.getValue()*(1-award.getValue()))/(Math.pow(newDouble,2)))-1)/population)));

        return quantity;
    }
}

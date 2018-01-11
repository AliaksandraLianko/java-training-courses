package com.company.utils;

import com.company.award.Award;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class FormulaCalculation {

    /**
     * This method recalculates the initial award value through the formula and returns updated award value
     * @param award          the award object
     * @return quantity      new award value calculated by formula
     */
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

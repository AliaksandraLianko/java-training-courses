package com.company.person;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;
import com.company.utils.NominationHelper;

public abstract class Person implements OperationsWithLimit{
    private String name;
    /**
     * max number of awards that can be given or received
     */
    private Integer awardQuantityLimit;
    /**
     * max sum of awards that can be given or received
     */
    private float awardAmountLimit;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer awardQuantityLimit, float awardAmountLimit) {
        this.name = name;
        this.awardQuantityLimit = awardQuantityLimit;
        this.awardAmountLimit = awardAmountLimit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAwardQuantityLimit() {
        return awardQuantityLimit;
    }

    public float getAwardAmountLimit() {
        return awardAmountLimit;
    }

    public void setAwardQuantityLimit(Integer awardQuantityLimit) {
        this.awardQuantityLimit = awardQuantityLimit;
    }

    public void setAwardAmountLimit(float awardAmountLimit) {
        this.awardAmountLimit = awardAmountLimit;
    }
    NominationHelper nominationHelper = new NominationHelper();

    /**
     * This method calculates the award value
     * If soli factor is not defined, message with initial award value is displayed in console
     * If soli factor is defined, award value is recalculated. Updated award value, soli factor and percent of change in award value are displayed in console
     * @param award the award object
     */
    protected void receiveAward(Award award) {
        if (award.getSoli() == 0.0) {
            System.out.println("Award value calculated without soli: " + award.getValue());
        }
        else {
            System.out.println("Award value calculated with soli: " + award.getValue() * award.getSoli());
            System.out.println("Soli: " + award.getSoli());
            System.out.println("Decreased amount: " + ((award.getValue() - award.getValue() * award.getSoli())/award.getValue())*100 + "%");
        }
    }

    public abstract boolean isLimitReached(float currentValue, float limit);
}

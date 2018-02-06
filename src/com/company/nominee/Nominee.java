package com.company.nominee;


import com.company.award.Award;
import com.company.person.Person;

public class Nominee extends Person {
    static {
        System.out.println("Static init block for Nominee");
    }

    private int numberOfReceivedAwards;

    public Nominee(String name) {
        super(name);
    }

    public Nominee(String name, int numberOfReceivedAwards) {
        super(name);
        this.numberOfReceivedAwards = numberOfReceivedAwards;
    }

    public Nominee(String name, Integer awardQuantityLimit, float awardAmountLimit, int numberOfReceivedAwards) {
        super(name, awardQuantityLimit, awardAmountLimit);
        this.numberOfReceivedAwards = numberOfReceivedAwards;
    }

    @Override
    public void receiveAward(Award award) {
        super.receiveAward(award);
        System.out.println("Nominee " + getName() + " receives award" );
    }

    @Override
    public boolean isLimitReached(float currentValue, float limit) {
        numberOfReceivedAwards++;
        System.out.println("Nominee has received " + numberOfReceivedAwards + " awards");
        return currentValue<=limit;
    }


}

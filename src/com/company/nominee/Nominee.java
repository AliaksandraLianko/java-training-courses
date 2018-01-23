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
        if (award.getSoli() == 0.0) {
            System.out.println("Award value calculated without soli: " + award.getValue());
        }
        else {
            System.out.println("Award value calculated with soli: " + award.getValue() * award.getSoli());
            System.out.println("Soli: " + award.getSoli());
            System.out.println("Decreased amount: " + ((award.getValue() - award.getValue() * award.getSoli())/award.getValue())*100 + "%");
        }
        System.out.println("Nominee " + getName() + " receives award" );
    }
}

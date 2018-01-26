package com.company.nominator;


import com.company.award.Award;
import com.company.person.Person;

public class Nominator extends Person {
    static {
        System.out.println("Static init block for Nominator");
    }

    private int numberOfGivenAwards;

    public Nominator(String name) {
        super(name);
    }

    public Nominator(String name, int numberOfGivenAwards) {
        super(name);
        this.numberOfGivenAwards = numberOfGivenAwards;
    }

    public Nominator(String name, Integer awardQuantityLimit, float awardAmountLimit, int numberOfGivenAwards) {
        super(name, awardQuantityLimit, awardAmountLimit);
        this.numberOfGivenAwards = numberOfGivenAwards;
    }
     @Override
    public void receiveAward(Award award) {
         if (award.getSoli() == 0.0) {
             System.out.println("Award value calculated without soli: " + award.getValue());
         }
         else {
             System.out.println("Error. Soli factor cannot be calculated for nominator" );
         }
         System.out.println("Nominator " + getName() + " gives award" );
     }

}

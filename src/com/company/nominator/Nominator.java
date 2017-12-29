package com.company.nominator;
import com.company.award.Award;
import com.company.nominee.Nominee;

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

    public void nominate(Nominee nominee, Award award) {
        System.out.println("Nominates:" + nominee.getName());
        nominee.receiveAward(award);
    }

    public void nominateTillReachNomineeAwardQuantityLimit (Nominee nominee, Award award) {
        for(int i=1; i<=nominee.getNomineeAwardQuantityLimit()+1; i++){

            if (i<nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(name + " gives award " + i + " to " + nominee.getName());

            } else if (i==nominee.getNomineeAwardQuantityLimit()) {
                nominee.receiveAward(award);
                System.out.println(name + " gives award " + i + " to " + nominee.getName() + ". This is last award before restriction");

            } else {
                System.out.println("Award quantity limit " + nominee.getNomineeAwardQuantityLimit() + " is reached for recipient " + nominee.getName() + " for awards quantity");

                System.out.println("Total number of received awards is " + nominee.getNomineeAwardQuantityLimit());
            }
        }
    }


    public void nominateTillReachNominatorAwardQuantityLimit (Nominee nominee, Award award) {
        int nominationsCount = 1;
        int count1 = 0;
        do {
            nominee.receiveAward(award);
            count1++;
            System.out.println(name + " gives award " + nominationsCount + " to " + nominee.getName());
            nominationsCount++;
        } while (nominationsCount<=getNominatorAwardQuantityLimit());

        System.out.println("Award quantity limit " + getNominatorAwardQuantityLimit() + " is reached for nominator " + name + " for quantity of awards");
        System.out.println("Total number of given awards is " + count1);
    }


    public void nominateTillReachNominatorAwardAmountLimit (Nominee nominee, Award award) {
        int totalAwardAmountForNominator = 0;
        int count = 0;
        while (totalAwardAmountForNominator + award.getValue()<=getNominatorAwardAmountLimit()) {
            totalAwardAmountForNominator += award.getValue();
            nominee.receiveAward(award);
            count++;
            System.out.println(name + " gives award for " + award.getValue() + " to " + nominee.getName());
        }
        System.out.println("Award amount limit " + getNominatorAwardAmountLimit() + " is reached for nominator " + name + " for total amount of awards");
        System.out.println("Total number of given awards is " + count);
    }



    public void nominateTillReachNomineeAwardAmountLimit (Nominee nominee, Award award) {
        Integer totalAwardAmountForNominee = 0;
        Float currentAwardAmount = new Float(totalAwardAmountForNominee + award.getValue());
        Float amountLimit = nominee.getNomineeAwardAmountLimit();
        int comparison = currentAwardAmount.compareTo(amountLimit);
        comparison = comparison>0? 1:comparison<0? -1: comparison;
        switch (comparison) {
            case -1:
                System.out.println("Give award");
                currentAwardAmount += award.getValue();
                break;
            case 0:
                System.out.println("Last award");
                currentAwardAmount += award.getValue();
                break;
            case 1:
                System.out.println("No award");
                currentAwardAmount += award.getValue();
                break;
            default:
                System.out.println("Nothing");

        }


    }
}

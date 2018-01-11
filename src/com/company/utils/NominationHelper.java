package com.company.utils;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;

public class NominationHelper {

    /**
     * This method calculates the award value
     * If soli factor is not defined, message with initial award value is displayed in console
     * If soli factor is defined, award value is recalculated. Updated award value, soli factor and percent of change in award value are displayed in console
     * @param award the award object
     */
    private void receiveAward(Award award) {
        if (award.getSoli() == 0.0) {
            System.out.println("Award value calculated without soli: " + award.getValue());
        }
        else {
            System.out.println("Award value calculated with soli: " + award.getValue() * award.getSoli());
            System.out.println("Soli: " + award.getSoli());
            System.out.println("Decreased amount: " + ((award.getValue() - award.getValue() * award.getSoli())/award.getValue())*100 + "%");
        }
    }

    /**
     * This method creates nomination for award from nominator to nominee and calls receiveAward method to calculate award value
     * @param nominee     User who receives the award
     * @param award       the award object
     * @param nominator   User who creates the award
     */
    public void nominate(Nominee nominee, Award award, Nominator nominator) {
             System.out.println(nominator.getName() + "Nominates:" + nominee.getName());
             receiveAward(award);
    }


    /**
     * This method creates nominations until defined limit for awards quantity for nominee is not reached
     * After limit is reached nominations are not created and message with number of received awards for nominee is displayed on console
     * @param nominee       User who receives the award
     * @param award         the award object
     * @param nominator     User who creates the award
     */
    public void nominateTillReachNomineeAwardQuantityLimit(Nominee nominee, Award award, Nominator nominator) {
        for (int i = 1; i <= nominee.getNomineeAwardQuantityLimit() + 1; i++) {

            if (i < nominee.getNomineeAwardQuantityLimit()) {
                receiveAward(award);
                System.out.println(nominator.getName() + " gives award " + i + " to " + nominee.getName());

            } else if (i == nominee.getNomineeAwardQuantityLimit()) {
                receiveAward(award);
                System.out.println(nominator.getName() + " gives award " + i + " to " + nominee.getName() + ". This is last award before restriction");

            } else {
                System.out.println("Award quantity limit " + nominee.getNomineeAwardQuantityLimit() + " is reached for recipient " + nominee.getName() + " for awards quantity");

                System.out.println("Total number of received awards is " + nominee.getNomineeAwardQuantityLimit());
            }
        }
    }

    /**
     * This method creates nominations until defined limit for awards quantity for nominator is not reached
     * After limit is reached nominations are not created and message with number of given awards for nominator is displayed on console
     * @param nominee     User who receives the award
     * @param award       the award object
     * @param nominator   User who creates the award
     */
    public void nominateTillReachNominatorAwardQuantityLimit(Nominee nominee, Award award, Nominator nominator) {
        int nominationsCount = 1;
        int count = 0;
        do {
            receiveAward(award);
            count++;
            System.out.println(nominator.getName() + " gives award " + nominationsCount + " to " + nominee.getName());
            nominationsCount++;
        } while (nominationsCount <= nominator.getNominatorAwardQuantityLimit());

        System.out.println("Award quantity limit " + nominator.getNominatorAwardQuantityLimit() + " is reached for nominator " + nominator.getName() + " for quantity of awards");
        System.out.println("Total number of given awards is " + count);
    }


    /**
     * This method creates nominations until defined limit for awards amount for nominator is not reached
     * After limit is reached nominations are not created and message with number of given awards for nominator is displayed on console
     * @param nominee       User who receives the award
     * @param award         the award object
     * @param nominator     User who creates the award
     */
    public void nominateTillReachNominatorAwardAmountLimit(Nominee nominee, Award award, Nominator nominator) {
        int totalAwardAmountForNominator = 0;
        int count = 0;
        while (totalAwardAmountForNominator + award.getValue() <= nominator.getNominatorAwardAmountLimit()) {
            totalAwardAmountForNominator += award.getValue();
            receiveAward(award);
            count++;
            System.out.println(nominator.getName() + " gives award for " + award.getValue() + " to " + nominee.getName());
        }
        System.out.println("Award amount limit " + nominator.getNominatorAwardAmountLimit() + " is reached for nominator " + nominator.getName() + " for total amount of awards");
        System.out.println("Total number of given awards is " + count);
    }


    /**
     * This method creates nominations until defined limit for awards amount for nominee is not reached
     * After limit is reached nominations are not created and message with amount of received awards for nominee is displayed on console
     * @param nominee     User who receives the award
     * @param award       the award object
     */
    public void nominateTillReachNomineeAwardAmountLimit(Nominee nominee, Award award) {
        Integer totalAwardAmountForNominee = 0;
        Float currentAwardAmount = (float) (totalAwardAmountForNominee + award.getValue());
        Float amountLimit = nominee.getNomineeAwardAmountLimit();
        int comparison = currentAwardAmount.compareTo(amountLimit);

        while (currentAwardAmount <= nominee.getNomineeAwardAmountLimit()) {
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
                    break;
                default:
                    System.out.println("Nothing");

            }
        }
        System.out.println("Total amount of given awards is " + currentAwardAmount);


    }

}

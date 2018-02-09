package com.company;

import com.company.award.Award;
import com.company.exceptions.SmallAwardAmountException;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;
import com.company.person.Person;
import com.company.utils.FormulaCalculationHelper;
import com.company.utils.NominationHelper;

public class Main {

    public static void main(String[] args) throws SmallAwardAmountException {
        /**
         * Objects nominee, award, nominator, nominatorHelper and formulaCalculationHelper are created
         */

        Nominee nominee1 = new Nominee("Emma");
        Nominee nominee2 = new Nominee("Jane");
        Nominee nominee3 = new Nominee("Melanie");

        Award award1 = new Award(100);
        Award award2 = new Award(500, 0.85);

        Nominator nominator = new Nominator("Vlad");

        NominationHelper nominatorHelper = new NominationHelper();

        nominatorHelper.nominate(nominee1, award1, nominator);
        nominatorHelper.nominate(nominee2, award1, nominator);
        nominatorHelper.nominate(nominee3, award1, nominator);
        nominatorHelper.nominate(nominee1, award2, nominator);
        nominatorHelper.nominate(nominee2, award2, nominator);
        nominatorHelper.nominate(nominee3, award2, nominator);

        FormulaCalculationHelper formulaCalculationHelper = new FormulaCalculationHelper();
        formulaCalculationHelper.newFormula(award1);
        formulaCalculationHelper.newFormula(award1);
        formulaCalculationHelper.newFormula(award1);

        double firstNominee = formulaCalculationHelper.newFormula(award1);
        double secondNominee = formulaCalculationHelper.newFormula(award1);
        double thirdNominee = formulaCalculationHelper.newFormula(award1);

        System.out.println("Quantity for the first nominee is " + firstNominee);
        System.out.println("Quantity for the second nominee is " + secondNominee);
        System.out.println("Quantity for the third nominee is " + thirdNominee);

        if (firstNominee > secondNominee) {
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is greater than " + nominee2.getName() + "'s award quantity " + secondNominee);
        }
        if (firstNominee <= secondNominee) {
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is less or equal to " + nominee2.getName() + "'s award quantity " + secondNominee);
        }
        if (firstNominee == secondNominee) {
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is equal to " + nominee2.getName() + "'s award quantity " + secondNominee);
        }
        if (firstNominee != secondNominee) {
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is not equal to " + nominee2.getName() + "'s award quantity " + secondNominee);
        }
        if (firstNominee > secondNominee && firstNominee > thirdNominee){
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is the biggest ");
        }
        if (firstNominee > secondNominee || firstNominee > thirdNominee){
            System.out.println(nominee1.getName() + "'s award quantity " + firstNominee + " is not the smallest ");
        }

        Nominator nominator1 = new Nominator("Emilie", 10, 500, 0);
        Nominee nominee4 = new Nominee("Sarrah", 15, 300, 0);

        nominatorHelper.nominateTillReachNominatorAwardQuantityLimit(nominee4, award1, nominator1);
        nominatorHelper.nominateTillReachNominatorAwardAmountLimit(nominee4, award1, nominator1);
        nominatorHelper.nominateTillReachNomineeAwardAmountLimit(nominee4, award1);
        nominatorHelper.nominateTillReachNomineeAwardQuantityLimit(nominee4, award1, nominator1);

        Person nominator2 = new Nominator("Alex");
        Person nominee5 = new Nominee("Alex");
        nominator2.createYosAward(award1);
        nominee5.createYosAward(award1, nominee5);

        Award award3 = new Award(-100);
        nominee1.receiveAward(award3);
    }
}

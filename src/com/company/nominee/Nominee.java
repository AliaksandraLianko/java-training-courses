package com.company.nominee;
import com.company.award.Award;
import com.company.utils.NominationHelper;

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
    NominationHelper nominatorHelper = new NominationHelper();
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

}

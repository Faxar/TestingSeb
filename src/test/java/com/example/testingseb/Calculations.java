package com.example.testingseb;

import com.example.testingseb.calculatedObjects.CalculatedDataInput;
import com.example.testingseb.calculatedObjects.CalculatedDataOutput;
public class Calculations {

    public CalculatedDataOutput calculateMonthlyPayment(CalculatedDataInput record) {
        double commissionFee;
        if(record.purchaseValue() >= 8000 && record.purchaseValue() <= 20000) {
            commissionFee = 200;
        } else {
            commissionFee = record.purchaseValue() / 100;
        }
        return new CalculatedDataOutput(commissionFee, firstInstallmentCalculation(record.purchaseValue(), record.firstInstallment()));
    }

    private double firstInstallmentCalculation(double purchaseValue, int firstInstallment) {
        return (purchaseValue * firstInstallment) / 100;
    }

}

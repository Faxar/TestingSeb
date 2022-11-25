package com.example.testingseb.calculationData;

import com.example.testingseb.calculatedObjects.CalculatedDataInput;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public CalculatedDataInput generateData() {

        int purchaseValue = ThreadLocalRandom.current().nextInt(8000, 100001);
        int firstInstallment = ThreadLocalRandom.current().nextInt(10, 91);

        return new CalculatedDataInput(purchaseValue, 3, firstInstallment, 10);
    }

}

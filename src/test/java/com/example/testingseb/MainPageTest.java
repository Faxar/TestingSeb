package com.example.testingseb;

import com.example.testingseb.calculatedObjects.CalculatedDataInput;
import com.example.testingseb.calculatedObjects.CalculatedDataOutput;
import com.example.testingseb.calculationData.DataGenerator;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPageTest {
    private SebLtEnbusinessPage sebPage;
    private CalculatedDataInput inputData;
    private CalculatedDataOutput outputData;
    WebDriver driver = new ChromeDriver();



    @BeforeClass
    public void setUp() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.seb.lt/en/business/financing/leasing-your-business");

        sebPage =  new SebLtEnbusinessPage(driver);
        sebPage.acceptCookies.click();
        driver.switchTo().frame("calculator-frame-06");;
    }

    @AfterClass
    public void tearDown() {driver.close();}

    @Test
    public void validateOutputCalculations() {
        inputData = new DataGenerator().generateData();
        testDataPreparationAndFill(inputData);
        outputData =  new Calculations().calculateMonthlyPayment(inputData);
        assertEquals(customFormat(outputData.firstInstallment()), sebPage.firstInstallmentResult.getText().replaceAll("\\s+",""));
        assertEquals(customFormat(outputData.commissionFee()), sebPage.calculatedCommissionResult.getText().replaceAll("\\s+",""));
    }

    @Test
    public void validateComparisonData() {
        inputData = new DataGenerator().generateData();
        outputData =  new Calculations().calculateMonthlyPayment(inputData);
        testDataPreparationAndFill(inputData);
        sebPage.addForComparison.click();
        assertTrue(sebPage.firstComparisonLine.isDisplayed());
        testDataPreparationAndFill(inputData);
        sebPage.addForComparison.click();
        assertTrue(sebPage.secondComparisonLine.isDisplayed());
    }

    private void testDataPreparationAndFill(CalculatedDataInput inputData) {
        sebPage.purchaseValue.clear();
        sebPage.purchaseValue.sendKeys(Double.toString(inputData.purchaseValue()));
        sebPage.firstInstallment.clear();
        sebPage.firstInstallment.sendKeys(Integer.toString(inputData.firstInstallment()));
        sebPage.calculateBtn.click();
    }

    static public String customFormat(double value) {
        String pattern = "######.##";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        return myFormatter.format(value);
    }
}

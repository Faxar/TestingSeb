package com.example.testingseb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SebLtEnbusinessPage {

    @FindBy(id = "calculator-frame-06")
    public WebElement calculatorFrame;

    @FindBy(id = "f-summa")
    public WebElement purchaseValue;

    @FindBy(id = "f-likme")
    public WebElement interestRate;

    @FindBy(id = "f-maksa")
    public WebElement firstInstallment;

    @FindBy(id = "f-rest")
    public WebElement remainingValue;

    @FindBy(className = "btn-dark")
    public WebElement calculateBtn;

    @FindBy(xpath ="//span[@class='calc-result' and @data-name='commision']")
    public WebElement calculatedCommissionResult;

    @FindBy(xpath = "//span[@class='calc-result' and @data-name='maksa']")
    public WebElement firstInstallmentResult;

    @FindBy(className = "accept-selected")
    public WebElement acceptCookies;

    @FindBy(className = "btn-dark")
    public WebElement calculateButton;

    @FindBy(className = "js-comparison-add")
    public WebElement addForComparison;

    @FindBy(xpath = "//td[@class='hidden-sm-down' and text()='1']")
    public WebElement firstComparisonLine;

    @FindBy(xpath = "//td[@class='hidden-sm-down' and text()='2']")
    public WebElement secondComparisonLine;

    public SebLtEnbusinessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework3 extends TestBase {

    @Test
    public void test(){
        //1. " https://demoqa.com/dynamic-properties” sayfasina gidin
        //2. “Visible After 5 Seconds” butonunun gorunun oldugunu test edin
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement visibleAfter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(visibleAfter.isDisplayed());
        System.out.println("visibilute gorunur");


    }

}

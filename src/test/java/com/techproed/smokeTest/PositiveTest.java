package com.techproed.smokeTest;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
//1) com.techproed altinda bir package olustur : smoketest
//2) Bir Class olustur : PositiveTest
//3) Bir test method olustur positiveLoginTest()

//  login butonuna bas




public class PositiveTest extends TestBase {

    @Test

    public void positiveLoginTest(){
        //   http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");

        //Log-in butonuna basin
        driver.findElement(By.linkText("Log in")).click();



        Actions actions=new Actions(driver);
        //username textbox'ina valid username girin, password girin log'in e basin
        //test data username: manager ,
        //test data password : Manager2!
        WebElement username=driver.findElement(By.id("UserName"));
        username.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Manager2!").perform();
        driver.findElement(By.id("btnSubmit")).click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement dogrula=driver.findElement(By.xpath("//span[@class='title']"));
        Assert.assertTrue(dogrula.isDisplayed());







    }
}

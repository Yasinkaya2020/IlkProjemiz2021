package com.techproed.smokeTest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    //    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //      3 Farkli test Methodunda 3 senaryoyu test et
    //  - yanlisSifre
    //  - yanlisKulllanici
    //  - yanlisSifreKullanici
    //2) http://qa-environment.crystalkeyhotels.com adresine git
    //            3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et

    @Test

    public void yanlissifre(){
        Actions actions=new Actions(driver);
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        WebElement username=driver.findElement(By.id("UserName"));
        username.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Manager2!x").perform();
        WebElement loginOnay= driver.findElement(By.id("btnSubmit"));
        loginOnay.click();

    }
    @Test
    public void yanliskullanici(){
        Actions actions=new Actions(driver);
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        WebElement username=driver.findElement(By.id("UserName"));
        username.sendKeys("managerx");
        actions.sendKeys(Keys.TAB).sendKeys("Manager2!").perform();
       WebElement loginOnay= driver.findElement(By.id("btnSubmit"));
       loginOnay.click();

    }
    @Test
    public void yanliskullanicisifre(){
        Actions actions=new Actions(driver);
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        WebElement username=driver.findElement(By.id("UserName"));
        username.sendKeys("managerx");
        actions.sendKeys(Keys.TAB).sendKeys("Manager2!x").perform();
        WebElement loginOnay= driver.findElement(By.id("btnSubmit"));
        loginOnay.click();


            }

}

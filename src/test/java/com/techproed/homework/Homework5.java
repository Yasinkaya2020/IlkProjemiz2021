package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework5 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html”
        //sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin

        driver.switchTo().frame("frame");
        driver.findElement(By.linkText("Our Products")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.findElement(By.className("modal-body")).getText());

        //5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        driver.switchTo().defaultContent();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine
        //gittigini test edin
        String URL=driver.getCurrentUrl();
        Assert.assertEquals(URL,"http://webdriveruniversity.com/index.html");

        System.out.println("Dogru sayfadisiniz");

    }
}

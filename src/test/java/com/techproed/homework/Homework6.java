package com.techproed.homework;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Set;

public class Homework6 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        Faker faker=new Faker();

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaHandle=driver.getWindowHandle();
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("(//h1)[2]")).click();
        Set<String> tumHandl=driver.getWindowHandles();
        String ikincisayfaHandle="";

        for (String w: tumHandl
             ) {
            if (!w.equals(ikincisayfaHandle)){
                ikincisayfaHandle=w;
            }

        }


        //4.Diger window'a gecin
        driver.switchTo().window(ikincisayfaHandle);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet()
                .password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //6."login" butonuna basin
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String yazi=driver.switchTo().alert().getText();
        Assert.assertEquals(yazi,"validation failed");
        System.out.println("Dogrulama PASS");

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun

        driver.switchTo().window(ilkSayfaHandle);
        Thread.sleep(4000);
        //10.Ilk sayfaya donuldugunu test edin
        String ilksayfaUrl=driver.getCurrentUrl();
        Assert.assertEquals(ilksayfaUrl,"http://webdriveruniversity.com/");
        System.out.println("Ilk sayfadasiniz");

    }
}

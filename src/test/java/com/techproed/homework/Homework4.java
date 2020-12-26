package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework4 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1."http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2."Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverMeFirst=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverMeFirst).perform();
        Thread.sleep(5000);

        //3."Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4.Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //6."Click and hold" kutusuna basili tutun
        WebElement clickAnd=driver.findElement(By.id("click-box"));
        actions.moveToElement(clickAnd).clickAndHold(clickAnd).perform();
        System.out.println(clickAnd.getText());


        //7. "Click and hold" kutusunda cikan yaziyi yazdirin

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.tagName("h2"));
        Thread.sleep(3000);
        actions.doubleClick(doubleClick).perform();
    }




}

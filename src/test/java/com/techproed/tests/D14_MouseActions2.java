package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

public class D14_MouseActions2 extends TestBase {


    @Test
    public void test() throws InterruptedException {

        //1- http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        // 2- Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini  gorelim
        Actions actions=new Actions(driver);

        WebElement renkDegistir=driver.findElement(By.id("div2"));

        actions.moveToElement(renkDegistir).perform();

        Thread.sleep(5000);

        // 3- Click Me butonuna click yapalim ve cikan alertteki mesajin  "Clicked !!" oldugunu dogrulayalim
            WebElement clickmi=driver.findElement(By.name("click"));
            actions.click(clickmi).perform();

        SoftAssert softAssert=new SoftAssert();
        String allertYazisi=driver.switchTo().alert().getText();
        softAssert.assertEquals(allertYazisi,"Clicked !!");

        driver.switchTo().alert().accept();


        // 4- Double Click Me! butonuna tiklayalim ve cikan mesajin "Double  Clicked !!" oldugunu dogrulayalim
        WebElement doubleClick=driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClick).perform();

        String doubleClickAllaertYazisi= driver.switchTo().alert().getText();
        softAssert.assertEquals(doubleClickAllaertYazisi,"Double Clicked !!");

        driver.switchTo().alert().accept();

        // 5- Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement tasinacakElement=driver.findElement(By.id("draggable"));
        WebElement tasimaHedefElement=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElement).perform();//dragAndDrop secile elementi tasir

        String hedefElementYazisi=tasimaHedefElement.getText();
        softAssert.assertEquals(hedefElementYazisi,"Dropped!");

        Thread.sleep(5000);

     softAssert.assertAll();

    }
}

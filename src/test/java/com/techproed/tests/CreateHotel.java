package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotel extends TestBase {
    //1. Tests packagenin altına class olusturun: CreateHotel
    //2. Bir metod olusturun: createHotel
    //3. qa-environment.crystalkeyhotels.com adresine git.
    //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri  girin.
    // a. Username : manager
    // b. Password : Manager2!
    //5. Login butonuna tıklayın.
    //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    //8. Save butonuna tıklayın.
    //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.


    @Test
    public void createHotel() throws InterruptedException {
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

        WebElement otelmang=driver.findElement(By.xpath("//*[.='Hotel Management']"));
        otelmang.click();
        driver.findElement(By.xpath("(//a[@href='/admin/HotelAdmin'])[1]")).click();
        WebElement addotel=driver.findElement(By.xpath("//span[@class='hidden-480']"));
        addotel.click();
        WebElement code=driver.findElement(By.id("Code"));
        code.sendKeys("123");
        actions.sendKeys(Keys.TAB).sendKeys("ali").sendKeys(Keys.TAB)
                .sendKeys("adana").sendKeys(Keys.TAB).sendKeys("12364")
                .sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).sendKeys("asadsa@gmail.com").perform();
        WebElement drobdovn=driver.findElement(By.id("IDGroup"));

        Select select=new Select(drobdovn);
        select.selectByVisibleText("Hotel Type2");

        Thread.sleep(3000);

        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement save=driver.findElement(By.id("btnSubmit"));
        save.click();
        Thread.sleep(3000);
        String yazi=driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
        System.out.println(yazi);
        Assert.assertEquals(yazi,"Hotel was inserted successfully");
        driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();


    }


}

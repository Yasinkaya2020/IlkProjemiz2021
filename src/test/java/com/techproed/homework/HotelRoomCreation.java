package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    //1. Tests packagenin altına class olusturun: HotelRoomCreation
    //2. Bir metod olusturun: RoomCreateTest()
    //3. qa-environment.crystalkeyhotels.com adresine gidin.
    //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
    //verileri girin.
    //a. Username : manager b. Password : Manager2!
    //5. Login butonuna tıklayın.
    //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    //8. Save butonuna basin.
    //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.
    //11. Hotel rooms linkine tıklayın.
    //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
    @Test
    public void RoomCreateTest() throws InterruptedException {
        //3. http://qa-environment.crystalkeyhotels.com adresine gidin.
        driver.get("http://qa-environment.crystalkeyhotels.com");
        //logine tiklayin
        driver.findElement(By.linkText("Log in")).click();
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
        //verileri girin.
        //a. Username : manager b. Password : Manager2!
        //5. Login butonuna tıklayın.
        Actions actions=new Actions(driver);
        WebElement usernameBox=driver.findElement(By.id("UserName"));
        usernameBox.sendKeys("manager");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Manager2!"+Keys.ENTER).
                perform();
        driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
        driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']")).click();
        driver.findElement(By.xpath("//span[@class='hidden-480']")).click();

        WebElement drobdown1=driver.findElement(By.xpath("//select[@name='IDHotel']"));
        Select select=new Select(drobdown1);

        select.selectByVisibleText("Yildiz");
        actions.sendKeys(Keys.TAB).sendKeys("23546")
                .sendKeys(Keys.TAB)
                .sendKeys("Double with child").sendKeys(Keys.TAB)
                .sendKeys("NewYork")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        WebElement aciklamaBox=driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        aciklamaBox.sendKeys("Mutlu Tatiller");
        Thread.sleep(3000);
        WebElement priceBox=driver.findElement(By.id("Price"));
        WebElement dortyuz=driver.findElement(By.linkText("400"));
        actions.dragAndDrop(dortyuz,priceBox).perform();


        WebElement idrobdownBox2=driver.findElement(By.xpath("//select[@id='IDGroupRoomType']"));
        Select select1=new Select(idrobdownBox2);
        select1.selectByVisibleText("Double");
        WebElement yetiskinSayisi=driver.findElement(By.xpath("//input[@id='MaxAdultCount']"));
        yetiskinSayisi.sendKeys("2");
        actions.sendKeys(Keys.TAB).sendKeys("3").sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        driver.findElement(By.id("btnSubmit")).click();

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='HotelRoom was inserted successfully']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

        WebElement hotelRooms=driver.findElement(By.linkText("Hotelrooms"));
        hotelRooms.click();

        WebElement hotelRoomListYaziElementi=driver.findElement(By.xpath("(//*[text()='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(hotelRoomListYaziElementi.isDisplayed());


        WebElement cikis=driver.findElement(By.xpath("//span[@class='username username-hide-on-mobile']"));
        actions.moveToElement(cikis).perform();
        driver.findElement(By.xpath("//a[@href='/Admin/Account/Logoff']")).click();

        WebElement logindesiniz=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(logindesiniz.isDisplayed());
        System.out.println("Basarili bir sekilde cikis yaptiniz tebrikler....");
    }
}

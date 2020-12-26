package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    //1. https://www.amazon.com/ adresine gidin
    //2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
    //3. kategori dropdown'indan Books kategorisini secin
    //    arama kutusuna history yazdirip aratin
    //4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         //1. https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void webDogrula(){
        SoftAssert softAssert=new SoftAssert();
        //2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
        String actualTitle=driver.getTitle();
        String extedLogo="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        softAssert.assertEquals(actualTitle,extedLogo,"Amazondasiniz");
        //3. kategori dropdown'indan Books kategorisini secin

        WebElement drobDown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(drobDown);
        select.selectByVisibleText("Books");

        //    arama kutusuna history yazdirip aratin
        WebElement searcBox=driver.findElement(By.xpath("//input[@type='text']"));
        searcBox.sendKeys("history"+ Keys.ENTER);

        //4. cikan kitaplardan 2. ve 5. kitabin isminde History kelimesinin gectigini dogrulayin
        WebElement ikinciKitap=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        WebElement besinciKitap=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]"));

        softAssert.assertTrue(ikinciKitap.getText().contains("History"),"History iceriyor");
        softAssert.assertTrue(besinciKitap.getText().contains("History"),"History iceriyor");

        //5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        WebElement sonucSayisi=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucSayisi.getText());








        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}

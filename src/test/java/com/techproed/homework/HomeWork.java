package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class HomeWork {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test (priority = 1)

    public void sign(){
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

    }
    @Test (priority = 2)
    public void userName(){
        //3. Login kutusuna “username” yazin
        WebElement userName=driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");
    }
    @Test (priority = 3)
    public void pass(){
        //4. Password kutusuna “password.” yazin
        WebElement password=driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
    }
    @Test (priority = 4)
    public void sigup(){
        //5. Sign in tusuna basin
        WebElement signClick=driver.findElement(By.xpath("//input[@type='submit']"));
        signClick.click();
    }
    @Test (priority = 5)
    public void payBills(){
        //Pay Bills sayfasina gidin
        WebElement bybills=driver.findElement(By.linkText("Pay Bills"));
        bybills.click();
    }
    @Test (priority = 6)
    public void sec(){
        //7. “Purchase Foreign Currency” tusuna basin
        WebElement purcForCur=driver.findElement(By.linkText("Purchase Foreign Currency"));
        purcForCur.click();
    }
    @Test (priority = 7)
    public void dropDowv(){
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='pc_currency']"));

        Select select=new Select(dropDown);
        select.selectByValue("EUR");
    }
    @Test (priority = 8)
    public void amountGir(){
        //“amount” kutusuna bir sayi girin
        WebElement amount=driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("120");
    }
    @Test (priority = 9)
    public void radio1(){
        // “US Dollars” in secilmedigini test edin
        WebElement radioDiollars=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertTrue(!radioDiollars.isSelected());
        System.out.println("Dollar Radio Secili Degil");
        }
        @Test (priority = 10)
        public void radio2(){
        //11. “Selected currency” butonunu secin
            driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        }
        @Test (priority = 11)
        public void CalCots(){
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
            driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
            driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        }
        @Test (priority = 12)
        public  void sonuc(){
        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
            WebElement frocurca=driver.findElement(By.xpath("//div[@id='alert_content']"));
            Assert.assertTrue(frocurca.isDisplayed());
            System.out.println("Yazi Gorunuyor");

        }

    @AfterClass
    public void tearDown(){
        driver.close();
    }





}

package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D14_MosueActions3 extends TestBase {


    @Test
    public void test(){
        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement beklegor=driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
        actions.moveToElement(beklegor).perform();//moveToElement farenin elemnt uzerinde beklemesini saglar

        WebElement createListLink=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(createListLink).perform();
        WebElement yourList=driver.findElement(By.xpath("//div[@role='heading']"));

        Assert.assertEquals(yourList.getText(),"Your Lists");
    }




}

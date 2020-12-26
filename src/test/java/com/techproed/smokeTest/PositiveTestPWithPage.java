package com.techproed.smokeTest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestPWithPage extends TestBase {

    @Test
    public void test(){
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        //1) com.techproed altinda bir package olustur : smoketest
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //     http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        //    login butonuna bas
        crsytalHotelPage.login.click();
        //test data username: manager ,
        crsytalHotelPage.usernameBox.sendKeys("manager");
        //test data password : Manager2!
        crsytalHotelPage.passtextBox.sendKeys("Manager2!");
        crsytalHotelPage.loginTik.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    }





}

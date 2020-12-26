package com.techproed.smokeTest;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test(){
        //    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
        //      3 Farkli test Methodunda 3 senaryoyu test et
        //  - yanlisSifre
        //  - yanlisKulllanici
        //  - yanlisSifreKullanici
        //2) http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.login.click();
        crsytalHotelPage.usernameBox.sendKeys("manager");
        crsytalHotelPage.passtextBox.sendKeys("manager");


        //            3) Login butonuna bas
        crsytalHotelPage.loginTik.click();
        //4) Verilen senaryolar ile giris yapilamadigini test et

    }


}

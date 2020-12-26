package com.techproed.tests;

import com.techproed.pages.CrsytalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class D20_CrystalPOM extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get(ConfigReader.getProperty("c_url"));
        CrsytalHotelPage crsytalHotelPage=new CrsytalHotelPage(driver);
        crsytalHotelPage.login.click();
        crsytalHotelPage.usernameBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crsytalHotelPage.passtextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crsytalHotelPage.loginTik.click();
        Thread.sleep(5000);


    }
}

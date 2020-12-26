package com.techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.plugin.javascript.navig.Link;

public class CrsytalHotelPage {

    WebDriver driver;

    public CrsytalHotelPage(WebDriver driver){

        this.driver=driver;

        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Log in")
    public WebElement login;
    @FindBy(id = "UserName")
    public WebElement usernameBox;
    @FindBy(id = "Password")
    public WebElement passtextBox;
    @FindBy(id = "btnSubmit")
    public WebElement loginTik;
}


package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_Amazon_SimpleDropdowns {
    WebDriver driver;

    @BeforeMethod
    public void setupTest() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
     public void simpleDropDownTest(){
        driver.get("https://www.amazon.com/");

        Select simpleDropDown= new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));

        WebElement currentlySelectedOption = simpleDropDown.getFirstSelectedOption();
        String actualSimpleDropdownText=currentlySelectedOption.getText();
        System.out.println("actualSimpleDropdownText = " + actualSimpleDropdownText);
        String expectedSimpleDropdownText="All Departments";
        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText,"dropbox error");



    }
}


//select[@id='searchDropdownBox']
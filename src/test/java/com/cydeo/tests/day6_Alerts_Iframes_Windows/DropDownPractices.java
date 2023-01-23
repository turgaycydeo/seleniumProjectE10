package com.cydeo.tests.day6_Alerts_Iframes_Windows;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractices {
 public WebDriver driver;

    @BeforeMethod

    public void setUpMethod(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

            }

    @Test

    public void Test1Method() throws InterruptedException {

        Select stateDropdownMenu=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdownMenu.selectByIndex(14);
        Thread.sleep(1000);

        stateDropdownMenu.selectByValue("VA");

        Thread.sleep(1000);

        stateDropdownMenu.selectByVisibleText("California");

        Thread.sleep(1000);


    }

    @Test

    public void Test2Method() throws InterruptedException {
    Select yearDropdownMenu= new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Thread.sleep(1000);
    yearDropdownMenu.selectByValue("1924");
        Thread.sleep(1000);
    Select monthDropdownMenu= new Select(driver.findElement(By.xpath("//select[@id='month']")));
    monthDropdownMenu.selectByVisibleText("December");
        Thread.sleep(1000);

    Select dayDropdownMenu= new Select(driver.findElement(By.xpath("//select[@id='day']")));
    dayDropdownMenu.selectByIndex(0);
        Thread.sleep(1000);

        String actualYear = yearDropdownMenu.getFirstSelectedOption().getText();
        String expectedYear = "1924";
        Assert.assertEquals(actualYear,expectedYear);

        String actualMonth = monthDropdownMenu.getFirstSelectedOption().getText();
        String expectedMonth = "December";
        Assert.assertTrue(actualMonth.equals(expectedMonth));

        String actualDay = dayDropdownMenu.getFirstSelectedOption().getText();
        String expectedDay = "1";
        Assert.assertEquals(actualDay,expectedDay);

    }

    @Test

    public void Test3Method() throws InterruptedException {

      WebElement websiteDropdownMenu= driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
      websiteDropdownMenu.click();
      Thread.sleep(1000);
      WebElement google= driver.findElement(By.linkText("Facebook"));
      google.click();
      String actualTitle=driver.getTitle();
      String expectedTitle="Facebook - Log In or Sign Up";
      Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test

    public void Test4(){
        Select stateDropdownMenu=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        List<WebElement> allOptions= stateDropdownMenu.getOptions();
        for (WebElement each : allOptions) {
            System.out.println( each.getText());

        }
    }



@AfterMethod
    public void ruinMethod(){
        driver.close();

            }

        }






/*
#5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)

Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number

 */
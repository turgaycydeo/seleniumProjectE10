package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //WebDriver driver= WebDriverFactory.getDriver("chrome");


        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement logInBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));

        logInBox.sendKeys("incorrect username");

        WebElement resetPasswordButton = driver.findElement(By.xpath("//button[@value='Reset password']"));

        resetPasswordButton.click();

        WebElement errorLabel = driver.findElement(By.cssSelector("div[class='errortext']"));

        String actualErrorLabelText = errorLabel.getText();
        String expectedErrorLabelText = "Login or E-mail not found";

        if (actualErrorLabelText.equals(expectedErrorLabelText)) {
            System.out.println("Error Label Test PASSED");
        } else {
            System.out.println("Error Label Test FAILED");
        }
    }


}



/*

TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */
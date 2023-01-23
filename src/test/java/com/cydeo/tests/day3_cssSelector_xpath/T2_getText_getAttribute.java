package com.cydeo.tests.day3_cssSelector_xpath;


import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
      WebDriver driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();

        /* WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.com");*/


       //2- Go to: https://login1.nextbasecrm.com/

     driver.get("https://login1.nextbasecrm.com/");



        //3- Verify “remember me” label text is as expected:

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabelText = rememberMeLabel.getText();
        String expectedRememberMeLabelText="Remember me on this computer";

        if (actualRememberMeLabelText.equals(expectedRememberMeLabelText)){
            System.out.println("Label verification PASSED!");
        }else{
            System.out.println("Label verification FAILED!!!");
        }


        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLinkText = forgotPasswordLink.getText();

        String expectedForgotPasswordLinkText="Forgot your password?";
        if (actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)){
            System.out.println("Forgot password link verification PASSED!");
        }else {
            System.out.println("actualForgotPasswordLinkText = " + actualForgotPasswordLinkText);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgotPasswordLinkText);

            System.out.println("Forgot password link verification FAILED!!!");
        }


        String expectedInHref="forgot_password=yes";
        String actualHrefAttributeValue=forgotPasswordLink.getAttribute("href");
        System.out.println("actualHrefAttributeValue = " + actualHrefAttributeValue);

        if (actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF attribute value verification passed");}
        else System.out.println("HREF attribute value verification FAILED");

        }

    }



        /*



        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordLinkText = "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordLinkText = forgotPasswordLink.getText();

        if (actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)){
            System.out.println("Forgot password link verification PASSED!");
        }else {
            System.out.println("actualForgotPasswordLinkText = " + actualForgotPasswordLinkText);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgotPasswordLinkText);

            System.out.println("Forgot password link verification FAILED!!!");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref = "forgot_password=yes";
        String actualHrefAttributeValue = forgotPasswordLink.getAttribute("href");

        System.out.println("actualHrefAttributeValue = " + actualHrefAttributeValue);

        if (actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF attribute value verification PASSED!");
        }else{
            System.out.println("HREF attribute value verification FAILED!!!");
        }

     */











/*

TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
 */
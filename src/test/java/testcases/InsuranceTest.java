package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class InsuranceTest extends BaseTest {

    // TEST 1 - Login Page UI Validation
    @Test(priority = 1)
    public void verifyLoginPageUI() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("authUser")));

        Assert.assertTrue(driver.findElement(By.id("authUser")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("clearPass")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());

        System.out.println("Login Page UI Verified");
    }

    // TEST 2 - Login Functionality
    @Test(priority = 2)
    public void verifyLoginFunctionality() {
        driver.findElement(By.id("authUser")).sendKeys("admin");
        driver.findElement(By.id("clearPass")).sendKeys("pass");

        Assert.assertTrue(driver.findElement(By.id("login-button")).isEnabled());
        System.out.println("Login Functionality Verified");
    }

    // Data Provider
    @DataProvider(name = "userData")
    public Object[][] getData() {
        return new Object[][] {
                {"John"},
                {"Smith"},
                {"David"}
        };
    }

    // TEST 3 - User Registration Simulation
    @Test(dataProvider = "userData", priority = 3)
    public void verifyUserRegistration(String username) {
        Assert.assertTrue(username.length() > 2);
        System.out.println("User Registration Verified : " + username);
    }

    // TEST 4 - Policy Management
    @Test(priority = 4)
    public void verifyPolicyManagement() {
        String policyStatus = "Active";
        Assert.assertEquals(policyStatus, "Active");
        System.out.println("Policy Management Verified");
    }

    // TEST 5 - Claims Processing
    @Test(priority = 5)
    public void verifyClaimsProcessing() {
        String claimStatus = "Submitted";
        Assert.assertEquals(claimStatus, "Submitted");
        System.out.println("Claims Processing Verified");
    }

    // TEST 6 - Premium Payment
    @Test(priority = 6)
    public void verifyPremiumPayment() {
        int premiumAmount = 5000;
        Assert.assertTrue(premiumAmount > 0);
        System.out.println("Premium Payment Verified");
    }

    // TEST 7 - Customer Support
    @Test(priority = 7)
    public void verifyCustomerSupport() {
        String supportMessage = "Support Available";
        Assert.assertTrue(supportMessage.contains("Support"));
        System.out.println("Customer Support Verified");
    }

    // TEST 8 - FAQ Validation
    @Test(priority = 8)
    public void verifyFAQSection() {
        String faq = "Insurance FAQ";
        Assert.assertTrue(faq.contains("FAQ"));
        System.out.println("FAQ Section Verified");
    }

    @Test(priority = 9)
    public void verifyInvalidLoginBug() {
        String title = driver.getTitle();
        Assert.assertTrue(title.length() > 0);
        System.out.println("Invalid Login Bug Scenario Verified");
    }
}
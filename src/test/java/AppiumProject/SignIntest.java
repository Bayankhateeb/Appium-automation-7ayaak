package AppiumProject;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

@Test 
public class SignIntest extends BasicTest {
	 public void SignusingMobileNumber()  throws MalformedURLException, InterruptedException{
		 
		// Wait for the Next button to appear and click it
		 WebElement nextButton = driver.findElement(By.id("com.example.app:id/sign_in_button"));
		 nextButton.click();

	        // Wait for the mobile number field to appear and enter the mobile number
	        WebElement mobileNumberField = driver.findElement(By.id("com.example.app:id/mobile_number_field"));
	        mobileNumberField.sendKeys("799186954");

	        // Tap on the next button
	        WebElement nextButton1 = driver.findElement(By.id("com.example.app:id/next_button"));
	        nextButton1.click();

	        // Simulate waiting for OTP verification
	        TimeUnit.SECONDS.sleep(10);

	        // Enter the OTP verification code
	        WebElement otpField = driver.findElement(By.id("com.example.app:id/otp_field"));
	        otpField.sendKeys("12345"); // Replace with the actual OTP code
	     // Wait for the home page to load
	        WebElement homePageTitle = driver.findElement(By.id("com.example.app:id/title_name"));
	        
	        // Assert the title name
	        String expectedTitle = "Tasks";
	        String actualTitle = homePageTitle.getText();
	        if (actualTitle.equals(expectedTitle)) {
	            System.out.println("Title name assertion passed.");
	        } else {
	            System.out.println("Title name assertion failed. Expected: " + expectedTitle + ", Actual: " + actualTitle);
	        }
	       // or Assert.assertEquals(actualTitle, "Tasks");

		 
		 
	
	
	
	
	
	
	
	
	
	
	 }
}


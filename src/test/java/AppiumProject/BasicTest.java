package AppiumProject;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BasicTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass 
	public void ConfigureAppium() throws MalformedURLException {
		
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\bayan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				 .withIPAddress("127.0.0.1").usingPort(4723).build();
		 service.start();
				 
		 
		 
		 
		 UiAutomator2Options options = new UiAutomator2Options();
		 options.setDeviceName("Bayanemualter");
		 options.setApp("C:\\Users\\bayan\\eclipse-workspace\\7ayyak\\src\\test\\java\\resources\\Expo_2.29.3_Apkpure.apk");
		 driver =new AndroidDriver(new URL("http://127.0.0.1:4723"), options ); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	//Scrolldown at calendar 
 public void scrollToEndAction() {
		 
		 boolean canScrollMore;
		 do
		 {
	  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			 "left", 100, "top", 100, "width", 200, "height", 200,
			 "direction", "down",
			 "percent", 3.0));  // No prior idea just keep scrolling 
		 } while (canScrollMore);
		 
		 
	 }
	
	
		@AfterClass
		public void tearDown(){
			 driver.quit();
			 service.stop();
		}
}

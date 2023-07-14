package AppiumProject;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

@Test 
public class Calendartest extends BasicTest {
	 public void AppointmentPage()  throws MalformedURLException{
		 
		// Locate the appointment icon element and click on it
		 WebElement appointmentIcon = driver.findElement(AppiumBy.accessibilityId(null));
	        appointmentIcon.click();

	        // Wait for the calendar screen to load (add appropriate wait strategy here)
	        
	        // Verify navigation to the calendar
	        String Title= driver.findElement(By.id("android:id/Title")).getText();
        	Assert.assertEquals(Title, "Appointment");
        	//or
	        WebElement calendarElement = driver.findElement(AppiumBy.accessibilityId(null));
	        if (calendarElement.isDisplayed()) {
	            System.out.println("Successfully navigated to the calendar!");
	        } else {
	            System.out.println("Failed to navigate to the calendar.");
	        }
	        
	        

	        
	 }
		 
		 
		 public void calendardate () {
			// Get today's date

			 LocalDate today = LocalDate.now();
	         String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	         // Find the calendar element and select today's date
	         WebElement calendarElement1 = driver.findElement(AppiumBy.id("calendar_element_id")); 
	         calendarElement1.sendKeys(formattedDate);
			 
		 
			
         
         // Find the appointment card element using

			driver.findElement(By.xpath("//android.widget.Button[@content-desc= Thursday 13 July 2023'']/android.widget.TextView"
)).click();
			WebElement appointmentCard = driver.findElement(By.className("appointment-card"));

	        // Check if the appointment card is present
	        if (appointmentCard != null && appointmentCard.isDisplayed()) {
	            System.out.println("Appointment card is present");
	        } else {
	            System.out.println("There is no appointment");
	        	String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
	        	Assert.assertEquals(alertTitle, "There is no Appointment");

	        }
	        
			driver.findElement(By.xpath("//android.widget.Button[@content-desc= Thursday 12 July 2023'']/android.widget.TextView"
)).click();
		 
}




			public void AppointmentCard () {
				
	
		 //  confirmedAppointmentCard to checked-in
			WebElement  confirmedAppointmentCard = driver.findElement(AppiumBy.id("confirmed_appointment_card_id")); 
	            confirmedAppointmentCard.click();

	            // Find the Checked-In button on the appointment details page
	            WebElement checkedInButton = driver.findElement(AppiumBy.id("checked_in_button_id")); 
	             checkedInButton.click();
	             driver.findElement(AppiumBy.id("confirm_button_id")).click();
	             String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		        	Assert.assertEquals(alertTitle, "Successfully Checked In !");
		            // Update the status to Checked In

		        	WebElement statusElement = driver.findElement(AppiumBy.id("status_element_id")); 
		            statusElement.clear();
		            statusElement.sendKeys("Checked In");
		            
		            
	        // Checked In to Checked out
		            
		         // Find the "Checked In" appointment card and click on it
		            WebElement checkedInAppointmentCard = driver.findElement(AppiumBy.id("checked_in_appointment_card_id")); 
		            checkedInAppointmentCard.click();

		            // Find the field to enter the amount value on the appointment details page
		            WebElement amountField = driver.findElement(AppiumBy.id("amount_field_id")); 
		            //  enter the amount value
		            amountField.sendKeys("100.00");
		         // Find and click on the "Submit" button
		            WebElement submitButton = driver.findElement(AppiumBy.id("submit_button_id")); 
		            submitButton.click();

		            // Verify the presence of the modal with text and buttons
		            WebElement modalText = driver.findElement(AppiumBy.id("modal_text_id")); 
		            
		            // ask  about assertion title having variable name changed based on appointment name
//		            String alertTitle1= driver.findElement(By.id("android:id/alertTitle")).getText();
//		        	Assert.assertListContains(alertTitle1, "Successfully Checked In !");
		            WebElement modalButton1 = driver.findElement(AppiumBy.id("modal_button1_id")); 
		            WebElement modalButton2 = driver.findElement(AppiumBy.id("modal_button2_id")); 

		            if (modalText.isDisplayed() && modalButton1.isDisplayed() && modalButton2.isDisplayed()) {
		                System.out.println("Modal with text and buttons is displayed");
		            } else {
		                System.out.println("Modal with text and buttons is not displayed");
		            }
		         // Find and click on the "Yes, Confirm" button
		            WebElement confirmButton = driver.findElement(AppiumBy.id("confirm_button_id")); // Replace with the actual ID of the "Yes, Confirm" button
		            confirmButton.click();

		            // Update the status to "Checked out" in the appointment card
		            WebElement appointmentCard = driver.findElement(AppiumBy.id("appointment_card_id")); 
		             String updatestatusCheckedout = appointmentCard.findElement(AppiumBy.id("status_id")).getText();
			        	Assert.assertEquals(updatestatusCheckedout , "Checked out");


		           
		   // Checked out to Completed
			        	
			        	// Find the "Checked out" appointment card and click on it
			        	WebElement checkedOutAppointmentCard = driver.findElement(AppiumBy.id("checked_out_appointment_card_id")); // Replace with the actual ID of the "Checked out" appointment card
			            checkedOutAppointmentCard.click();

			            // Find the amount value entered in the previous page
			            WebElement amountField1 = driver.findElement(AppiumBy.id("amount_field_id")); 
			            String enteredAmount = amountField1.getText();

			            // Find the buttons on the appointment details page
			            WebElement button1 = driver.findElement(AppiumBy.id("button1_id")); 
			            WebElement button2 = driver.findElement(AppiumBy.id("button2_id")); 

			            // Perform further actions with the entered amount and buttons
			            System.out.println("Entered Amount: " + enteredAmount);
			            System.out.println("Button 1 Paid " + button1.getText());
			            System.out.println("Button 2 Unpaid " + button2.getText());
			         // Find and click on the "Paid" button
			            WebElement paidButton = driver.findElement(AppiumBy.id("paid_button_id")); 			           
			            paidButton.click();
			            
			            

			            // Find the modal to confirm the payment
			            WebElement confirmModal = driver.findElement(AppiumBy.id("confirm_modal_id")); 

			            // Find and click on the "Yes, Confirm" button in the confirmation modal
			            WebElement confirmButton1 = confirmModal.findElement(AppiumBy.id("yes_confirm_button_id")); 
			            confirmButton1.click();

			            // Find the modal message for successful payment
			            WebElement successModal = driver.findElement(AppiumBy.id("success_modal_id")); 
			            String successMessage = successModal.getText();
			        	Assert.assertEquals(successMessage, "Successfully Paid");

			            // or Print the success message
			            System.out.println("Success Message: " + successMessage);
			            
			            // update status from Checked out to Completed 
			            WebElement appointmentCard1 = driver.findElement(AppiumBy.id("appointment_card_id")); 
			             String updatestatusCompleted = appointmentCard1.findElement(AppiumBy.id("status_id")).getText();
				        	Assert.assertEquals(updatestatusCompleted , "Completed");      
		            
		            // or 
//				        	WebElement appointmentCard1 = driver.findElement(AppiumBy.id("appointment_card_id")); 
//				             appointmentCard1.findElement(AppiumBy.id("status_id")).setText("Completed"); 

		            
				        // Scroll down and refresh 
			
				        		 
				        		 
			
		
			}
			
			
			
			public void scrolldowncalndar () {
				WebElement appointmentIcon = driver.findElement(AppiumBy.accessibilityId(null));
	    	     
	    		appointmentIcon.click();
				scrollToEndAction();
			}
			 
				
     	      
				 
				 
				 
			 
			
							public void RefreshCalendarPage() {
				     	  		WebElement appointmentIcon = driver.findElement(AppiumBy.accessibilityId(null));
				    	        appointmentIcon.click();
				    	        WebElement calendarElement = driver.findElement(AppiumBy.accessibilityId(null));
					             driver.navigate().refresh();
					             WebElement pageTitleElement = driver.findElement(AppiumBy.accessibilityId(null));
					             if (pageTitleElement.getText().equals("New Page Title")) {
					                 System.out.println("Page successfully refreshed!");
					             } else {
					                 System.out.println("Failed to refresh the page.");
					             }
				     	  

				        		 
				        	
				        	
				        	
				        	
				     	  	  	
				        	
	        }}
		 
		 
		 
	 
//		driver.findElement(null) 
	
		
	
	




	
		
	
		 
		 
		 

	
	
	
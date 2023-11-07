package modelaccessibletest.modelaccessibletest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


		
		
//		Public void testLabel(Element,Label) {
//			
//		}
//	
		public class allTestcase {

		    private WebDriver driver;

		    public allTestcase(WebDriver driver) {
		        this.driver = driver;
		    }

		    public void checkRolesandAttribute(WebElement modalElement, String expectedRole , String IssueDescription, String attribute) {
			

		        String actualRole = modalElement.getAttribute(attribute);
		        Assert.assertEquals(actualRole, expectedRole);
		    }
		    
		    
		    // Separate method for closing the model with ESCAPE key and asserting
		    
		    private void closeModelWithEscapeKey(WebElement addDeliveryCloseModal) {
		        Actions actions = new Actions(driver);
		        actions.sendKeys(addDeliveryCloseModal, Keys.ESCAPE).perform();

		        // Assert that the modal is closed
		        boolean isModalClosed = !addDeliveryCloseModal.isDisplayed();
		        Assert.assertTrue(isModalClosed, "The modal should be closed");
		    }
		}
//		    public void closeModelWithEscapeKey(WebElement addDeliveryCloseModal,String IssueDescription) {
//		        Actions actions = new Actions(driver);
//		        actions.sendKeys(addDeliveryCloseModal, Keys.ESCAPE).perform();
//		      
//		        boolean isModalClosed = !addDeliveryCloseModal.isDisplayed();
//		        Assert.assertTrue(isModalClosed);
//		    }
		   
		
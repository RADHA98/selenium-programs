package modelaccessibletest.accessibleDialogTest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import modelaccessibletest.modelaccessibletest.WAIpageopen;
import modelaccessibletest.modelaccessibletest.WaiMethod;

public class DialogTest {

	private WebDriver driver;
	DialogPage DialogPage = new DialogPage(driver);
	AssertDialog AssertDialog= new AssertDialog(driver);
	
	 @BeforeTest
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/dialog-modal/examples/dialog/");
	        DialogPage = new DialogPage(driver);
	        AssertDialog = new AssertDialog(driver);
	    }

	@Test(priority = 1)
	public void testModalWithRole() {
		WebElement addressbtn = DialogPage .GetAddressButton();
		addressbtn.click();
		WebElement addDelivaryModal = DialogPage .GetAddDelivaryModal();
		AssertDialog.checkRolesandAttribute(addDelivaryModal,"dialog","role is not match","role");
		WebElement cancelbtn = DialogPage.GetCancelBtn();
		cancelbtn.click();
	}

	
	@Test(priority = 2)
	public void checkModelWithAriaLabelledBy() {
		
		WebElement addressbtn =DialogPage.GetAddressButton();
		addressbtn.click();
		WebElement checkModelAriaLabelledBy = DialogPage.GetAddDelivaryModal();
		AssertDialog.checkRolesandAttribute(checkModelAriaLabelledBy,"dialog1_label","Element's aria-labelledby attribute is incorrect","aria-labelledby");
		WebElement cancelbtn = DialogPage.GetCancelBtn();
		cancelbtn.click();
	}		

		@Test(priority = 3)
		public void closeModelWithEscapeKey() {
			
			WebElement addDeliveryCloseModal = DialogPage.GetAddDelivaryModal();

			WebElement addressbtn = DialogPage.GetAddressButton();
			addressbtn.click();
			AssertDialog.checkModelIsClosedEsc(addDeliveryCloseModal , Keys.ESCAPE ,"model is not displayed");
			
		}
		
		@Test(priority = 4)
		public void testFirstElementIsFocused() {
		    
		    WebElement addressbtn = DialogPage.GetAddressButton();
		    addressbtn.click();
		    WebElement street =DialogPage.EnterStreet();
		    WebElement activeElement = driver.switchTo().activeElement();
		    AssertDialog.checkFirstElementReceiveFocus(activeElement, street, "Focus is not on the first element.");

		    WebElement cancelbtn = DialogPage.GetCancelBtn();
		    cancelbtn.click();
		}

		
		@Test(priority = 6)
		public void testModelIsCloseCheckfocusIsInvolkingElement() throws InterruptedException {
		   
		    WebElement addressbtn = DialogPage.GetAddressButton();
		    addressbtn.click();
		    WebElement addDeliveryCloseModal = DialogPage.GetAddDelivaryModal();

		    WebElement cancelbtn = DialogPage.GetCancelBtn();
		    cancelbtn.click();

	   AssertDialog.checkFocusIsInvokingElement(addressbtn,  null, "Model is not closed", driver);
		
		}
		
		@Test(priority = 5)
		public void testFocusMaintainInModal() throws InterruptedException {
		  
		    WebElement addressbtn = DialogPage.GetAddressButton();
		    addressbtn.click();
		    WebElement modalId = DialogPage.GetAddDelivaryModal();
		    String Model = modalId.getAttribute("id");

		    String interactiveElementXPath = "//*[@id='" + Model
		            + "']//*[self::a[@href] or self::area[@href] or self::input[not(@disabled)] or self::select[not(@disabled)] or self::textarea[not(@disabled)] or self::button[not(@disabled)] or @tabindex='0']";

		    List<WebElement> allInteractiveElements = driver.findElements(By.xpath(interactiveElementXPath));

		    if (!allInteractiveElements.isEmpty()) {
		        int elementCount = allInteractiveElements.size();
		        WebElement firstInteractiveElement = allInteractiveElements.get(0);
		        WebElement lastInteractiveElement = allInteractiveElements.get(elementCount - 1);

		        
		        AssertDialog.performFocusMaintenance(firstInteractiveElement, lastInteractiveElement, Keys.TAB, Keys.SHIFT, elementCount);

		    } else {
		        System.out.println("No interactive elements found in the modal.");
		    }

		    WebElement cancelbtn = DialogPage.GetCancelBtn();
		    cancelbtn.click();
		}
	

			
	@AfterTest
	private void closeChromeBroswer() {
		driver.quit();
	}
}

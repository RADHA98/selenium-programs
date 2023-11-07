package modelaccessibletest.accessibleDialogTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AssertDialog {

	private WebDriver driver;

	public AssertDialog(WebDriver driver) {
		this.driver = driver;
	}

	public void checkRolesandAttribute(WebElement modalElement, String expectedRole, String issueDescription, String attribute) {	
		String actualRole = modalElement.getAttribute(attribute);
		Assert.assertEquals(actualRole, expectedRole);
	}

	public void checkModelIsClosedEsc(WebElement addDeliveryCloseModal, Keys escape, String description) {
		Actions actions = new Actions(driver);
		actions.sendKeys(escape).build().perform();
		Assert.assertFalse(addDeliveryCloseModal.isDisplayed());
	}

	public void checkFirstElementReceiveFocus(WebElement activeElement, WebElement street, String description) {
		Assert.assertEquals(activeElement, street, description);
	}

	public void checkFocusIsInvokingElement(WebElement elementToCheckFocus, Keys cancel, String description,
			WebDriver driver) {
		WebElement activeElement = driver.switchTo().activeElement();
		boolean isFocusOnElement = activeElement.equals(elementToCheckFocus);
		Assert.assertTrue(isFocusOnElement, description);
	}

	public void performFocusMaintenance(WebElement firstElement, WebElement lastElement, Keys tabKey, Keys shiftTabKey,
			int elementCount) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(firstElement).sendKeys(tabKey).perform();
		for (int i = 1; i < elementCount; i++) {
			actions.sendKeys(tabKey).perform();
			Thread.sleep(2000);
		}
		actions.keyDown(Keys.SHIFT).sendKeys(shiftTabKey).keyUp(Keys.SHIFT).perform();
	}
}

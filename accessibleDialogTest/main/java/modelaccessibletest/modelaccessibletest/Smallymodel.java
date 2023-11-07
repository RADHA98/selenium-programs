package modelaccessibletest.modelaccessibletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Smallymodel {

	WebDriver driver;

	public Smallymodel(WebDriver d) {
		driver = d;
	}

	By openmodelInlineerrorbtn = By.xpath("//*[@id=\"root\"]/div[1]/button[1]");
	By openmodel = By.xpath("*[@id=\"modal_1-modal-control\"]");

	// model element
	By closebtn = By.xpath("//*[@id=\"modal_1-modal-control\"]/div/div[1]/button");
	By firstname = By.xpath("//*[@id=\"modal_1-first-name-control\"]");
	By lastname = By.xpath("//*[@id=\"modal_1-last-name-control\"]");
	By Email = By.xpath("//*[@id=\"modal_1-email-control\"]");
	By submitbtn = By.xpath("//*[@id=\":r1:\"]/button");

	public WebElement GetopenmodelInlineerrorButton() {
		System.out.println(openmodelInlineerrorbtn);
		return driver.findElement(openmodelInlineerrorbtn);
	}

	public WebElement openmodel() {
		return driver.findElement(openmodel);
	}

//			model element
	public WebElement GetcloseButton() {
		return driver.findElement(closebtn);
	}

	public WebElement EnterFirstName() {
		return driver.findElement(firstname);
	}

	public WebElement EnterLastName() {
		return driver.findElement(lastname);
	}

	public WebElement EnterEmail() {
		return driver.findElement(Email);
	}

	public WebElement GetSubmitButton() {
		return driver.findElement(submitbtn);
	}
}

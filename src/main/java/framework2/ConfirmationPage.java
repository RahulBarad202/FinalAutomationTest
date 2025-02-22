package framework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponentss {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
    }

	@FindBy(id="finish")
	WebElement FinishButton;
	public void clickFinishButton() {
		//	driver.findElement(By.id("finish")).click();
		FinishButton.click();
	}
	@FindBy(css=".complete-header")
	WebElement confirmMsg;
	
	public String verifyOrderCinfirmMessage() {
		clickFinishButton();
		confirmMsg.getText();
		return confirmMsg.getText();
		}
}

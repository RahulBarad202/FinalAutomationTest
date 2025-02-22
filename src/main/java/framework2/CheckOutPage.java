package framework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponentss{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
    this.driver=driver;
    PageFactory.initElements(driver, this);

	}
	/*driver.findElement(By.id("first-name")).sendKeys("John");
	driver.findElement(By.id("last-name")).sendKeys("Week");
	driver.findElement(By.id("postal-code")).sendKeys("456456");
	driver.findElement(By.id("continue")).click();*/

	@FindBy(id="first-name")
	WebElement FirstName;
	@FindBy(id="last-name")
	WebElement LastName;
	@FindBy(id="postal-code")
	WebElement PostalCode;
	@FindBy(id="continue")
	WebElement ContinueButton;
	
	public ConfirmationPage checkoutInformationPage() {
		FirstName.sendKeys("Jonh");
		LastName.sendKeys("Park");
		PostalCode.sendKeys("411052");
		ContinueButton.click();
		
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		return confirmpage;
	}
	
}

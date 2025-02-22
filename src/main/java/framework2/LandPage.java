package framework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class LandPage extends AbstractComponentss{
//java page object which contains constructor locators and methods
	WebDriver driver;
	//constructor
	public LandPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);//here driver
	}
	
	/*public void goTOUrl() {
		driver.get("https://www.saucedemo.com/inventory.html");
	   
		
	}*/
	//locators
	@FindBy(id="user-name")//it means .findElement
	WebElement Username;
	@FindBy(id="password")
	WebElement Password;
	@FindBy(id="login-button")
	WebElement Login;
	//action Method
	
	
	/*public ProductPage loginPage(String un, String pw) {
		
		Username.sendKeys(un);
		Password.sendKeys(pw);
		Login.click();
		ProductPage productpageObj=new ProductPage(driver);
		return productpageObj;
	}*/
public ProductPage loginPage(String un, String pw) {
		
		Username.sendKeys(un);
		Password.sendKeys(pw);
		Login.click();
		ProductPage productpageObj=new ProductPage(driver);
		return productpageObj;
	}


	
}

package framework2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponentss  {
   WebDriver driver;
	public AbstractComponentss(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//here driver
	}
	
	
@FindBy(xpath="//span[@class='shopping_cart_badge']")
WebElement cartHeader;
	public void goToCartPage() {
		//driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		cartHeader.click();
	}
	
	public void visiblityOfElementLocated (By findby) {
		 WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		 w.until(ExpectedConditions.visibilityOfElementLocated(findby));
			
	}
}
	


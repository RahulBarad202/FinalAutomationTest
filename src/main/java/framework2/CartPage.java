package framework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponentss{

	WebDriver driver;
	public CartPage(WebDriver driver) {
				super(driver);
				this.driver=driver;
				PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item_name")
	List<WebElement> cartProductList;
	public boolean verifyCartProducts(String productName) {
		
		
		boolean match=cartProductList.stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
        return match;

	}
	@FindBy(id="checkout")
	WebElement CheckoutButton;
	//By CheckoutButtons=By.id("checkout");
	public CheckOutPage gotoCheckOutPage() {
		//driver.findElement(By.id("checkout")).click();
		//driver.findElement(CheckoutButtons);//By locator
		CheckoutButton.click();
		CheckOutPage checkoutpage=new CheckOutPage(driver);
		return checkoutpage;
	}

}

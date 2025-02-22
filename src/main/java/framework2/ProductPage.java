package framework2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponentss{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".inventory_item_description")
	List<WebElement> productlist; 
	
	public WebElement getProductName(String productName) {
	
		List<WebElement> productlist=driver.findElements(By.cssSelector(".inventory_item_description"));	
		
	WebElement MyProduct=productlist.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name")).getText()
			.equalsIgnoreCase(productName)).findFirst().orElse(null);
    return MyProduct;
	}
	
	By addtocart=By.cssSelector("div[class='pricebar'] button");
	
	//MyProduct.findElement(By.cssSelector("div[class='pricebar'] button")).click();//addtocartbutn clicked
	public CartPage addToCartButton(String productName ) {
		WebElement MyProduct=getProductName(productName);
		MyProduct.findElement(addtocart).click();
		CartPage cartpageobj=new CartPage(driver);
		return cartpageobj;
	}
	

}

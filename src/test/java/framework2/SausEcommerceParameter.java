package framework2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework2.testComponents.BaseClass;


public class SausEcommerceParameter extends BaseClass{
	static WebDriver driver;
	//static String productName="Test.allTheThings() T-Shirt (Red)";
	String productName;
	String Username;
	String Password;
	
	//@Test(dataProvider="getData",retryAnalyzer=RetryTest.class)
	@Test(dataProvider="getData")
	public void submitOrder(String un, String pw, String product) throws InterruptedException {
	
		// TODO Auto-generated method stub
	
		
		ProductPage productpageObj=land.loginPage(un,pw);
		Thread.sleep(2000);
		
		CartPage cartpageobj=productpageObj.addToCartButton(product);
		Thread.sleep(3000);
		cartpageobj.goToCartPage();
		
		
		
		//Cart Header
		//driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		//CartPage=verifying cart page product to our desired product.
		boolean match=cartpageobj.verifyCartProducts((product));
		Assert.assertTrue(match);//validating 
		
		//clicked on checkout btn 
		//driver.findElement(By.id("checkout")).click();
		CheckOutPage checkoutpage=cartpageobj.gotoCheckOutPage();
		//Checkout page
		ConfirmationPage confirmpage=checkoutpage.checkoutInformationPage();
		String confirmordermsg=confirmpage.verifyOrderCinfirmMessage();
		
		Assert.assertEquals(confirmordermsg, "Thank you for your order!");		
		
	}
	//Prameterized 1
	@DataProvider
	@Test
	public Object[][] getData() {
		
		//2dimensional array 2 row 3 columns
		Object[][] data= {{"standard_user","sect_sauce","Sauce Labs Onesie"},{"visual_user","secret_sauce","Sauce Labs Bike Light"}};
		
		return data;
	}
	
	
}
package framework2;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework2.testComponents.BaseClass;


public class SausEcommerceTest extends BaseClass{
	static WebDriver driver;
	//static String productName="Test.allTheThings() T-Shirt (Red)";
	String productName;
	String Username;
	String Password;
	
	@Test(dataProvider="getData")
	//for 1)public void submitOrder(String un, String pw, String product) throws InterruptedException {
	public void submitOrder(HashMap<String, String>input) throws InterruptedException {
		// TODO Auto-generated method stub
	
		
		ProductPage productpageObj=land.loginPage(input.get("email"),input.get("password"));
		Thread.sleep(2000);
		
		CartPage cartpageobj=productpageObj.addToCartButton(input.get("product"));
		Thread.sleep(3000);
		cartpageobj.goToCartPage();
		
		
		
		//Cart Header
		//driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		//CartPage=verifying cart page product to our desired product.
		boolean match=cartpageobj.verifyCartProducts(input.get("product"));
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
	//@DataProvider
	/*@Test
	public Object[][] getData() {
		
		//2dimensional array 2 row 3 columns
		Object[][] data= {{"standard_user","secret_sauce","Sauce Labs Onesie"},{"visual_user","secret_sauce","Sauce Labs Bike Light"}};
		
		return data;
	}*/
	//2nd method sending hashmap object as a parameters
	/*@DataProvider
	@Test
	
	public Object[][] getData() {
		
		//2dimensional array 2 row 3 columns key value pair
		HashMap<String, String>map=new HashMap<>();
		map.put("email", "standard_user");
		map.put("password", "secret_sauce");
		map.put("product", "Sauce Labs Onesie");
		 
		HashMap<String, String>map2=new HashMap<>();
		map2.put("email", "visual_user");
		map2.put("password", "secret_sauce");
		map2.put("product", "Sauce Labs Bike Light");
		return new Object[][] {{map},{map2}};
		
		
	}*/
	@Test
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String,String>> hashmapobjs=getjsonObject("E:\\8PMbatch\\SeleniumFrameworkDesign2\\src\\test\\java\\framework2\\data\\products.json");
	
	    return new Object[][] {{hashmapobjs.get(0)},{hashmapobjs.get(1)}};
	}
}
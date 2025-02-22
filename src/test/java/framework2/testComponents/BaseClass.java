package framework2.testComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import framework2.LandPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	 public Properties prop;
	 public LandPage land;
    public String filepath;
	
	public WebDriver initializeBrowser() throws IOException {
		 
		
		FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\framework2\\Resources\\Data.properties");
	     prop=new Properties();
	    prop.load(fin);
	    //prop.getProperty("browser");
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 return driver;
	 }
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	
	
	@BeforeMethod
	public LandPage launchApp() throws IOException {
		driver=initializeBrowser();
		 land=new LandPage(driver);
		driver.get(prop.getProperty("url"));
		//land.goTOUrl();
	    return land;
	}
	public  List<HashMap<String, String>> getjsonObject(String jsonFilePath) throws IOException {
		File f=new File(jsonFilePath);
		String jsonContent=FileUtils.readFileToString(f, StandardCharsets.UTF_8);
		//convert json to hashmap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> hashmapobjs=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return hashmapobjs;
	}
	
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		filepath=(System.getProperty("user.dir")+"\\ScreenshotFolder\\"+testcasename+".png");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filepath));
		return System.getProperty("user.dir")+"\\ScreenshotFolder\\"+testcasename+".png";
		
	}
	
}



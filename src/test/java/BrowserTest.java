import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserTest {
	
	static WebDriver driver;
	static WebElement aboutMenu,aboutOption;
    static String ExpectedResult = "Selenium is a suite of tools for automating web browsers.", ActualResult;


	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rony\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.get("http://selenium.dev/");
		driver.manage().window().maximize();
		
		aboutMenu = driver.findElement(By.xpath("//span[contains(text(),'About')]"));
		aboutOption = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(aboutMenu).click().perform();
		action.moveToElement(aboutOption).click().perform();
		
		
		ActualResult = driver.findElement(By.xpath("//p[@class='body-large']")).getText();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		driver.navigate().back();
		
		System.out.println("Expected Result : "+ ExpectedResult);
		System.out.println("Actual Result : "+ ActualResult);
		
		boolean verified = ExpectedResult.equals(ActualResult);
		
		if(verified) {
		        System.out.println("Verified :" +verified);
		}else {
			System.out.println("Verified :" +verified);
		}
	}
	
	
}
	


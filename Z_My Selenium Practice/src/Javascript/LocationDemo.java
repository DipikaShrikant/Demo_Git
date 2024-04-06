package Javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,300)");
		WebElement fromLoc = driver.findElement(By.id("fromPlaceName"));
		fromLoc.sendKeys("bang");

		String city = "return document.getElementById('fromPlaceName').value;";

		String citynm = (String) js.executeScript(city);

		while (!citynm.equalsIgnoreCase("KEMPEGOWDA INTERNATIONAL AIRPORT BANGALORE")) {
			fromLoc.sendKeys(Keys.DOWN);
			city = "return document.getElementById('fromPlaceName').value;";
			Thread.sleep(2000);

			citynm = (String) js.executeScript(city);
			Thread.sleep(2000);

		}
		fromLoc.sendKeys(Keys.ENTER);
		System.out.println(citynm);
		
		
		WebElement going = driver.findElement(By.id("toPlaceName"));
		going.sendKeys("my");
		String gotocity="return document.getElementById('toPlaceName').value;";
		
		String city2 = (String) js.executeScript(gotocity);
		
		while(!city2.equalsIgnoreCase("MYSORE")) {
			going.sendKeys(Keys.DOWN);
			gotocity="return document.getElementById('toPlaceName').value;";
			
			 city2 = (String) js.executeScript(gotocity);			
			Thread.sleep(2000);
		}
		going.sendKeys(Keys.ENTER);
		System.out.println(city2);
		driver.quit();
	}

}

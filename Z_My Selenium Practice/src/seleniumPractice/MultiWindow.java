package seleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement footer = driver.findElement(By.cssSelector("div[class=\"cb-footer cb-col-100 cb-col\"]"));

		List<WebElement> Allfooter = footer.findElements(By.tagName("a"));

		
		WebElement particular = driver.findElement(By.xpath("//div[@class=\"cb-col-25 cb-col\"][4]"));
		List<WebElement> company = particular.findElements(By.tagName("a"));
		
		for (int i = 0; i <company.size(); i++) {
			String chord = Keys.chord(Keys.CONTROL, Keys.ENTER);

			particular.findElements(By.tagName("a")).get(i).sendKeys(chord);

			Thread.sleep(2000);

		}
		
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr = allwin.iterator();
		
		while(itr.hasNext()) {
			
			driver.switchTo().window(itr.next());
			
			String title = driver.getTitle();
			System.out.println(title);
			
			if(title.equalsIgnoreCase("Privacy Policy | Cricbuzz.com\r\n")) {
				driver.findElement(By.xpath("//a[@id=\"cricbuzz-plus-main-menu\"]")).click();
			}
		}

		driver.quit();
	}

}

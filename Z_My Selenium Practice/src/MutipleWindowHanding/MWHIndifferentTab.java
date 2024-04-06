package MutipleWindowHanding;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MWHIndifferentTab {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> TotalLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links are = " + TotalLinks.size());
		
		WebElement footer = driver.findElement(By.xpath("//div[@class=\"footer-menu-wrapper\"]"));
		List<WebElement> allfooter = footer.findElements(By.tagName("a"));		
		System.out.println("Total footer links are = "+allfooter.size());
		
		WebElement particularFooter = driver.findElement(By.xpath("//div[@class=\"column information\"]"));
		List<WebElement> allInPartFooter = particularFooter.findElements(By.tagName("a"));
		int size = allInPartFooter.size();
		System.out.println("Particular footer links are = "+size);
		System.out.println();
		
		//to open multiple windows
		for(int i=1;i<size;i++) {
			String chord = Keys.chord(Keys.CONTROL,Keys.ENTER);
			particularFooter.findElements(By.tagName("a")).get(i).sendKeys(chord);
			Thread.sleep(2000);
		}
		//to switch on multiple windows 
		Set<String> allwind = driver.getWindowHandles();
		Iterator<String> itr = allwind.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			System.out.println(title);
			//to click on the particular window elelment
			if(title.contains("About Us")) {
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")).click();
			}
		}
		
		driver.quit();

	}

}

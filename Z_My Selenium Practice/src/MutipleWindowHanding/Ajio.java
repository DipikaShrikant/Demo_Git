package MutipleWindowHanding;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebElement allFooter = driver.findElement(By.className("ftr-cont"));
		List<WebElement> allft = allFooter.findElements(By.tagName("a"));
		System.out.println(allft.size());
		
		
		WebElement pFHL = driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[3]/footer/div[2]/div/div[1]/section[1]/div[2]"));
		List<WebElement> all = pFHL.findElements(By.tagName("a"));
		int count = all.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String chord = Keys.chord(Keys.CONTROL,Keys.ENTER);
			pFHL.findElements(By.tagName("a")).get(i).sendKeys(chord);
			Thread.sleep(2000);
		}
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr = allwin.iterator();
		
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			System.out.println();
		}
	}

}

package MutipleWindowHanding;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MWHInSameTab {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://msrtc.maharashtra.gov.in/GeneralPages/Home.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		WebElement footer = driver.findElement(By.xpath("//div[@class=\"main-footer-area\"]"));
		List<WebElement> allfooter = footer.findElements(By.tagName("a"));
		System.out.println(allfooter.size());

		WebElement partailfooter = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/footer/div[1]/div/div/div/div/div[1]/div/ul"));
		List<WebElement> listfooter = partailfooter.findElements(By.tagName("a"));
		int size = listfooter.size();
		Iterator<WebElement> itr = listfooter.iterator();

		System.out.println(size);
		for (int i = 1; i < size; i++) {
			String chord = Keys.chord(Keys.SHIFT, Keys.ENTER);
			partailfooter.findElements(By.tagName("a")).get(i).sendKeys(chord);
			String title = driver.getTitle();
			System.out.println(title);

			Thread.sleep(2000);
		}

		System.out.println("done");
		driver.quit();

	}

}

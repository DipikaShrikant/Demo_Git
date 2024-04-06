package RahuShettyAccademy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTabsAlerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// window Handles

		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);

		Set<String> parent = driver.getWindowHandles();
		Iterator<String> itr = parent.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
		}

		String title1 = driver.getTitle();
		System.out.println(title1);

		WebElement particularfooter = driver.findElement(By.xpath("//*[@id=\"footer-part\"]/div[1]/div/div/div[2]"));
		List<WebElement> allfooters = particularfooter.findElements(By.tagName("a"));
		System.out.println(allfooters.size());
		for (int i = 1; i < allfooters.size(); i++) {
			String chord = Keys.chord(Keys.CONTROL, Keys.ENTER);
			particularfooter.findElements(By.tagName("a")).get(i).sendKeys(chord);
		}

		Set<String> Allchildwindow = driver.getWindowHandles();
		Iterator<String> itr2 = Allchildwindow.iterator();
		while (itr2.hasNext()) {
			driver.switchTo().window(itr2.next());
			String title2 = driver.getTitle();
			System.out.println(title2);
			if (title2.equalsIgnoreCase("QAClickAcademy Blog - QAClickAcademy | Become a Test Expert")) {
				String text = driver.findElement(By.xpath("//*[@id=\"wp--skip-link--target\"]/h1")).getText();
				System.out.println(text);

			}
		}
		
		Thread.sleep(5000);
		
			driver.switchTo().defaultContent();
			
			Thread.sleep(5000);

			driver.findElement(By.id("opentab")).click();
			
		
	}

}

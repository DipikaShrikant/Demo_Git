package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(100,400)");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class=\"btn btn-info\"][1]")).click();
		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			Thread.sleep(2000);

			String title = driver.getTitle();
			System.out.println(title);
		}
		Thread.sleep(2000);
//		driver.navigate().back();
//		driver.findElement(By.xpath("//a[@href=\"#Multiple\"]")).click();
//
//		driver.findElement(By.xpath("//button[@onclick=\"multiwindow()\"]")).click();
//
//		while (itr.hasNext()) {
//			driver.switchTo().window(itr.next());
//			Thread.sleep(2000);
//
//			String title = driver.getTitle();
//			System.out.println(title);
//		}

		driver.quit();
	}

}

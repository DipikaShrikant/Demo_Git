package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button[onclick=\"confirmbox()\"]")).click();
		Thread.sleep(2000);

		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("a[href=\"#Textbox\"]")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button[onclick=\"promptbox()\"]")).click();
		Thread.sleep(2000);

		driver.switchTo().alert().sendKeys("Hey Dipika this side");
		Thread.sleep(2000);

		driver.switchTo().alert().getText();
		Thread.sleep(2000);

		driver.switchTo().alert().accept();
		Thread.sleep(2000);


		driver.quit();

	}

}

package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class DragAndDrop {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Static.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("scrollBy(100,400)");

		Screen sc = new Screen();

		Pattern simg = new Pattern("C:\\Users\\admin\\Documents\\ADipika\\Software testing\\Sikuli images\\s.PNG");

		Pattern drop = new Pattern("C:\\Users\\admin\\Documents\\ADipika\\Software testing\\Sikuli images\\drop.PNG");

		sc.dragDrop(simg, drop);


	}

}

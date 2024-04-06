package RahuShettyAccademy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioBtnCheckbox {

	public static void main(String[] args) throws InterruptedException {
				System.out.println("program started ===");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// Radio Button
		WebElement readioBtn = driver.findElement(By.xpath("//input[@value='radio2']"));
		readioBtn.click();
		System.out.println(readioBtn.isSelected());

		// select country with javascript

		WebElement country = driver.findElement(By.id("autocomplete"));
		country.sendKeys("ind");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String countrynm = "return document.getElementById('autocomplete').value";

		String Mycountry = (String) js.executeScript(countrynm);

		while (!Mycountry.equalsIgnoreCase("India")) {
			country.sendKeys(Keys.DOWN);
			countrynm = "return document.getElementById('autocomplete').value";

			Mycountry = (String) js.executeScript(countrynm);
		}
		country.sendKeys(Keys.ENTER);
		System.out.println("My country is " + Mycountry);

		// dropdown with select tag
		WebElement dropdownOption = driver.findElement(By.xpath("//select[@id=\"dropdown-class-example\"]"));
		Thread.sleep(3000);
		Select sel = new Select(dropdownOption);
		sel.selectByIndex(3);

		// checkBox
		WebElement checkBox = driver.findElement(By.id("checkBoxOption1"));
		System.out.println(checkBox.isEnabled());
		checkBox.click();

		driver.quit();

	}

}

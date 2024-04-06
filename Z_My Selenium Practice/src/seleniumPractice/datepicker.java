package seleniumPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Datepicker.html");

		WebElement date = driver.findElement(By.cssSelector("input[class='form-control hasDatepicker']"));
		date.click();

		while (!driver.findElement(
				By.cssSelector("[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] "
						+ "[class=\"ui-datepicker-month\"]"))
				.getText().contains("July")) {
			driver.findElement(By.cssSelector(
					"[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] "
							+ "[class=\"ui-icon ui-icon-circle-triangle-e\"]"))
					.click();
		}

		List<WebElement> Alldts = driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]"));
		for (int i = 0; i < Alldts.size(); i++) {
			String dt = driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]")).get(i).getText();
			if (dt.equalsIgnoreCase("22")) {
				driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]")).get(i).click();
			}
		}

		driver.quit();

	}

}

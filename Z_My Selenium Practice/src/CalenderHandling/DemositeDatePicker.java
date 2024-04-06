package CalenderHandling;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemositeDatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("datepicker1")).click();
		
		while(!driver.findElement(By.cssSelector("[class=\"ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all\"] [class=\"ui-datepicker-month\"]")).getText().contains("December")){
			driver.findElement(By.cssSelector("[class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
						
		}
		
		List<WebElement> alldt = driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]"));
		int size = alldt.size();
	System.out.println(size);
	
		
	for(int i=0;i<size;i++) {
		String text = driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]")).get(i).getText();
	
	if(text.contains("12")) {
		driver.findElements(By.cssSelector("td[data-handler=\"selectDay\"]")).get(i).click();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	}

}

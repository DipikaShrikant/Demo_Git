package CalenderHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://msrtc.maharashtra.gov.in/GeneralPages/HomeE.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdpcheckIn_popupButton")).click();
		
		while(!driver.findElement(By.cssSelector("[class='rcTitlebar'] [class='rcTitle']")).getText().contains("May 2024")) {
			System.out.println("in loop");
			driver.findElement(By.cssSelector("[class='rcTitlebar'] [class='rcNext']")).click();
		}
		
		List<WebElement> alldts = driver.findElements(By.cssSelector("td[class=\"rcSelected\"]"));
		int size = alldts.size();
		System.out.println(size);
		
		for(int i=1;i<size;i++) {
			String text = driver.findElements(By.cssSelector("td[class=\"rcSelected\"]")).get(i).getText();
			if(text.equalsIgnoreCase("18")) {
				driver.findElements(By.cssSelector("td[class=\"rcSelected\"]")).get(i).click();

			}
			
		}
	}

}

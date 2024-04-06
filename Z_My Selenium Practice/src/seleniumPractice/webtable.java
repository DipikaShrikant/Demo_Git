package seleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webtable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Documents\\ADipika\\Software testing\\chromedriver-win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/78117/nz-vs-aus-2nd-test-australia-tour-of-new-zealand-2024");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement innigg1 = driver.findElement(By.xpath("//div[@id=\"innings_1\"]//child::div"));
		List<WebElement> inningdata = innigg1
				.findElements(By.xpath("//div[@class=\"cb-col cb-col-100 cb-scrd-itms\"]"));
		System.out.println(inningdata.size());

		List<WebElement> Allruns = innigg1
				.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(3)"));
		int sum = 0;
		for (int i = 0; i < Allruns.size() - 2; i++) {
			String runsvalue = innigg1
					.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(3)")).get(i)
					.getText();

			int run = Integer.parseInt(runsvalue);
			System.out.println(run);
			sum = sum + run;

		}
		System.out.println("Total= " + sum);

		System.out.println("=================================================================");

		// bowler info

		WebElement bowlers = driver.findElement(By.xpath(
				"//div[@id=\"innings_1\"]//following-sibling::div[@class=\"cb-col cb-col-100 cb-ltst-wgt-hdr\"][2]"));
		List<WebElement> Binfo = bowlers.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms \"]"));
		System.out.println(Binfo.size());

		List<WebElement> Bname = bowlers
				.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms \"] :nth-child(1)"));
		for (int i = 0; i < Bname.size(); i++) {
			String bowlerNames = bowlers
					.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms \"] :nth-child(1)")).get(i)
					.getText();
			System.out.println(bowlerNames);

		}
		List<WebElement> runs = bowlers.findElements(By.cssSelector("[class=\"cb-col cb-col-100 cb-scrd-itms \"] :nth-child(4)"));
		
		for(WebElement run:runs) {
			String runB = run.getText();
			
			System.out.println(runB);
		}
		
		driver.quit();
	}

}

package com.emi.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculator {

	WebDriver driver = null;

	@Test
	public void CalculationDemo() throws InterruptedException {
		System.out.println("test is starting");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\88016\\eclipse-workspace\\EmiCalculate\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		Actions action = new Actions(driver);
		WebElement loanSliderCircle = driver.findElement(By.xpath("//div[@id = 'loanamountslider']"));
		WebElement interestSliderCircle = driver.findElement(By.xpath("//div[@id = 'loaninterestslider']"));
		WebElement tenurSliderCircle = driver.findElement(By.xpath("//div[@id = 'loantermslider']"));
		action.dragAndDropBy(loanSliderCircle, 83, 0).build().perform();
		Thread.sleep(2000);
		action.dragAndDropBy(interestSliderCircle, 88, 0).build().perform();
		Thread.sleep(2000);
		action.dragAndDropBy(tenurSliderCircle, -111, 0).build().perform();
		Thread.sleep(2000);
		WebElement expect = driver.findElement(By.xpath("//div[@id = 'emiamount']"));
		String expectmsg = expect.getText();
		Assert.assertEquals("Loan EMI", expectmsg);
		Thread.sleep(3000);
		driver.quit();
	}

}
//div[@id = 'loanamountslider']
//div[@id = 'loaninterestslider']
//div[@id = 'loantermslider']
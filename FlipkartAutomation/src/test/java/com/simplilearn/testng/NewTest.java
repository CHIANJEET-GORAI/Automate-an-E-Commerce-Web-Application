package com.simplilearn.testng;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\projects\\Phase 5\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void LoadTime() {
		long start = System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");
		long finish = System.currentTimeMillis();
		long loadTime = finish - start;
		System.out.println("time taken to load the page=" + loadTime);

	}

	@Test
	public void search() {
		try {
			driver.get("https://www.flipkart.com/");

//			 maximise the window

			driver.manage().window().maximize();

			// get title of page
			System.out.println("Title:" + driver.getTitle());

			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();

			System.out.println("Logged In....");

			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("iphone13");
			driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button")).click();
			System.out.println("Iphone 13 is being searched");
			Thread.sleep(12000);

			WebElement ImageFile = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[1]/div[1]/div/div/img"));

			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",ImageFile);
			if (!ImagePresent) {
				System.out.println("Image not displayed.");
			} else {
				System.out.println("Image displayed.");
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)"); // Scroll Down(+ve)
			System.out.println("scrolled down by 700 pixels ");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() {
		// driver.close();
		driver = null;

	}

}
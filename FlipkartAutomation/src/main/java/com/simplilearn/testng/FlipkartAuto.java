package com.simplilearn.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAuto {
	
	public static void main(String[] args) {
		//STEP:1 declare a path
		
		String path= "E:\\projects\\Phase 5\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
	
		//STEP:2 initialize the webdriver 
		
		WebDriver driver= new ChromeDriver();
		//STEP:3 give the base url
	
		//String url="https://www.flipkart.com/";
		//driver.get(url);
		
		long start=System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");
		long finish=System.currentTimeMillis();
		long loadTime=finish-start;
		System.out.println("time taken to load the page="+loadTime);
		
		
		
		//try {
			//Thread.sleep(1000);
			//maximise the window
		
			driver.manage().window().maximize();
		
			//get title of page
			System.out.println("Title:"+driver.getTitle());
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
			
			System.out.println("Logged In....");
			
			WebElement search= driver.findElement(By.name("q"));
			search.sendKeys("iphone 13");
			
			
			driver.findElement(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div._1cmsER > form > div > button")).click();
			System.out.println("Iphone 13 is being seached");
			
			//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]"));
			//System.out.println("Title:"+driver.getTitle());
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
			
			for(int i=1;i<6;i++) {
			
			try {
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)", "");
			System.out.println("Reached to bottom of page");
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}			
	}
}

package selenium;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class WindowsHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		 String oldwindow=driver.getWindowHandle();
		WebElement firstbutton =driver.findElement(By.id("home"));
		firstbutton.click();
		

		java.util.Set<String> handles= driver.getWindowHandles();
		
	   for (String newwindow : handles) {
			driver.switchTo().window(newwindow);
		}
	     WebElement buttton=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[2]/a/img"));
	     buttton.click();
	     driver.close();
	     driver.switchTo().window(oldwindow);
	     
	     WebElement multiwindow =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button"));
	     multiwindow.click();
	     int nowindow=driver.getWindowHandles().size();
	     System.out.println("no. of windows:"+nowindow);
	     
	     WebElement dontclose =driver.findElement(By.id("color"));
	     dontclose.click();
	     java.util.Set<String> allwindow =driver.getWindowHandles();
	     for (String window1 : allwindow) {
	    	 if (!window1.equals(oldwindow)) {
				driver.switchTo().window(window1);
				driver.close();
			}
		}
	    // driver.quit();
	     
	     
	     
	     
	     
	}
	

}

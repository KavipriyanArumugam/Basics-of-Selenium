package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http:\\www.leafground.com/pages/Alert.html");
		
		//1.open and accept alert
		WebElement alert= driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div/div/button"));
		alert.click();
		Alert a = driver.switchTo().alert();
		a.accept();
		
		//2.open and cancel alert
		WebElement confirmbutton=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button"));
		confirmbutton.click();
		Alert confirmalert =driver.switchTo().alert();
		confirmalert.dismiss();
		
		//3.type any name in alert box
		WebElement promptbutton =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/button"));
		promptbutton.click();
		Alert promptalert=driver.switchTo().alert();
		promptalert.sendKeys("friends");
		promptalert.accept();

	}

}

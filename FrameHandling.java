package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		
		driver.switchTo().frame(0);
		WebElement button =driver.findElement(By.id("Click"));
		button.click();
		String txt=button.getText();
		System.out.println(txt);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement nestedframe=driver.findElement(By.id("Click1"));
		nestedframe.click();
		driver.switchTo().defaultContent();
		
		List<WebElement> totalframe= driver.findElements(By.tagName("iframe"));
		int size=totalframe.size();
		System.out.println(size);

	}

}

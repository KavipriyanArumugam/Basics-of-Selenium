package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class editexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		WebElement emailbox=driver.findElement(By.id("email"));
		emailbox.sendKeys("kavi0909@gmail.com");
		
		WebElement appendbox=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input"));
		appendbox.sendKeys("text");
		
		WebElement gettextbox=driver.findElement(By.name("username"));
		String value = gettextbox.getAttribute("value");
		
		System.out.println(value);
		
		WebElement clearbox=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div/div/input"));
		clearbox.clear();
		
		WebElement disablebox=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[5]/div/div/input"));
		boolean enabled=disablebox.isEnabled();
		System.out.println(enabled);
		driver.quit();
	}

}

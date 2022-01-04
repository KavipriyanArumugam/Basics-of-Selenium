package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gmaillogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement username =driver.findElement(By.id("identifierId"));
		 username.sendKeys("mailt4910@gmail.com"+Keys.ENTER);
		 //Thread.sleep(4000);
        WebElement password=driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
        password.sendKeys("Testmail@1"+Keys.ENTER);
	}

}

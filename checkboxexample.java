package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\\\Program Files\\\\Java\\\\java selenium\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/checkbox.html");

		WebElement c = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div[5]/input"));
		c.click();
		
		WebElement selenium=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/input"));
		boolean isselet=selenium.isSelected();
		System.out.println(isselet);
		
		WebElement firstelement =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[1]/input"));
		
		if (firstelement.isSelected()) {
			firstelement.click();
		}else {
			firstelement.click();
		}
		
		WebElement secondelement =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[2]/input"));
		if (secondelement.isSelected()) {
			secondelement.click();
		}
	}

}

package selenium;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		
		WebElement from=driver.findElement(By.id("draggable"));
		WebElement to =driver.findElement(By.id("droppable"));
		 
		Actions actions =new Actions(driver);
		actions.clickAndHold(from).moveToElement(to).release(to).build().perform();

		actions.dragAndDrop(from, to).build().perform();
	}

}

package basics;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.event.webkitSpeechRecognitionError;

public class ButtonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Button.html");
		
		//1.get the x,y position
		WebElement getposition = driver.findElement(By.id("position"));
		org.openqa.selenium.Point xypoints = getposition.getLocation();
		double xpoint =xypoints.getX();
		double ypoint =xypoints.getY();
		System.out.println("x point is:"+xpoint+"\n"+"y point is:"+ypoint);
		
		
		//2.find the color
		WebElement buttoncolor = driver.findElement(By.id("color"));
		String color= buttoncolor.getCssValue("background-color");
		System.out.println("button color is:"+color);
		//driver.quit();
		
		//3.find the size
		WebElement buttonsize = driver.findElement(By.id("size"));
		int height= buttoncolor.getSize().getHeight();
		int width = buttoncolor.getSize().getWidth();
		System.out.println("height is:"+height+"\n"+"width is:"+width);
		
		//4.go to home
		WebElement gohome =driver.findElement(By.id("home"));
		gohome.click();
	}

}

package basics;

import java.awt.List;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.event.webkitSpeechRecognitionError;

public class Dropdownexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\java selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		//1.dropdown
		WebElement dropDown1= driver.findElement(By.id("dropdown1"));
		org.openqa.selenium.support.ui.Select select= new org.openqa.selenium.support.ui.Select(dropDown1);
		select.selectByIndex(3);
		select.selectByValue("2");
		select.selectByVisibleText("Loadrunner");
		dropDown1.sendKeys("UFT/QTP");
		//2.no.of options
		java.util.List<WebElement> listofoption = select.getOptions();
		int size = listofoption.size();
		System.out.println("no. of elements"+size);
		
		//3.mutliselect options
		WebElement multiselect=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[6]/select"));
		 org.openqa.selenium.support.ui.Select multiselectbox=new org.openqa.selenium.support.ui.Select(multiselect);
		 multiselectbox.selectByIndex(1);
		 multiselectbox.selectByIndex(2);
		 multiselectbox.selectByIndex(3);

	}

}

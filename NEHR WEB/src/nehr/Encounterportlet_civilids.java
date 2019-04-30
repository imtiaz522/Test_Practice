package nehr;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Encounterportlet_civilids {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver wd;
		
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\geckodriver.exe");
        wd = new FirefoxDriver();
		
	  //Login
		wd.navigate().to("http://10.99.9.28:9293/nehr");
	  //Thread.sleep(20);
	  wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  

      String uname = "html/body/nehr-app/login/div/div/div[2]/div[1]/div[2]/form/div[1]";
	  String pwd = "html/body/nehr-app/login/div/div/div[2]/div[1]/div[2]/form/div[2]/div/input";
	  String signin_btn = "html/body/nehr-app/login/div/div/div[2]/div[1]/div[2]/form/div[3]/button";
	  
	  if(wd.findElement(By.xpath(uname)).isDisplayed())
	  { 
		   System.out.println("Test sucess");
		   wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   wd.findElement(By.id("sel-u")).sendKeys("MOH1203");
		   wd.findElement(By.xpath(pwd)).sendKeys("moh");
		   wd.findElement(By.xpath(signin_btn)).click(); 
		   wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   wd.findElement(By.xpath(".//*[@id='menuBar']/li[3]/a")).click();
		   wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   wd.findElement(By.xpath(".//*[@id='changeCivilId']/div/div/div[2]/div/div[1]/div[1]/div/input")).sendKeys("72740511");
		   System.out.println("Iam waiting to click on select");
		   wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   System.out.println("Iam done waiting ");
		   WebDriverWait wait = new WebDriverWait(wd, 10);
		   WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Select')]")));
		   button.click();
		   //button.click();
		   wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='encounters']/encounter/div[1]/div[1]/div/div/a[2]")));
		   wd.findElement(By.xpath(".//*[@id='encounters']/encounter/div[1]/div[1]/div/div/a[2]")).click();
		   System.out.println("I Clicked");
		   wd.close();
		  
		   
		   
		   
		   
	   }
	  else
	  {
		  System.out.println("Page is not loaded");
	  }
	}	
}



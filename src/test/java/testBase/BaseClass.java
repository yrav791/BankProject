package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

	public static WebDriver driver;
	public Properties pobj;
	public FileInputStream  fi;
	 public Logger logger;
	
	@BeforeClass
	@Parameters({"Os","browser"})
	public void openApp(String os,String br) throws IOException
	{
		fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 pobj=new Properties();
		 logger=LogManager.getLogger(this.getClass());
		pobj.load(fi);
		
		if(pobj.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities desiredc=new DesiredCapabilities();
			if(os.equalsIgnoreCase("window"))
			{
				desiredc.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				desiredc.setPlatform(Platform.LINUX);
			}
			
			else if(os.equalsIgnoreCase("mac"))
			{
				desiredc.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid operating system...");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome":desiredc.setBrowserName("Chrome");break;
			case "firefox":desiredc.setBrowserName("Firefox");break;
			case "edge":desiredc.setBrowserName("MicrosoftEdge");break;
			default :System.out.println("invalid browser Name");return;
			}
			
			driver=new RemoteWebDriver(new URL(" http://192.168.1.104:4444/wd/hub"),desiredc);
		}
		if(pobj.getProperty("execution_env").equalsIgnoreCase("local")){
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default :System.out.println("invalid browser Name");return;
		}
		}
		driver.get(pobj.getProperty("website"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd,hh:mm:ss").format(new Date());
		TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=(".\\BankProject\\ScreenShotss\\")+tname+" "+timeStamp+".png";
		File targetFile=new File (targetFilePath);
	    sourceFile.renameTo(targetFile);
	    return targetFilePath;
	}
	
	public static String randomStringName(){
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
				
	}
	
	public static String randomStringAddress(){
		String generateString=RandomStringUtils.randomAlphabetic(20);
		return generateString;
				
	}

	public static String randomNumber(){
		String generateNumber=RandomStringUtils.randomNumeric(10);
		return generateNumber;		
	}
	public static String randomAlphanumeric(){
		String generateString=RandomStringUtils.randomAlphabetic(5);
		String generateNumber=RandomStringUtils.randomNumeric(3);
		return (generateString+generateNumber);
	}
}

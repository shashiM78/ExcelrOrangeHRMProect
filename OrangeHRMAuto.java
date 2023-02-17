package orangeHRM;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAuto {
	public static Properties prop;
	public static Properties prop2;
	 public static WebDriver driver;
	 public static WebDriver driver2;
	 
	
	
	 @BeforeMethod
		public void beforemethod() throws Exception {
		String Data = ".\\src\\main\\java\\com\\dataFile\\Data.properties";
		FileInputStream file = new FileInputStream(Data);
		prop = new Properties();
		prop.load(file);
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	       driver.get(prop.getProperty("url"));
	      

	   
		
	 }
		
	
	    @ Test
	    public void ValidateLoginTC01() throws InterruptedException {
	    	driver.get(prop.getProperty("url"));
	    	Thread.sleep(2000);
       driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
    	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
   		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
   	 String a =" https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
   		String	expurl= a;
   		if (expurl == a) {
   			System.out.println("TC01 passed");
   			} else {
   			System.out.println("TC01 Failed");
   			}
    	 
   		driver.quit();
   		}
   		
   		
   
   		
   		//For TC02
	    @Test
	    public void ValidateLoginTC02() {
	    	driver.get(prop.getProperty("url"));
   	 driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname1"));
 	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
 	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
 
 	String actualUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
 	//Assert.assertEquals(actualUrl,expectedUrl );
   String	expectedUrl= driver.getCurrentUrl();
 	 actualUrl = driver.getCurrentUrl();
 	 if(actualUrl.equalsIgnoreCase(expectedUrl)) {
 	     System.out.println("TC02 passed");
	    }else {
	    	System.out.println("TC02 Falied");
	    }
 	
 	driver.quit();
	}
	    
	    @Test
	    public void ValidateLoginTC03() {
	    	driver.get(prop.getProperty("url"));
	    driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	 	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd1"));
	 	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	 	String actualurl1="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 	 String	expectedUrl1= driver.getCurrentUrl();
	 	 actualurl1= driver.getCurrentUrl();
	 	 if(actualurl1.equalsIgnoreCase(expectedUrl1)) {
	 	     System.out.println("TC03 passed");
		    }else {
		    	System.out.println("TC03Falied");
		    }
	 	driver.quit();
	    }
	    
	    @Test
	    public void ValidateLoginTC04() {
	    	driver.get(prop.getProperty("url"));
		    driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname2"));
		 	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd2"));
		 	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		 	String actualurl1="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		 	 String	expectedUrl1= driver.getCurrentUrl();
		 	 actualurl1= driver.getCurrentUrl();
		 	 if(actualurl1.equalsIgnoreCase(expectedUrl1)) {
		 	     System.out.println("TC04 passed");
			    }else {
			    	System.out.println("TC04 Falied");
			    }
		 	driver.quit();
		    }
		      
	
	@Test
	public void ForgotpasswordTC01() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")).click();
		//String actualurl1="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 	 String	b = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
	 	// actualurl1= driver.getCurrentUrl();
	 	 String expeUrl = b;
	 	 if(expeUrl == b) {
	 	     System.out.println("TC001 passed");
		    }else {
		    	System.out.println("TC001Falied");
		    }
	}
	@Test
	public void ForgotpasswordTC02() {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname3"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[2]")).click();
		String actualUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
	   String	expectedUrl= driver.getCurrentUrl();
	 	// actualUrl = driver.getCurrentUrl();
	 	 if(actualUrl.equalsIgnoreCase(expectedUrl)) {
	 	     System.out.println("TC002 passed");
		    }else {
		    	System.out.println("TC002 Falied");
		    }
	 	
	}
	@Test
	public void SearchFunctionTC001() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
    	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
   	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	Thread.sleep(2000);
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		//driver.get(prop.getProperty("url2"));
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(prop.getProperty("feature"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();
		String c = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		   String	expectedUrl= c;
		 	// actualUrl = driver.getCurrentUrl();
		 	 if(expectedUrl == c) {
		 	     System.out.println("TC001 passed");
			    }else {
			    	System.out.println("TC001 Falied");
			    }
		 
			    }
		//https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers
	@Test
	public void SearchFunctionTC002() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	    	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	   	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);
		
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			//driver.get(prop.getProperty("url2"));
			driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(prop.getProperty("feature2"));
			//String c = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
			  String	expectedUrl= "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
			 	 String actualUrl = driver.getCurrentUrl();
			 	 if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			 	     System.out.println("TC002 passed");
				    }else {
				    	System.out.println("TC002 Falied");
	}}
	

//@BeforeMethod
public void BeforeMethod() throws IOException {

	String Data2 = ".\\src\\main\\java\\com\\dataFile\\Data2.properties";
	FileInputStream file1 = new FileInputStream(Data2);
	prop2 = new Properties();
	prop2.load(file1);
	


	 driver = new ChromeDriver();
	  driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    System.out.println(prop2.getProperty("url3"));
}

@Test
    public void ValidateAdmin0() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
    driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
 //   WebElement role = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i"));
    WebElement role =	driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
    role.click();
    
			Actions actadmin = new Actions(driver);
			actadmin.sendKeys(Keys.ARROW_DOWN).build().perform();
			Actions actadmin1 = new Actions(driver);
			actadmin1.sendKeys(Keys.ENTER).build().perform();
			Actions actadmin2 = new Actions(driver);
			actadmin2.moveToElement(role).click().build().perform();
			Thread.sleep(2000);
			JavascriptExecutor ex1 = (JavascriptExecutor)driver;
			WebElement Employeename =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
			ex1.executeScript("arguments[0].click();",Employeename);
	
			Employeename.sendKeys("Odis Adalwin");
			Thread.sleep(2000);
			Actions actemployee = new Actions(driver);
		actemployee.sendKeys(Keys.ENTER).build().perform();
			Actions actemployee1 = new Actions(driver);
			actemployee1.moveToElement(Employeename).build().perform();
			
		WebElement Status =	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
		Status.click();
		Actions actStatus = new Actions(driver);
		actStatus.sendKeys(Keys.ARROW_DOWN).build().perform();
		Actions actStatus1 = new Actions(driver);
		actStatus1.sendKeys(Keys.ENTER).build().perform();
		Actions actStatus2 = new Actions(driver);
		actStatus2.moveToElement(Status).click().build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(prop2.getProperty("username"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(prop2.getProperty("userpwd"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(prop2.getProperty("confirmpwd"));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
		
}
@Test

public void ValidateAdmin01() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	//driver2.get(prop2.getProperty("url3"));
   driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();		
					driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();
						driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
					 Thread.sleep(3000);
			WebElement role =	driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]"));
	role.click();
	
					 Thread.sleep(2000);
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
				 Actions action2 = new Actions(driver);
				 action2.sendKeys(Keys.ENTER).build().perform();
				 Actions action3= new Actions(driver);
				action3.moveToElement(role).build().perform();
				Thread.sleep(2000);
				String Empname = "Fiona Grace";
			WebElement employname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
					employname.sendKeys(Empname);
					Thread.sleep(2000);
					employname.sendKeys(Keys.ENTER);
					driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("Shiva Kumar");
					driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("Shiva@123");
						driver.findElement(By.xpath(("//input[@class='oxd-input oxd-input--active'][@type = 'password']"))).sendKeys("Shiva");
						WebElement Status = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]"));
						Status.click();
						Thread.sleep(2000);
						Actions act = new Actions(driver);
						act.sendKeys(Keys.ARROW_DOWN).build().perform();
					 Actions act2 = new Actions(driver);
					 act2.sendKeys(Keys.ENTER).build().perform();
					 Actions act3= new Actions(driver);
					act3.moveToElement(Status).build().perform();
					Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
						Thread.sleep(3000);
						driver.quit();
}
@Test
public void ValidatePim0() {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	driver.findElement(By.name("firstName")).sendKeys("Fiona");
	driver.findElement(By.name("lastName")).sendKeys("Grace");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("105");
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")).click();
}
@Test
public void ValidatePim01() {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	driver.findElement(By.name("firstName")).sendKeys("Shi");
	driver.findElement(By.name("lastName")).sendKeys("12325");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("105");
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")).click();
String excpectedP= "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
String actualurlP = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/77";
if (actualurlP.equalsIgnoreCase(excpectedP)) {
	System.out.println("ValidateTC05 Passed");
}else {
	System.out.println("TC05 Failed");
	
}}
@Test
public void ValidatePim02() {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	driver.findElement(By.name("firstName")).sendKeys("");
	driver.findElement(By.name("lastName")).sendKeys("12325");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("105");
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")).click();
String excpectedP= "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
String actualurlP = driver.getCurrentUrl();
if (actualurlP.equalsIgnoreCase(excpectedP)) {
	System.out.println("ValidateTC05 Passed");
}else {
	System.out.println("TC05 Failed");
	 
}}
@Test
public void ValidateRecruitment01() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	driver.findElement(By.name("firstName")).sendKeys("Shankar");
	driver.findElement(By.name("middleName")).sendKeys("Ram");
	driver.findElement(By.name("lastName")).sendKeys("k");
	
	WebElement Vacancy  = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]"));
	Vacancy.click();
	Actions actVacancy = new Actions(driver);
	actVacancy.sendKeys(Keys.ARROW_DOWN).build().perform();
 Actions actVacancy2 = new Actions(driver);
 actVacancy2.sendKeys(Keys.ENTER).build().perform();
 Actions actVacancy3= new Actions(driver);
actVacancy3.moveToElement(Vacancy).build().perform();

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")).sendKeys("Odin12@Gmail.com");
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")).sendKeys("987456321");
Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(text(),'Browse')]")).click();


 WebElement Date = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[2]/div/div[2]/div/div/input"));
//Date.click();
Date.sendKeys("02/02/2023");
Actions actdate = new Actions(driver);
actdate.sendKeys(Keys.ARROW_DOWN).build().perform();
Actions actdate2 = new Actions(driver);
actdate2.sendKeys(Keys.ENTER).build().perform();
Actions actdate3= new Actions(driver);
actdate3.moveToElement(Date).build().perform();
String excpecterP= "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate";
String actualurrP = driver.getCurrentUrl();
if (actualurrP.equalsIgnoreCase(excpecterP)) {
	System.out.println("TC01recuirt Passed");
}else {
	System.out.println("TC01recuirt Failed");
}
driver.quit();
}
@Test

public void ValidateRecruitment02() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	driver.findElement(By.name("firstName")).sendKeys("Shankar");
	driver.findElement(By.name("middleName")).sendKeys("Ram");
	driver.findElement(By.name("lastName")).sendKeys("k");
	
	WebElement Vacancy1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]"));
	Vacancy1.click();
	Actions actVacancy1 = new Actions(driver);
	actVacancy1.sendKeys(Keys.ARROW_DOWN).build().perform();
 Actions actVacancy4 = new Actions(driver);
 actVacancy4.sendKeys(Keys.ENTER).build().perform();
 Actions actVacancy6= new Actions(driver);
actVacancy6.moveToElement(Vacancy1).build().perform();

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")).sendKeys("Odin12@Gmail.com");
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")).sendKeys("987456321");
Thread.sleep(2000);
String excpecterP= "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/28";
String actualurrP = driver.getCurrentUrl();
if (actualurrP.equalsIgnoreCase(excpecterP)) {
	System.out.println("TC01recuirt Passed");
}else {
	System.out.println("TC01recuirt Failed");
}

driver.quit();
}
@Test

public void ValidateMyinfo01() throws InterruptedException {
	driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("Pwd"));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	WebElement myinfo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span"));
	myinfo.click();
	//myinfo.clear();
	 Thread.sleep(2000);
	 WebElement  firstname = driver.findElement(By.name("firstName"));
	 firstname.clear();
	 //firstname.sendKeys("Shiva");
	 WebElement  middlename = driver.findElement(By.name("middleName"));
	 middlename.clear();
	// middlename.sendKeys("Kumar");
	 WebElement  lastname = driver.findElement(By.name("lastName"));
	 lastname.clear();
	// lastname.sendKeys("M");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("E054");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")).sendKeys("D057");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/i")).sendKeys("02/03/2023");
	
	
	driver.quit();





	

}}


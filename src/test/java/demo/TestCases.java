package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;


public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
  public void testCase01() throws InterruptedException{
    System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        //verify if Name text is displayed
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//span[contains(@class,'M7eMe')]")
));
        //Enter text in textbox
        WebElement nameInputBox=driver.findElement(By.xpath("(//input[contains(@class,'whs')])[1]"));
        Wrappers.enterText(nameInputBox,"Crio Learner");
        
        System.out.println("part2 start");
        WebElement practicingAutomationArea=driver.findElement(By.xpath("//textarea[contains(@class,'KHxj')]"));
       String epochTimeString= Wrappers.getEpochTimeAsString();
        Wrappers.enterText(practicingAutomationArea,"I want to be the best QA Engineer!"+epochTimeString);
        Thread.sleep(3000);
        System.out.println("part3 start");
        Wrappers.radioButton(driver,"0 - 2");
          Thread.sleep(3000);
        Wrappers.checkBox(driver,"Java");
        Wrappers.checkBox(driver,"Selenium");
        Wrappers.checkBox(driver,"TestNG");
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//span[contains(text(),'Choose')]")
));
        WebElement dropDownElement=driver.findElement(By.xpath("//span[contains(text(),'Choose')]"));
        Thread.sleep(3000);
        Wrappers.clickOnElement(driver,dropDownElement);
        Thread.sleep(3000);
        // verify 5 dropdown options should only be located by locator
        List<WebElement> ele= driver.findElements(By.xpath("//div[contains(@class,'ncFHed ')]//span[not(contains(text(),'Choose'))]"));
        Wrappers.dropDownClickByLoop(ele,"Mr");
        Thread.sleep(3000);
            // enter 7 days ago date
        String sevenDaysAgoDate= Wrappers.getDateSevenDaysAgo(7);
        WebElement dateInputBox= driver.findElement(By.xpath("//input[contains(@type,'date')]"));
       Thread.sleep(3000);
        Wrappers.enterText(dateInputBox,sevenDaysAgoDate);
        Thread.sleep(3000);
        // time
        WebElement hrElement= driver.findElement(By.xpath("//input[contains(@aria-label,'Hour')]"));
        WebElement minElement= driver.findElement(By.xpath("//input[contains(@aria-label,'Minute')]"));
        WebElement submitButton= driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));

        Wrappers.enterText(hrElement,"07");
        Wrappers.enterText(minElement,"30");
        Wrappers.clickOnElement(driver,submitButton);
        Thread.sleep(5000);
       //verify success message Thanks for your response, Automation Wizard!
        WebElement successMessage=driver.findElement(By.xpath("//div[contains(text(),'Thanks for your response')]"));
        System.out.println(successMessage.getText());

        System.out.println("end Test case: testCase01");
       // Assert.assertEquals(currenturl,"");
       //WebElement ele= driver.findElement(By.xpath("")); //
       // WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated("//div[contains(@class,'ellipsis line-clamp-1')]"));
    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}
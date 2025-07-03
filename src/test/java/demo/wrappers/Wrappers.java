package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement ele,String text){
    try {
        ele.clear();
    ele.sendKeys(text);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static String getEpochTimeAsString(){
   long epochTime= System.currentTimeMillis();
  String epochTimeString= String.valueOf(epochTime);
  return epochTimeString;
}

// public static void radioButton(WebDriver driver,String text){
//     try {
//         WebElement ele= driver.findElement(By.xpath("//span[contains(text(),'"+text+"')]"));
//         ele.click();
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
// }
public static void radioButton(WebDriver driver,String text){
    try {
        List<WebElement> ele= driver.findElements(By.xpath("//span[contains(@class,'OvPDhc')]"));
        for(WebElement radioBtn:ele){
            String btnText= radioBtn.getText();
            if(btnText.equalsIgnoreCase(text)){
                radioBtn.click();
                System.out.println("selected radio button");
                return;
            }
        }
        System.out.println("NOT FOUND radio button");
    } catch (Exception e) {
         e.printStackTrace();
    }
}

public static void checkBox(WebDriver driver,String text){
    try {
        List<WebElement> ele= driver.findElements(By.xpath("//span[contains(@class,'vBHf')]"));
        for(WebElement checkBtn:ele){
            String checkText= checkBtn.getText();
            if(checkText.equalsIgnoreCase(text)){
                checkBtn.click();
                System.out.println("selected checkbox button");
                return;
            }
        }
        System.out.println("NOT FOUND checkbox button");
    } catch (Exception e) {
         e.printStackTrace();
    }
}
public static void clickOnElement(WebDriver driver,WebElement element){
    JavascriptExecutor js= (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()", element);

}
public static void dropDownClickByLoop(List<WebElement> ele,String text){
try {
    for(WebElement element:ele){
    if (element.getText().equals(text)){
        element.click();
        break;
    }
}
} catch (Exception e) {
    e.printStackTrace();
}
}
public static String getDateSevenDaysAgo(int days){
    LocalDate currentDate= LocalDate.now();
    LocalDate dateMinus7Days= currentDate.minusDays(days);
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate= dateMinus7Days.format(formatter);
    return formattedDate;

}
//public void clickElement(WebDriver driver, By locator) {
//         try {
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//             WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//             element.click();
//             System.out.println("Clicked success for " + locator.toString());

//         } catch (Exception e) {
//             System.out.println("Click failed for locator" + locator.toString());
//             e.printStackTrace();
//         }
// //Retry logic while(tries<attempts), use return in try and tries++ in catch. Also 
// //if (tries == attempts) {throw new RuntimeException("Failed to click after " + attempts + " attempts", e);}
//     }
//    public void sendKeysToElement(WebDriver driver, By locator, String text){
//     try {
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//             WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//             element.clear();
//             element.sendKeys(text);
//             System.out.println("send keys to"+locator.toString());
//     } catch (Exception e) {
//         System.out.println("SendKeys failed for locator"+locator.toString());
//         //Assert.fail("Unexpected exception during sendKeys to: " + locator.toString(), e);
//         e.printStackTrace();
//     }
//    }

}

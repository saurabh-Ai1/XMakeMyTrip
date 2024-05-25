
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.amazon.in/");
        String title="amazon";
        String Url = driver.getCurrentUrl();
        if(Url.contains(title)){
            System.out.println("URL contains" +title);
        }else{
            System.out.println("URL does not contains" +title);
        }
        
        System.out.println("end Test case: testCase01");
    }

    public void testCase02(String laptop) throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.amazon.in/");
        Thread.sleep(2000); //crio team
       WebElement searchbar=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       searchbar.sendKeys("laptop");
       Thread.sleep(2000);

       System.out.println(""+searchbar);
    //    searchbar.click();
        driver.findElement(By.id("nav-search-submit-button")).click();  //crio team
        WebElement laptopDescription=driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div/div/div/div/div/div/div[2]/div/div/div[1]/h2"));
       ////*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div/div/div/div/div/div/div[2]/div/div/div[1]/h2
       System.out.println("1:- "+laptopDescription);

      String laps=laptopDescription.getText();
      System.out.println("2:- "+laps);
     
       if(laps.contains("Laptop"));
       {
        System.out.println("The product description contains the term laptop");
       }
       
        Thread.sleep(2000);
        
        System.out.println("end Test case: testCase02");
        
    }

    
    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.amazon.in");
        Thread.sleep(2000);
        WebElement NavigationMenu=driver.findElement(By.xpath("//*[@id='nav-xshop']/a[9]"));
        Thread.sleep(2000);
        NavigationMenu.click();
        Thread.sleep(2000);
       if(driver.getCurrentUrl().contains("electronics")){
            System.out.println("the URL contain the expected title Electronics");
         }
         Thread.sleep(2000);
        
         System.out.println("end Test case: testCase03");
        }

}


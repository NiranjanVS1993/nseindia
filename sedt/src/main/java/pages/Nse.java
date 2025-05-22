package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import pages.Nschomepage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Nse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
    	ChromeDriver driver = new ChromeDriver();
    	String noresults = "";
    	//create the htmlReporter object 
    	  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
    	//create ExtentReports and attach reporter(s)
    	  ExtentReports extent = new ExtentReports();
    	  extent.attachReporter(htmlReporter);
    	//creates a toggle for the given test, add all log events under it
    	  ExtentTest test1 = extent.createTest("NSE", "test to validate low & high in NSE website");
    	  
    	  
    	  
        // Set up ChromeDriver path.  You might need to adjust this path.
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with your chromedriver path

        //ChromeOptions to resolve the error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver
        //WebDriver driver = new ChromeDriver(options);

        // Set an implicit wait to handle dynamic content loading
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        // Navigate to the NSE India website
        driver.get("https://www.nseindia.com/");
        
        Nschomepage nscLoc = new Nschomepage(driver);
        //FileInputStream fis = new FileInputStream("testdata.properties");
        //Properties pros = new Properties();
        //pros.load(fis);
        //String searchVal = pros.getProperty("search");
        //System.out.println(searchVal);
        
        String csvFilePath = "C:\\Users\\SABARIVEL\\eclipse-workspace\\sedt\\testdata.csv"; // Replace with your file path
	    
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> records = reader.readAll();

            for (String[] record : records) {
                for (String cell : record) {
        
        nscLoc.searchtextbox().sendKeys(cell);
        //Searched Company Name
        test1.pass("Data for 52 week period: " +cell);
        
        nscLoc.searchitem().click();
        
        try {
        	  // Code that might throw an exception
        	noresults = nscLoc.noresultsfound().getText();        	
        	} catch (Exception exceptionVariable) {
        	  // Code to handle the exception
        		System.out.println(exceptionVariable);
        	}
        if(noresults.isBlank()) {
    		nscLoc.historical().click();
            nscLoc.oneyear().click();
            nscLoc.historicaldata().click();
            
            System.out.println(nscLoc.highlabel().getText());
            test1.pass(nscLoc.highlabel().getText());
            System.out.println(nscLoc.highvalue().getText());
            test1.pass(nscLoc.highvalue().getText());
            System.out.println(nscLoc.highdate().getText());
            test1.pass(nscLoc.highdate().getText());
            System.out.println(nscLoc.lowlabel().getText());
            test1.pass(nscLoc.lowlabel().getText());
            System.out.println(nscLoc.lowvalue().getText());
            test1.pass(nscLoc.lowvalue().getText());
            System.out.println(nscLoc.lowdate().getText());
            test1.pass(nscLoc.lowdate().getText());
            nscLoc.nseLogo().click();
    	} else {
    		System.out.println("Value of Search Results is "+noresults);
    	}
        
        
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        extent.flush();
        driver.close();

	}

}

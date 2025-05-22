package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Nschomepage {

	public WebDriver driver;
	public Nschomepage(WebDriver driver) {this.driver=driver;}

public By searchtextbox = By.xpath("//div[@class='rbt']//input[@class='rbt-input-main form-control rbt-input']");
public By searchitem = By.xpath("//div[@id='async-navbar-search']/a[@id='async-navbar-search-item-0']");
public By noresultsfound = By.xpath("//div[@class='main']//h2[contains(text(),'No results')]");
public By historical= By.xpath("//div[@class='nav nav-tabs horizontal_tab']/a[@id='loadHistoricalData']");
public By oneyear= By.xpath("//div[@id='historical-trade']//div[@class='col-md-5']/ul[@class='dayslisting']//li/a[@id='oneY']");
public By historicaldata= By.xpath("//div[@id='info-historicaldata']//a[@id='phld']/h4");
public By nseLogo = By.xpath("//a[contains(@class,'navbar-brand')]");

public By highlabel= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='high']");
public By highvalue= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='high']/following-sibling::td[@class='text-center bold']");
public By highdate= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='high']/following-sibling::td[@class='text-center']");
public By lowlabel= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='low']");
public By lowvalue= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='low']/following-sibling::td[@class='text-center bold']");
public By lowdate= By.xpath("//div[@id='card1']//table[@class='table-resonsive card-table']//td[@id='low']/following-sibling::td[@class='text-center']");


public WebElement searchtextbox(){
	return driver.findElement(searchtextbox);
}
	public WebElement searchitem(){
		return driver.findElement(searchitem);
}
	
	public WebElement noresultsfound(){
		return driver.findElement(noresultsfound);
}	
	public WebElement historical(){
		return driver.findElement(historical);
}
	
	public WebElement oneyear(){
		return driver.findElement(oneyear);
		
}	
	public WebElement historicaldata(){
		return driver.findElement(historicaldata);
		
}	
	public WebElement highlabel(){
		return driver.findElement(highlabel);	
}
	
	public WebElement highvalue(){
		return driver.findElement(highvalue);	
}
	
	public WebElement highdate(){
		return driver.findElement(highdate);	
}
	
	public WebElement lowlabel(){
		return driver.findElement(lowlabel);	
}
	
	public WebElement lowvalue(){
		return driver.findElement(lowvalue);	
}
	
	public WebElement lowdate(){
		return driver.findElement(lowdate);	
}
	
	public WebElement nseLogo(){
		return driver.findElement(nseLogo);	
}


}

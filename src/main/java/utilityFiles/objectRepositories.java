package utilityFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class objectRepositories {

	WebDriver driver;
	@FindBy(xpath="//a[text()='Rankings']")
	private WebElement ranking;
	
	
	@FindBy(xpath="//div[text()='ODI']")
	private WebElement odiButton;
 
	public objectRepositories(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

 public void clickRanking()
 {
	 ranking.click();
 }
 

 public void clickODIbutton()
 {
	 odiButton.click();
 }
 
 public String getCountryByPlayerName(String playerName)
 {
	 WebElement countryName=driver.findElement(By.xpath("//div[text()='"+playerName+"']/following-sibling::div"));
	 return countryName.getText();
 }
 
 public String getPointsByPlayerName(String playerName)
 {
	 WebElement ratingPoints=driver.findElement(By.xpath("//div[text()='"+playerName+"']/../../following-sibling::div"));
	 return ratingPoints.getText();
 }
 

}

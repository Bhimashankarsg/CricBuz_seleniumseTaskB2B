package cricBuzTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utilityFiles.BaseClass;
import utilityFiles.ListenerImplClass;
import utilityFiles.UtilityClassObject;
import utilityFiles.objectRepositories;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Listeners(ListenerImplClass.class)
public class playersDetailsTest  extends BaseClass {

	@Test
	public void playersTest()
	{
		UtilityClassObject.getTest().info("Launced the browser");
		objectRepositories objCricBuz=new objectRepositories(driver);
		objCricBuz.clickRanking();
		UtilityClassObject.getTest().info("clicked on ranking menu");
		objCricBuz.clickODIbutton();
		UtilityClassObject.getTest().info("clicked on odi button");
		
		String playerName=pf.getPlayerName();
		UtilityClassObject.getTest().info("Get player name : <b>"+playerName);
		String playerCountry=objCricBuz.getCountryByPlayerName(playerName);
		UtilityClassObject.getTest().info(" Get "+playerName+" 's Country name : <b>"+playerCountry);
		String playerRatingPoints=objCricBuz.getPointsByPlayerName(playerName);
		UtilityClassObject.getTest().info(" Get Rating of "+playerName+" 's points : <b>"+playerRatingPoints);
		System.out.println(playerName+" - "+playerCountry+"-"+playerRatingPoints);
		UtilityClassObject.getTest().pass(
	            "Player Details => "
	            + playerName + " | "
	            + playerCountry + " | "
	            + playerRatingPoints);
		
		
	}
}

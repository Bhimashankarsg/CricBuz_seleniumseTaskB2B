package utilityFiles;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;

public class propertyFile
{
	public String getPlayerName()  {
		try {
	Properties pos=new Properties();
	FileInputStream fos=new FileInputStream("./src/test/resources/playerName.propertie");
	pos.load(fos);
	String playerName=pos.getProperty("playerName");
	return playerName;
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
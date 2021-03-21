package dockerGRIDtest;

import java.net.MalformedURLException;
import java.net.URL;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RunDockerGrid {
	
	WebDriver driver;
	
	@Parameters({"Port"})
	
	@BeforeClass
	@Test
	public void initiateDriver(String Port) throws MalformedURLException {
        if(Port.equalsIgnoreCase("9003"))
{
    driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    System.out.println("Chrome Browser Launching..");
    driver.manage().window().maximize();
}
else if(Port.equalsIgnoreCase("9002")){
    driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.firefox());
    System.out.println("Firefox Browser Launching..");
    driver.manage().window().maximize();
}
}
	
	
	
	
	
}

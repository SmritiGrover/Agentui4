import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;
public class Progressive extends Home_page
{
	public static void pro() throws Exception
	{
		Logger log=Logger.getLogger("Progressive button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start pogressive button   test case");
		  Thread.sleep(1000);
		  if(isElementPresent(By.name("switchProgressive")))
		  {
			  driver.findElement(By.name("switchProgressive")).click();
			  System.out.println("click on progressive");
		  }
		  else
			 {
				 screen(driver," Progressive button not found ");
			 }
     }
	public static void  extent_()
    {
		Logger log=Logger.getLogger("Progressive button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start pogressive button   test case extent report method");
    	 if(autoMode==0)
	       {
	     	 logger = extent.startTest("PROGRESSIVE ");
	 	     //Assert.assertTrue(true);
	    	 logger.log(LogStatus.PASS, "Progressive  test case is pass ");
	    	 logger.log(LogStatus.PASS, " autoMode  from agent_live table ::\t"+autoMode);
	    	 logger.log(LogStatus.PASS, " dialer_type from agent live table  before click on PROGRESSIVE button ::\t"+dialer_type_before_pre);
	    	 logger.log(LogStatus.PASS, " dialer_type from agent live table ::\t"+dialer_type);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
	      }
	     else
	      {
	   	   logger = extent.startTest("PROGRESSIVE ");
           logger.log(LogStatus.FAIL, "Progressive  test case is fail because some data not available in data base");
           logger.log(LogStatus.FAIL, " autoMode  from agent_live table ::\t"+autoMode);
	 	   //Assert.assertTrue(true);
	    	 logger.log(LogStatus.FAIL, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
	 	   logger.log(LogStatus.FAIL, " dialer_type from agent live table  ::\t"+dialer_type);
	      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
	      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
	     
        System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
	      }
    }
}

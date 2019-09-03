 import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;


public class Preview_button extends Home_page
{
	public static void pre_() throws Exception
	{
		Logger log=Logger.getLogger("Preview button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start preview button   test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("switchPreview")))
		 {
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.document.getElementById('progressiveMode').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			  System.out.println("click on preview");
		}
		 else
		 {
			 screen(driver," Preview button not found ");
		 }
//		  Thread.sleep(2000);
//		  if(isElementPresent(By.name("switchProgressive")))
//		  {
//			  driver.findElement(By.name("switchProgressive")).click();
//			  System.out.println("click on progressive");
//		  }
	 
   }
	public static void  extent_()
	    {
		Logger log=Logger.getLogger("Preview button test case extent report method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start preview button   test case extent report");
	    	 if(dialer_type.equals("PREVIEW"))
		       {
		     	 logger = extent.startTest("Preview ");
		 	     //Assert.assertTrue(true);
		    	 logger.log(LogStatus.PASS, "Preview  test case is pass ");
		    	 logger.log(LogStatus.PASS, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
		    	 logger.log(LogStatus.PASS, " dialer_type from agent live table ::\t"+dialer_type);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
		      }
		     else
		      {
		   	   logger = extent.startTest("PREVIEW ");
		 	   //Assert.assertTrue(true);
		    	 logger.log(LogStatus.FAIL, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
                logger.log(LogStatus.FAIL, "Preview  test case is fail because some data not available in data base");
		 	   logger.log(LogStatus.FAIL, " dialer_type from agent live table  ::\t"+dialer_type);
		      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
		      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
		     
	        System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
		      }
	    }
}



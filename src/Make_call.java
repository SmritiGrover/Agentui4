
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
public class Make_call extends Home_page
{
	public static  String number1,add_agent;
	public static int call_count_excel,f;
	public static void call() throws InterruptedException
	{
		Logger log=Logger.getLogger("Make call test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start make call  test case");
		//Thread.sleep(2000);
		if(isElementPresent(By.name("switchPreview")))
		 {
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.document.getElementById('progressiveMode').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			  System.out.println("click on break");
		}
		 else
		 {
			 screen(driver," preview button not found ");
		 }
		
		 Hs=Hw.getSheet("Sheet1");
		 call_count_excel=Hs.getLastRowNum();
		  System.out.println("total number in excel\t "+call_count_excel);
		 number1=Hs.getRow(1).getCell(1).getStringCellValue();
		 System.out.println("phone number from excel sheet"+number1);
		//Make a new call
		if(isElementPresent(By.name("makeNewCall")))
		{
			//Thread.sleep(1000);
			driver.findElement(By.name("makeNewCall")).click();
			System.out.println("click on ready button");
          //  String number=Hs.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.name("manualPhoneNo")).clear();
		    driver.findElement(By.name("manualPhoneNo")).sendKeys(number1);
			//driver.findElement(By.name("manualDial")).click();
		    Thread.sleep(6000);	
		    driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		 else
		 {
			 screen(driver," Makecall button not found ");
		 }
		
		  //hold 
		  if(isElementPresent(By.id("holdButton")))
        {
			      Thread.sleep(1000); 
				 driver.findElement(By.id("holdButton")).click();
				 System.out.println("click on hold button");
				 Thread.sleep(1000); 
			 }
		  else
			 {
				 screen(driver," Hold button not found ");
			 }
		//  unhold   
		  if(isElementPresent(By.id("holdButton")))
           {
			   //   Thread.sleep(1000); 
				 driver.findElement(By.id("holdButton")).click();
				 System.out.println("click on hold button");
				 Thread.sleep(500); 
			 }
		  else
			 {
				 screen(driver," Unhold button not found ");
			 }
	      //Add customer  
	      if(isElementPresent(By.xpath(("//input[@value='Add Customer' and @type='submit']")))){
	    	  
	    	  driver.findElement(By.xpath("//input[@value='Add Customer' and @type='submit']")).click();
			  System.out.println("click on Add customer");
			   Thread.sleep(1000); 
			  assertTrue(closeAlertAndGetItsText().matches( "^Are you sure you want to create a Lead[\\s\\S]$"));
			  Data();
			  Thread.sleep(1000);
			  if(lead_id>0&&L_id_f_exte>0&&L_id_f_D_lookup>0&&L_id_f_state>0)
			  {
				  f=1;
			  }
			  else
		    	 {
		    		 f=0;
		    	 }
			
	      }
	      else
			 {
				 screen(driver," add customer button not found ");
			 }
	
	
		
	           //scroll down
	      if(isElementPresent(By.xpath(("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"))))
	      {
	      Thread.sleep(1000);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      WebElement element =driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"));
	      js.executeScript("arguments[0].scrollIntoView(true);", element);
	      }
	     Thread.sleep(500);	
		  //Enter comment
		  if(isElementPresent(By.name("txt")))
		  {
			  driver.findElement(By.name("txt")).clear();
			  driver.findElement(By.name("txt")).sendKeys("test_C_zentrix");
			  Thread.sleep(500);
		  }
		  else
			 {
				 screen(driver," Comment box not visible not found ");
			 }
		
		  //Dispositions       
		  Select sel=new Select(driver.findElement(By.name("custDisposition")));
		         sel.selectByVisibleText("simi");
		  
		         
		   //save information
		         if(isElementPresent(By.name("saveInfo")))
		           {
						 driver.findElement(By.name("saveInfo")).click();
						 System.out.println("click on save information  button");
						 Thread.sleep(1000);
						 
				  }
		         else
				 {
					 screen(driver," Save information button not found ");
				 }
		  //disconnect call
           if(isElementPresent(By.name("disconnect")))
           {
				 driver.findElement(By.name("disconnect")).click();
				 System.out.println("click on disconnect button");
				 
		  }
           else
  		 {
  			 screen(driver," Disconnect button not found ");
  		 }
		}

	public static void  extent_()//&&phone_no.equals(number1)&&p_no_f_extended.equals(number1)&&p_f_d_lookup.equals(number1)&&p_no_F_d_state.equals(number1)
    {
		Logger log=Logger.getLogger("make_call test case extent report method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start make_call  test case extent report method");
    	 if(is_hold==0&&lead_id>0&&L_id_f_exte>0&&L_id_f_D_lookup>0&&L_id_f_state>0)
	       {
	     	 logger = extent.startTest("Make new call ");
	 	     //Assert.assertTrue(true);
	    	 logger.log(LogStatus.PASS, "Make new call  test case is pass ");
	    	 logger.log(LogStatus.PASS, " is_hold from agent_live table  before click on hold button ::\t"+is_hold);
	    	 logger.log(LogStatus.PASS, " lead_id  from customer_1609 table ::\t"+lead_id);
	    	 logger.log(LogStatus.PASS, " phone_no  from customer_1609 table ::\t"+phone_no);
	    	 logger.log(LogStatus.PASS, " Lead id from extended_customer_1609 table ::\t"+L_id_f_exte);
	    	 logger.log(LogStatus.PASS, " Phone number from extended_customer_1609 table ::\t"+p_no_f_extended);
	    	 logger.log(LogStatus.PASS, " Lead id from dial_lead_lookup_1609 table ::\t"+L_id_f_D_lookup);
	     	 logger.log(LogStatus.PASS, " Phone number  from dial_lead_lookup_1609 table ::\t"+p_f_d_lookup);
	    	 logger.log(LogStatus.PASS, " Lead id from dial_state_1609 table ::\t"+L_id_f_state);
	    	 logger.log(LogStatus.PASS, " Phone number  from dial_state_1609 table ::\t"+p_no_F_d_state);
	    	if(agent_state.equals("FREE"))
	    	{
	    		 logger.log(LogStatus.PASS, " Disconnect Successful   agent status from agent_live table::\t"+agent_state);
	    	}
	    	else
	    	{
	    		 logger.log(LogStatus.FAIL, " Disconnect  not Successful   agent status from agent_live table::\t"+agent_state);

	    	}
	    	 if(f==1)
	    	 {
	    		 logger.log(LogStatus.PASS, "Customer added");
	    	 }
	    	 else
	    	 {
	    		 f=0;
	    		 logger.log(LogStatus.FAIL, "customer not add");
	    	 }
	    	 if(current_report.equals("simi"))
			   {
	    		 logger.log(LogStatus.PASS, "Disposition added, disposition name is ::\t"+current_report);
				   
			   }
	    	 else{ logger.log(LogStatus.FAIL, "Disposition not added, disposition name is ::\t"+current_report);}
	       
           }
	     else
	      {
	   	   logger = extent.startTest("Make new call ");
	 	   //Assert.assertTrue(true);
	   	 logger.log(LogStatus.FAIL, "Make new call  test case is fail ");
	   	 logger.log(LogStatus.FAIL, " is_hold from agent_live table  before click on hold button ::\t"+is_hold);
    	 logger.log(LogStatus.FAIL, " lead_id  from customer_1609 table ::\t"+lead_id);
    	 logger.log(LogStatus.FAIL, " phone_no  from customer_1609 table ::\t"+phone_no);
    	 logger.log(LogStatus.FAIL, " Lead id from extended_customer_1609 table ::\t"+L_id_f_exte);
    	 logger.log(LogStatus.FAIL, " Phone number from extended_customer_1609 table ::\t"+p_no_f_extended);
    	 logger.log(LogStatus.FAIL, " Lead id from dial_lead_lookup_1609 table ::\t"+L_id_f_D_lookup);
    	 logger.log(LogStatus.FAIL, " Phone number  from dial_lead_lookup_1609 table ::\t"+p_f_d_lookup);
    	 logger.log(LogStatus.FAIL, " Lead id from dial_state_1609 table ::\t"+L_id_f_state);
    	 logger.log(LogStatus.FAIL, " Phone number  from dial_state_1609 table ::\t"+p_no_F_d_state);
    		if(agent_state.equals("FREE"))
	    	{
	    		 logger.log(LogStatus.PASS, " Disconnect Successful   agent state from agent_live table::\t"+agent_state);
	    	}
	    	else
	    	{
	    		 logger.log(LogStatus.FAIL, " Disconnect  not Successful   agent state from agent_live table::\t"+agent_state);

	    	}
    	 if(f==1)
    	 {
    		 logger.log(LogStatus.PASS, "Customer added");
    	 }
    	 else
    	 {
    		 f=0;
    		 logger.log(LogStatus.FAIL, "customer not add");
    	 }
    	 if(current_report.equals("simi"))
		   {
  		 logger.log(LogStatus.PASS, "Disposition added, disposition name is ::\t"+current_report);
			   
		   }
  	 else{ logger.log(LogStatus.FAIL, "Disposition not added, disposition name is ::\t"+current_report);}
         System.out.println("Make new call test case is fail because some data not available in data base(some column missing in table campaign)");
	      }
    }

}

 
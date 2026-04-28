package Bank_Project;

import org.testng.annotations.Test;

import Agile_Project.agileProject;
import Baseclass.baseClass;

public class bankConnect extends baseClass {

	 @Test
	    public void bankFlowTest() {

	        // Setup browser

	        bankLogin login = new bankLogin();

	        login.loginTest();
	        
	        newCusto cutmr=new newCusto();
	        cutmr.newRegistr();
	        cutmr.testInvalidName();
	        cutmr.testInvalidPIN();
	        cutmr.testPhoneValidation();
	        cutmr.emailValidationDisplayedTest();
	        cutmr.logout();     
	        
	    }

}

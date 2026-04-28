package Payment_Project;

import org.testng.annotations.Test;

import Baseclass.baseClass;

public class paymentConnect extends baseClass  {
	@Test
	
	public void PaymentFlowTest() throws Exception {
		 paymentTest payment=new paymentTest();
		    payment.menuCheck();
		    payment.generateCard();
		    payment.creditCard();
		    payment.verifyDropdownClickable();
		    payment.paymentPage();
		    payment.validateEmptyFieldMessage();
		    payment.validateCardNumber();
		    payment.validateInvalidCVV();
		   
		    
}
}

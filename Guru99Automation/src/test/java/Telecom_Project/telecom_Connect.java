package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Baseclass.baseClass;
import Payment_Project.paymentTest;

public class telecom_Connect extends baseClass {

	@Test
	
	public void TelecomFlowTest() {

	    add_Customer customer = new add_Customer(driver);

	    customer.verifyOptions();
	    customer.addCustomer();
	    customer.submitWithoutMandatoryFields();
	    customer.validateAllFieldsWithNegativeData();

//	    // Step 4: Assign tariff
	    addTariffPlanCustomer addTariff = new addTariffPlanCustomer(driver);
	    addTariff.assignTariffPlan();
	    
	    addTariffPlan addTarif= new addTariffPlan();
	    addTarif.add();
	    addTarif.emptyFieldValidation();
	    addTarif.invalidInputValidation();
	    addTarif.negativeValueTest();
	    
	    payBilling pay=new payBilling(driver);
	    pay.customerId();
	    pay.invalidCustomerIdTest();
	    pay.validCustomerIdTest();
//	    
	    
	    paymentTest payment=new paymentTest();
	    payment.menuCheck();
	    
	}}

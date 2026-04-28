package tests;

import Baseclass.baseClass;
//import Mainproject.Insurance;
import Mainproject.Selenium;


public class InsurancProject {

    public static void main(String[] args) throws InterruptedException {

    	baseClass.setup();
    	// --- OPTIONAL: RUN TEST SITE AFTER ---
    	Selenium selenium = new Selenium();
    	selenium.testDropdown();
    	
    	// --- INSURANCE FLOW ---
//    	Insurance.Register();
//    	Insurance.Login();
//    	Insurance.requestQuotation();
//    	Insurance.retrieveQuotation();
//    	Insurance.editProfile();

    	

    	//baseClass.close();
        
    }
}
package Agile_Project;

import org.testng.annotations.Test;
import Agile_Project.agileProject;
import Baseclass.baseClass;

public class agileConnect extends baseClass{

    @Test
    public void agileFlowTest() {

        // Setup browser

        agileProject agile = new agileProject();

        agile.login();
        agile.miniStatement();
        agile.logout();
    }
}
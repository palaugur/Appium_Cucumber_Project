package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static Utilities.GWD.closeApp;



public class Hooks {

    @Before
    public void before(){
        //System.out.println("Scenario Started!");
    }
    @After
    public void after(){
        //System.out.println("Scenario Finished!");
        closeApp();
    }
}

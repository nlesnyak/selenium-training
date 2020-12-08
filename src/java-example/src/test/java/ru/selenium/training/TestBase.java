package ru.selenium.training;

import org.junit.After;
import org.junit.Before;

public class TestBase {

    public ApplicationManager app = new ApplicationManager();

    @Before
    public void start() {
        app.init();
    }

    @After
    public void stop(){
        app.stopDriver();
    }

}

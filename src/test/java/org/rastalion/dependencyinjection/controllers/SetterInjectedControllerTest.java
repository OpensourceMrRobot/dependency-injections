package org.rastalion.dependencyinjection.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rastalion.dependencyinjection.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    /*
    Tests are not correct anymore and are more to demonstrate what Spring is doing under the covers
    to wire up the right dependencies.
     */

    private SetterInjectedController setterInjectedController;

    @BeforeEach
    public void setUp() throws Exception {
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.DOING_GREAT, setterInjectedController.sayHello());
    }

    @AfterEach
    void tearDown() {
        setterInjectedController = null;
    }
}
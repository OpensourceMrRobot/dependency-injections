package org.rastalion.dependencyinjection.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rastalion.dependencyinjection.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    /*
    Tests are not correct anymore and are more to demonstrate what Spring is doing under the covers
    to wire up the right dependencies.
     */

    private PropertyInjectedController propertyInjectedController;

    @BeforeEach
    public void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.DOING_GREAT, propertyInjectedController.sayHello());
    }

    @AfterEach
    void tearDown() {
        propertyInjectedController = null;
    }
}
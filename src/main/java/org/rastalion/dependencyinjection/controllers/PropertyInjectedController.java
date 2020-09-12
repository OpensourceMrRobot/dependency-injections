package org.rastalion.dependencyinjection.controllers;

import org.rastalion.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    /*
    When you use the @Qualifier annotation Spring won't be using reflection anymore to figure out
    which bean you maybe meant.
     */
    @Autowired
    @Qualifier("greetingServiceImpl")  // Comment to see the difference
    public GreetingService greetingServiceImpl;

    public String sayHello() {
        return greetingServiceImpl.sayGreeting();
    }
}

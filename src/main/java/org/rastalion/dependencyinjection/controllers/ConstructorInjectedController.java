package org.rastalion.dependencyinjection.controllers;

import org.rastalion.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    public GreetingService greetingService;

    /*
    We need to use the bean name to qualify the bean we want injected here,
    these bean names follow the Java naming convention for variables [hence it starting with lowercase]

     Showing that the @Autowired annotation is not needed in the constructor dependency injection,
     but remember to place it for good practices!
     */
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}

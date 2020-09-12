package org.rastalion.dependencyinjection.controllers;

import org.rastalion.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    /*
    We can use the @Qualifier annotation at the top of our method,
    or just like we did here on the parameter itself here.

    Removing the @Autowired annotation will brake the code ;)
     */
    @Autowired
    public void setGreetingService(@Qualifier("setterGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}

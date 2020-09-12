package org.rastalion.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String DOING_GREAT = "Hello - Good use of the @Qualifier annotation, well done!";

    @Override
    public String sayGreeting() {
        return DOING_GREAT;
    }
}

package org.rastalion.dependencyinjection.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello - Primary Greeting service";
    }

    @Override
    public String getGermanGreeting() {
        return "Hallo - Primärer Begrüßungsdienst";
    }

    @Override
    public String getDutchGreeting() {
        return "Hallo - Primaire begroetingsservice";
    }
}

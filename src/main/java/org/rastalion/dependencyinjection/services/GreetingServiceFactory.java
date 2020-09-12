package org.rastalion.dependencyinjection.services;

public class GreetingServiceFactory {

    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String language) {
        switch (language) {
            case "de":
                return new PrimaryGermanGreetingService(greetingRepository);
            case "nl":
                return new PrimaryDutchGreetingService(greetingRepository);
            default:
                return new PrimaryGreetingService(greetingRepository);
        }
    }
}

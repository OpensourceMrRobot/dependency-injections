package org.rastalion.dependencyinjection.services;

public class PrimaryDutchGreetingService implements GreetingService{

    private GreetingRepository greetingRepository;

    public PrimaryDutchGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getDutchGreeting();
    }
}

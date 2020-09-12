package org.rastalion.dependencyinjection.config;

import org.rastalion.dependencyinjection.services.GreetingRepository;
import org.rastalion.dependencyinjection.services.GreetingService;
import org.rastalion.dependencyinjection.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository repository) {
        return new GreetingServiceFactory(repository);
    }

    /*
    This makes a cleaner configuration possible,
    it is especially useful when dealing with more complex configurations.

    This makes it so that instead of all the annotations scattered over all possible classes
    we can manage it in one central class.
     */

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("nl")
    GreetingService primaryDutchGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("nl");
    }

    @Bean
    @Primary
    @Profile("de")
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("de");
    }

}

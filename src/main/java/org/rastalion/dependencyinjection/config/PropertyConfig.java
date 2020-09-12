package org.rastalion.dependencyinjection.config;

import org.rastalion.dependencyinjection.examplebeans.FakeDataSource;
import org.rastalion.dependencyinjection.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${rasta.username}")
    String user;

    @Value("${rasta.password}")
    String password;

    @Value("${rasta.dburl}")
    String url;

    @Value("${rasta.jms.username}")
    String jmsUser;

    @Value("${rasta.jms.password}")
    String jmsPassword;

    @Value("${rasta.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setUrl(jmsUrl);
        return fakeJmsBroker;
    }
}

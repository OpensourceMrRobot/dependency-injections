package org.rastalion.dependencyinjection;

import org.rastalion.dependencyinjection.controllers.ConstructorInjectedController;
import org.rastalion.dependencyinjection.controllers.SetterInjectedController;
import org.rastalion.dependencyinjection.controllers.MyController;
import org.rastalion.dependencyinjection.controllers.PropertyInjectedController;
import org.rastalion.dependencyinjection.examplebeans.FakeDataSource;
import org.rastalion.dependencyinjection.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

        System.out.printf("db username: %s %n", fakeDataSource.getUser());
        System.out.printf("db password: %s %n", fakeDataSource.getPassword());
        System.out.printf("db url: %s %n", fakeDataSource.getUrl());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);

        System.out.printf("JMS username: %s %n", fakeJmsBroker.getUser());
        System.out.printf("JMS password: %s %n", fakeJmsBroker.getPassword());
        System.out.printf("JMS url: %s %n", fakeJmsBroker.getUrl());
    }

}

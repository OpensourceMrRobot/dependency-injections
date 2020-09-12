package org.rastalion.dependencyinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
This class is so that we can see the lifecycle of beans and how we can hook into them
using the different CallBack Interfaces that allow us to do this.

Spring Bean life Cycle:

1. Instantiate
2. Populate Properties
3. Call setBeanName of BeanNameAware
4. Call setBeanFactory of BeanFactoryAware
5. Call setApplicationContext of ApplicationContextAware
6. Preinitalization [BeanPostProcessors, check out CustomBeanPostProcessor]
7. afterPropertiesSet of InitializingBean
8. Custom Init Method
9. Post Initialization [BeanPostProcessors, check out CustomBeanPostProcessor]

Bean is Ready to use

After container get's shutdown:

1. Call destroy of DisposableBean
2. Call Custom Destroy Method

Commented out the @Component annotation to reduce the noise.
 */

//@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware{


    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor");
    }
}
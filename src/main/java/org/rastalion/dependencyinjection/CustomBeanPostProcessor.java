package org.rastalion.dependencyinjection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*
Here we can hook into the BeanPostProcessor and we can do some

Commented out the @Component annotation to reduce the noise.
 */

//@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof LifeCycleDemoBean){
            ((LifeCycleDemoBean) bean).beforeInit();
            System.out.println("## Inside: postProcessBeforeInitialization in class: CustomBeanPostProcessor");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof LifeCycleDemoBean){
            ((LifeCycleDemoBean) bean).afterInit();
            System.out.println("## Inside: postProcessAfterInitialization in class: CustomBeanPostProcessor");
        }

        return bean;
    }
}

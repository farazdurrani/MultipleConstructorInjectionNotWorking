package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ConstructorInjectComponentConfiguration {
    @Bean("instance1")
    @Autowired(required = true)
    @ConditionalOnMissingBean(InjectionServiceThree.class)
    public ConstructorInjectComponent instance1(InjectionServiceOne injectionServiceOne,
                                                InjectionServiceTwo injectionServiceTwo) {
        return new ConstructorInjectComponent(injectionServiceOne, injectionServiceTwo);

    }

    @Bean("instance2")
    @Autowired(required = true)
    @ConditionalOnBean(InjectionServiceThree.class)
    public ConstructorInjectComponent instance2(InjectionServiceThree injectionServiceThree) {
        return new ConstructorInjectComponent(injectionServiceThree);

    }
}

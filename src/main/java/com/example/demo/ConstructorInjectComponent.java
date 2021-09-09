package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Optional;

/**
 * 
 * @author faraz
 * 
 * As per the documentation at
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation
 * : Only one annotated constructor per class can be marked as required, but
 * multiple non-required constructors can be annotated. In that case, each is
 * considered among the candidates and Spring uses the greediest constructor
 * whose dependencies can be satisfied — that is, the constructor that has the
 * largest number of arguments. The constructor resolution algorithm is the same
 * as for non-annotated classes with overloaded constructors, just narrowing the
 * candidates to annotated constructors.
 * 
 * But I find this to be untrue.
 * 
 */
public class ConstructorInjectComponent {

	private InjectionServiceOne injectionServiceOne;

	private InjectionServiceTwo injectionServiceTwo;
	
	private InjectionServiceThree injectionServiceThree;

	public ConstructorInjectComponent(InjectionServiceOne injectionServiceOne,
			InjectionServiceTwo injectionServiceTwo) {
		this.injectionServiceOne = injectionServiceOne;
		this.injectionServiceTwo = injectionServiceTwo;
	}

	public ConstructorInjectComponent(InjectionServiceThree injectionServiceThree) {
		this.injectionServiceThree = injectionServiceThree;
	}
	
	@Scheduled(fixedRate = 1000L)
	public void allFieldsConstructorInjectionTest() {
		System.err.println("constructorInjection "
				+ Optional.ofNullable(injectionServiceOne).map(InjectionServiceOne::method) + " "
				+ Optional.ofNullable(injectionServiceTwo).map(InjectionServiceTwo::method) + " "
				+ Optional.ofNullable(injectionServiceThree).map(InjectionServiceThree::method));
	}

}

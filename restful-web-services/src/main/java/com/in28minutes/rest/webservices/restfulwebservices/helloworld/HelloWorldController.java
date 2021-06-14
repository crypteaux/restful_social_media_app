package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController	
public class HelloWorldController {

//GET
//URI - /hello-world
	
	@Autowired
	private MessageSource messageSource;
	
	//Method -  "Hello World"
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorlBean() {
		return new HelloWorldBean("hello world");
	}
	
	//hello-world/path-variable/in28minutes
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
	return new HelloWorldBean(String.format("hello world %s", name));
			
		}
	
	//hello-world/path-variable/internationalized
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocaleContext().getLocale());
			
		}
	
}


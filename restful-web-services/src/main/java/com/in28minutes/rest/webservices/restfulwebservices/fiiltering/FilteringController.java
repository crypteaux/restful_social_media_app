package com.in28minutes.rest.webservices.restfulwebservices.fiiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retreieveSomeBean() {
		return new SomeBean("value 1", "value 2,", "value 3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retreieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"),
							new SomeBean("value12","value34","value56"));
	}

}

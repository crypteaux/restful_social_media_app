package com.in28minutes.rest.webservices.restfulwebservices.fiiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// send in response: field1, field2
	@GetMapping("/filtering")
	public MappingJacksonValue retreieveSomeBean() {
		SomeBean someBean = new SomeBean("value 1", "value 2,", "value 3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.FilterExceptFilter.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);;

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
			mapping.setFilters(filters);
			
			return mapping;
	}
	//send in response: field2, field3
	@GetMapping("/filtering-list")
	public List<SomeBean> retreieveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
							new SomeBean("value12","value34","value56"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.FilterExceptFilter.filterOutAllExcept("field2", "field3");
		
		FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);;

		MappingJacksonValue mapping = new MappingJacksonValue(list);
			mapping.setFilters(filters);
		
		return list;
	}

}

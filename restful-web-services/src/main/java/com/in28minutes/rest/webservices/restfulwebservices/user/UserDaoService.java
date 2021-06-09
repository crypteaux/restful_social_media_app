package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
		static {
			users.add(new User(1, "August", new Date()));
			users.add(new User(2, "Stephanie", new Date()));
			users.add(new User(3, "Arty", new Date()));
			
		}
		
	public List <User> findall(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findeOne(int id){
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}

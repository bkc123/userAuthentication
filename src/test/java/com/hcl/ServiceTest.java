package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;

import com.hcl.model.User;
import com.hcl.services.UserService;
import com.hcl.services.UserServiceImpl;

@DataJpaTest
class ServiceTest {

	static User user;

	@TestConfiguration
	static class ServiceImplTestContextConfiguration {
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

    @Autowired
	UserServiceImpl service;

	@Test
	@Rollback(false)
	void saveTest() {
		user = new User();
		user.setId(2);
		user.setPassword("abcd123");
		user.setUsername("Tommy");
		user.setEmail("tommy@gang.com");
		service.save(user);
	User found = service.findByUsername("Tommy").get();
		assertEquals(user, found);
	}

	@Test
	void verifyLoginTest() {
		assertTrue(service.verifyLogin("Tommy", "abcd123"));

	}
}

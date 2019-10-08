/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/add")
	public User addNewUser (@RequestParam String name) {
		User n = new User(name);
		return userRepository.save(n);
	}

	@GetMapping(path="/all")
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path="/hello")
	public String hello() {
		return "hello!";
	}
}

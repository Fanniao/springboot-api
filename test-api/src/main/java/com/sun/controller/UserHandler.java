package com.sun.controller;


import com.sun.entity.User;
import com.sun.mapper.UserMapper;
import com.sun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserHandler {

	@Autowired
	private UserMapper userMapper;


	@GetMapping("/findAll")
	public List<User> findAll() {
		return userMapper.selectList(null);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable int id) {
		return userMapper.selectById(id);
	}

	@GetMapping("/delete/{id}")
	public boolean deleteById(@PathVariable int id) {
		return new UserService(userMapper).deleteById(id);
	}

	@PostMapping("/update")
	public boolean update(@RequestBody User user) {
		return new UserService(userMapper).updateUser(user);
	}

	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		System.out.println(user);
		UserService userService = new UserService(userMapper);
		return userService.addUser(user);
	}

}

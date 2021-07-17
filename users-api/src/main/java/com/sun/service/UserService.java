package com.sun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.entity.User;

import java.util.List;

public interface UserService {
	List<User> findAll();

	Page<User> findPage(Integer current, Integer size);

	User findById(Integer id);

	boolean addUser(User user);

	boolean delete(Integer id);

	boolean update(User user);
}

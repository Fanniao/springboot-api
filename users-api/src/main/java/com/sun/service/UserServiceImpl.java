package com.sun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.entity.User;
import com.sun.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {
		return userMapper.selectList(null);
	}

	@Override
	public Page<User> findPage(Integer current, Integer size) {
		Page<User> page = new Page<>(current, size);
		return userMapper.selectPage(page, null);
	}

	@Override
	public User findById(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public boolean addUser(User user) {
		return userMapper.insert(user) == 1;
	}

	@Override
	public boolean delete(Integer id) {
		return userMapper.deleteById(id) == 1;
	}

	@Override
	public boolean update(User user) {
		return userMapper.updateById(user) == 1;
	}
}

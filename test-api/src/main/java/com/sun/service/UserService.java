package com.sun.service;

import com.sun.entity.User;
import com.sun.mapper.UserMapper;

public class UserService {

	private UserMapper userMapper;

	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 插入用户信息
	 * @param user 用户信息
	 * @return true 插入成功, false 插入如失败
	 */
	public boolean addUser(User user){
		if (userMapper.selectById(user.getId()) == null && userMapper.insert(user) == 1)
				return true;
		return false;
	}

	/**
	 * 更新用户信息
	 * @param user 用户信息
	 * @return true 修改成功, false修改失败
	 */
	public boolean updateUser(User user){
		if (userMapper.updateById(user) == 1)
			return true;
		return false;
	}

	/**
	 * 删除指定id的用户信息
	 * @param id 用户id
	 * @return true 删除成功, false删除失败
	 */
	public boolean deleteById(int id) {
		if( userMapper.deleteById(id) == 1)
			return true;
		return false;
	}
}

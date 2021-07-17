package com.sun;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.entity.User;
import com.sun.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersApiApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void selectPage(){
		Page<User> page = new Page<>(1, 10);
		Page<User> userPage = userMapper.selectPage(page, null);
		System.out.println("total: " + userPage.getTotal());
		System.out.println("size: " + userPage.getSize());
		userPage.getRecords().forEach(System.out::println);

	}
}

package com.sun.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.entity.User;
import com.sun.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/findAll")
	public Map<String, Object> findAll() {
		HashMap<String, Object> map = new HashMap<>();
		List<User> userList = userService.findAll();
		if (userList != null) {
			map.put("success", true);
			map.put("total", userList.size());
			map.put("results", userList);
		} else {
			map.put("success", false);
			map.put("msg", "查询失败！");
		}
		return map;
	}

	@GetMapping("/findPage/{current}/{size}")
	public Map<String, Object> findPage(@PathVariable Integer current, @PathVariable Integer size) {
		HashMap<String, Object> map = new HashMap<>();
		Page<User> page = userService.findPage(current, size);
		if (page != null) {
			map.put("success", true);
			map.put("total", page.getTotal());
			map.put("current", page.getCurrent());
			map.put("size", page.getSize());
			map.put("results", page.getRecords());
		}
		return map;
	}

	@GetMapping("/findById/{id}")
	public Map<String, Object> findById(@PathVariable Integer id) {
		HashMap<String, Object> map = new HashMap<>();
		User user = userService.findById(id);
		if (user != null) {
			map.put("success", true);
			map.put("result", user);
		} else {
			map.put("success", false);
			map.put("msg", "查询失败！");
		}
		return map;
	}

	@PostMapping("/addUser")
	public Map<String, Object> addUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		if (userService.addUser(user)) {
			map.put("success", true);
			map.put("msg", "添加用户成功！");
		} else {
			map.put("success", false);
			map.put("msg", "添加用户失败！");
		}
		return map;
	}

	@GetMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<>();
		if (userService.delete(id)) {
			map.put("success", true);
			map.put("msg", "删除成功！");
		} else {
			map.put("success", false);
			map.put("msg", "删除失败！");
		}
		return map;
	}

	@PostMapping("/updateUser")
	public Map<String, Object> updateUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		if (userService.update(user)) {
			map.put("success", true);
			map.put("msg", "修改成功！！");
		} else {
			map.put("success", true);
			map.put("msg", "修改失败！");
		}
		return map;
	}

}

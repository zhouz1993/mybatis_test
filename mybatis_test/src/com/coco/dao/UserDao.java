package com.coco.dao;

import com.coco.entity.User;
/**
 * 第一种方式：程序员自己写接口，需要写实现类
 * @author Administrator
 *
 */
public interface UserDao {
	
	public User findUserByUsername(String name);
}

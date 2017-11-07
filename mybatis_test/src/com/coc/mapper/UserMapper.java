package com.coc.mapper;

import java.util.List;

import com.coco.entity.User;
/**
 * 第二种方式：官方推荐，按官方要求命名，不需要写实现类 
 * @author Administrator
 * @time 2017.11.02
 */
public interface UserMapper {
	
	public User findUserByUsername(String name);
	
	public List<User> findUserList();
}

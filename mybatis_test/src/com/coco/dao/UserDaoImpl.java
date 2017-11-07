package com.coco.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.coco.entity.User;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory= sqlSessionFactory;
	}
	
	@Override
	public User findUserByUsername(String name) {
		//注入SqlSessionFactory，调用SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//查询结果封装对象
		User user = sqlSession.selectOne("test.findUserByUsername", name);
				
	//	System.out.println(user);
		//关闭session 释放支援
		sqlSession.close();
		
		return user;
	}

}

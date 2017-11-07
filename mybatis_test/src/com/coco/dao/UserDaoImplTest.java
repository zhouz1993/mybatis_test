package com.coco.dao;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coco.entity.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	@Test
	public void test1() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserByUsername("王麻子22");
		System.out.println(user);
	}
}

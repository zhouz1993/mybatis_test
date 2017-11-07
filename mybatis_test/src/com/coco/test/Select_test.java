package com.coco.test;


import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coco.entity.User;
public class Select_test {
	private static final Logger LOG = LoggerFactory.getLogger(Select_test.class);

	/**
	 * 查询数据
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		
		String resource = "SqlMapConfig.xml";
				
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//查询结果封装对象
		User user = sqlSession.selectOne("test.findUserByUsername", "李四");
		
		System.out.println(user);
		
		sqlSession.close();
	}
	
	/**
	 * 插入数据
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		
		String resource = "SqlMapConfig.xml";
				
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建对象
		User user = new User();
		user.setName("王麻子2333");
		user.setPassword("asddad4563");
		user.setBirthday(new Date());
		user.setDescr("春风不度玉门关");
		
		sqlSession.insert("test.insertUser",user);
		// 提交
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}
	
	
}

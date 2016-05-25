package com.imooc.spring.transaction.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext3.xml")
public class Demo3 {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 在测试本方法前，请先修改jdbc.properties配置文件中的数据库，并按给定的sql语句建表
	 *
	 * 思路：使用AspectJ在XML中配置事务
	 *     1. 配置事务管理器
	 *     2. 既然是使用AspectJ，那么就要配置通知（Advice）
	 *     3. 在<aop:config>中定义切点（Pointcut），并和Advice整合
	 *
	 * 在这样配置之后，就可以在指定的Pointcut中使用配置的Advice了，
	 * 这个Advice完成的就是事务管理的功能。
	 */
	@Test
	public void testTransfer() {
		// 现在是可以正常转账状态，在AccountServiceImpl中解开第10行注释会发生异常，可以测试在异常发生时的事务处理结果
		accountService.transfer("aaa", "bbb", 100d);
		System.out.println("转账正常完成");
	}
}

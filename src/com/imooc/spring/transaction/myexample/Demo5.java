package com.imooc.spring.transaction.myexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext5.xml")
public class Demo5 {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 在测试本方法前，请先修改jdbc.properties配置文件中的数据库，并按给定的sql语句建表
	 *
	 * 说明：一般来说我喜欢这么配置
	 */
	@Test
	public void testTransfer() {
		// 现在是可以正常转账状态，在AccountServiceImpl中解开第15行注释会发生异常，可以测试在异常发生时的事务处理结果
		System.out.println("转账前账户余额：aaa --> " + accountService.query("aaa") + ", bbb --> " + accountService.query("bbb"));
		try {
			accountService.transfer("aaa", "bbb", 100d);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("转账后账户余额：aaa --> " + accountService.query("aaa") + ", bbb --> " + accountService.query("bbb"));
		}
	}
}

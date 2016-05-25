package com.imooc.spring.transaction.demo4;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// 如果在此处和transactionManager中都配置了propagation的话，会以此处为准（把required改成never试试）
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
//		int i = 10 / 0;
		accountDao.inMoney(in, money);
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}


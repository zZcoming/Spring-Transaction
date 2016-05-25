package com.imooc.spring.transaction.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // @Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
//		int i = 10 / 0;
		accountDao.inMoney(in, money);
	}

	@Override
	public Double query(String name) {
		return accountDao.query(name);
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}


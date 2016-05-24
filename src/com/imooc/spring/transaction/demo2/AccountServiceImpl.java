package com.imooc.spring.transaction.demo2;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		int i = 10 / 0;
		accountDao.inMoney(in, money);
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}

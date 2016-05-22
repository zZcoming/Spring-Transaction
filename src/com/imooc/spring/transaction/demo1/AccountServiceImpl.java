package com.imooc.spring.transaction.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by zZ on 2016/5/22.
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	private TransactionTemplate transactionTemplate;

	@Override
	public void transfer(final String out, final String in, final Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
//				int i = 10 / 0;
				accountDao.inMoney(in, money);
			}
		});
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
}

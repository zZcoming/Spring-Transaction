package com.imooc.spring.transaction.demo2;

public interface AccountService {

	/**
	 * 转账功能
	 *
	 * @param out   : 转出账户
	 * @param in    : 转入账户
	 * @param money : 转账金额
	 */
	public void transfer(String out, String in, Double money);
}

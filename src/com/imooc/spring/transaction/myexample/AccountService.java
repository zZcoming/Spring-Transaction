package com.imooc.spring.transaction.myexample;

public interface AccountService {

	/**
	 * 转账功能
	 *
	 * @param out   : 转出账户
	 * @param in    : 转入账户
	 * @param money : 转账金额
	 */
	public void transfer(String out, String in, Double money);

	/**
	 * 根据账户名查询账户的金额
	 *
	 * @param name : 账户名
	 * @return 账户余额
	 */
	public Double query(String name);
}

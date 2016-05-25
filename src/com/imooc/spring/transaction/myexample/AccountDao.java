package com.imooc.spring.transaction.myexample;

public interface AccountDao {

	/**
	 * 加钱
	 *
	 * @param in    : 加钱账户
	 * @param money : 增加的金额
	 */
	public void inMoney(String in, Double money);

	/**
	 * 扣钱
	 *
	 * @param out   : 扣钱账户
	 * @param money : 减少的金额
	 */
	public void outMoney(String out, Double money);

	/**
	 * 根据账户名查询账户的金额
	 *
	 * @param name : 账户名
	 * @return 账户余额
	 */
	public Double query(String name);
}

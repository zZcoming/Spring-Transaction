package com.imooc.spring.transaction.demo3;

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
}

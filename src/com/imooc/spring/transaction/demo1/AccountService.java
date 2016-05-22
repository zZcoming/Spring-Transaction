package com.imooc.spring.transaction.demo1;

/**
 * Created by zZ on 2016/5/22.
 */
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

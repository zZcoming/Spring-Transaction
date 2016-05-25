package com.imooc.spring.transaction.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository  // @Component
public class AccountDaoImpl implements AccountDao {

	// 使用JdbcTemplate可以简化对数据库的操作
	private JdbcTemplate jdbcTemplate;

	// 这个@Autowired一定要写到set方法上，因为和普通的set方法不同，这里的参数不是JdbcTemplate，而是DataSource
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void inMoney(String in, Double money) {
		this.jdbcTemplate.update(
				"update account set money = (money + ?) where name = ?",
				money, in);
	}

	@Override
	public void outMoney(String out, Double money) {
		this.jdbcTemplate.update(
				"update account set money = (money - ?) where name = ?",
				money, out);
	}

	@Override
	public Double query(String name) {
		return this.jdbcTemplate.queryForObject(
				"select money from account where name = ?",
				Double.class,
				name
		);
	}
}

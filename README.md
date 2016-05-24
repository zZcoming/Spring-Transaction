# Spring-Transaction
学习Spring事务管理时的源码

### demo1中的示例
* Demo1为测试示例
* 使用编程式事务管理
    1. DAO层通过JdbcTemplate来操作数据库，简化代码
    2. 使用org.springframework.transaction.support.TransactionTemplate管理事务
    并向TransactionTemplate中注入事务管理器
    3. 在Service层中直接调用TransactionTemplate的execute方法来执行业务

### demo2中的示例
1. Demo2为测试示例
2. 使用声明式事务管理
    1. 采用AOP的方式，通过配置org.springframework.transaction.interceptor.TransactionProxyFactoryBean来管理事务和生成代理
    注入需要代理的业务、事务管理器、事务的属性
    2. 使用生成的代理来执行业务

### 说明
* 所有的jar包都在lib文件夹下
* 所有文件编码格式统一为UTF-8
* 视频地址：http://www.imooc.com/learn/478

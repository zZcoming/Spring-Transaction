# Spring-Transaction
学习Spring事务管理时的源码

### 简单讲解
* 所有的demo都是以“转账（transfer）”为示例的
* dao层中有2个方法：inMoney和outMoney，分别对应“入账”和“出账”
* service层有1个方法：transfer，对应“转账”

转账分为两步：
 1. A账户扣钱
 2. B账户加钱

既然是 事务管理 ，那么测试的方法就是在第1步（outMoney(A, 100)）之后发生异常。
如果A账户的钱减少了，就说明事务管理没有生效（因为没有回滚（rollback）），反之则有效。

### demo1中的示例：使用事务管理模板（TransactionTemplate）来执行事务
* Demo1为测试示例
* 使用编程式事务管理
    1. DAO层通过JdbcTemplate来操作数据库，简化代码
    2. 使用org.springframework.transaction.support.TransactionTemplate管理事务
    并向TransactionTemplate中注入事务管理器
    3. 在Service层中直接调用TransactionTemplate的execute方法来执行业务

### demo2中的示例：使用TransactionProxyFactoryBean生成的代理来执行事务
 1. Demo2为测试示例
 2. 使用声明式事务管理
    1. 采用AOP的方式，通过配置org.springframework.transaction.interceptor.TransactionProxyFactoryBean来管理事务和生成代理
    注入需要代理的业务、事务管理器、事务的属性
    2. 使用生成的代理来执行业务

### demo3中的示例：使用AspectJ，基于XML的方式配置
 1. Demo3为测试示例
 2. 使用AspectJ，基于XML的方式配置
    1. 配置dataSource、Dao、Service
    2. 配置事务管理器
	3. 既然是使用AspectJ，那么就要配置通知（Advice）
	4. 在<aop:config>中定义切点（Pointcut），并和Advice整合

### demo4中的示例：使用AspectJ，基于注解的方式配置
 1. Demo4为测试用例
 2. 使用AspectJ，基于注解的方式配置
    1. 配置基本同demo3
    2. 不需要配置<aop:config>，转为使用<tx:annotation-driven>，并在其中配置transactionManager
    3. 在需要进行事务管理的class上写上注解@Transaction，spring就会使用transactionManager来进行事务管理了

### myexample中的示例：我习惯的配置方法
 1. Demo5为测试用例
 2. 将大部分配置转为注解配置
 3. 配置transactionManager、transactionAdvice（txAdvice），最后在<aop:config>中配置使用transactionManager的Pointcut
 4. 增加了查询的方法

### 说明
* 所有的jar包都在lib文件夹下
* 所有文件编码格式统一为UTF-8
* 视频地址：http://www.imooc.com/learn/478

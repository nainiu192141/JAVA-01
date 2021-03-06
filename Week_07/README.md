2、（必做）按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率。

```
//sql拼接+jdbc批量执行+preparestatment
//insertjdbcpstbatch(application);
//insertJDBC(application);
//jdbctemplate_batch
insertBigData(application);
//insertHikariCP(application);
//load data infile
//先队列后跑批
//改myisam引擎+ 批插入或者换InfoBright的loaddata
//生成sql文件，source导入
//setLocalInfileInputStream
insertLoadInputStream(application);
```

2、（必做）读写分离-动态切换数据源版本1.0

aop+AbstraactRoutingDataSource:

3、（必做）读写分离-数据库框架版本2.0

使用 ShardingSphere-jdbc 5.0.0-alpha 实现读写分离配置。


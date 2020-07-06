# springboot多数据源的配置和切换

- 主动回滚事务：
```TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();```

- AbstractRoutingDataSource
# 相关配置

```properties
mybatis-plus:
  mapper-locations:  classpath:**/mappers/*.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.gaoh.mybatisplus.entity
  global-config:
    # 数据库相关配置
    db-config:
      #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
      id-type: 2
      #字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
      field-strategy: 2
      #驼峰下划线转换
      db-column-underline: true
      #mp2.3+ 全局表前缀 mp_
      #table-prefix: mp_
      #刷新mapper 调试神器
      refresh-mapper: true
      #数据库大写下划线转换
      #capital-mode: true
      # Sequence序列接口实现类配置
      #key-generator: com.baomidou.mybatisplus.incrementer.OracleKeyGenerator
      #逻辑删除配置（下面3个配置）
      logic-delete-value: 1
      logic-not-delete-value: 0
      sql-injector: com.baomidou.mybatisplus.mapper.LogicSqlInjector
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
    #配置JdbcTypeForNull, oracle数据库必须配置
    jdbc-type-for-null: 'null'
```


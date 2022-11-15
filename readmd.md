# README
## Document

### QUARTZ
* https://segmentfault.com/a/1190000042250871
* https://www.jianshu.com/p/e0ed8877f98c

## Build
### MQ
```
docker run -d --name example_mq -p 15672:15672 -p 5672:5672 rabbitmq:3.8.14-management
```

### MySql
```
docker run -d --name example_sql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -e MYSQL_DATABASE=example mysql:5.6
```


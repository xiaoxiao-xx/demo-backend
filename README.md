# demo-backend
demo后台


## 安装

本项目依赖于RabbitMQ, 需要先安装RabbitMQ。  
安装RabbitMQ后, 在RabbitMQ的安装目录下的sbin目录(如C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.10\sbin) 下执行下面的命令以开启并启动必要的插件:
```
rabbitmq-plugins enable rabbitmq_management rabbitmq_web_stomp rabbitmq_stomp rabbitmq_web_stomp_examples
```
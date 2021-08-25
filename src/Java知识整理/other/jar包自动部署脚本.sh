#!/bin/bash
echo "切换到源码目录(目录自定义)"

cd /home/services/javaresource/ciic-ihr-upms

echo "开始git pull更新代码"

git pull

echo "开始 mvn clean install编译服务"

mvn clean install

echo "将编译好的jar包拷贝到指定目录下(目录和jar包名自定义)"

\cp /home/services/javaresource/ciic-ihr-upms/ciic-ihr-upms-service/target/ciic-ihr-upms-service-6.0.1-SNAPSHOT.jar  /home/services/javajar/ciic-ihr-upms


echo "已启动的服务进程关闭(根据服务名kill进程)"

kill -9 $(ps aux | grep ciic-ihr-upms | tr -s ' '| cut -d ' ' -f 2)

echo "已启动的服务进程关闭(根据端口号kill进程)"

kill -9 $(lsof -i:4098 |awk '{print $2}' | tail -n 2)

sleep 5

echo "切换到jar包目录准备启动服务(目录自定义)"

cd /home/services/javajar/ciic-ihr-upms

echo "nohup启动服务(jar包名自定义)"

nohup java -jar ciic-ihr-upms-service-6.0.1-SNAPSHOT.jar &

exit

#!/bin/bash
## $() - 方法，${} - 变量

## 开始
echo [INFO] ----------------------------- start --------------------------------------

## 获取入参，应用名称
application_name=$1
## 输出看一眼
echo application_name: ${application_name}

## 参数校验
if [ "$application_name" == "registry" ]||[ "$application_name" == "gateway" ]||[ "$application_name" == "turbine" ]||[ "$application_name" == "sleuth" ]||[ "$application_name" == "base" ]||[ "$application_name" == "log" ]||[ "$application_name" == "all" ];
then
    ## 参数判断
    if [ "$application_name" != "all" ];
    then

        ## 入口
        echo [INFO] ------------------------ 进入单个服务部署 ---------------------------------

        ## 1. 安装所有服务
        ## commons
        cd osc-commons/
        mvn clean install -Dmaven.test.skip=true
        mvn clean deploy -Dmaven.test.skip=true
        ## service
        cd ../osc-service/
        mvn clean install -Dmaven.test.skip=true

        if [ "$application_name" == "base" ]||[ "$application_name" == "log" ];
        then
            ## 2. 安装部署指定服务
            cd osc-$application_name-service/osc-$application_name-service-api/
            mvn clean deploy -Dmaven.test.skip=true
            cd ../osc-$application_name-service-core/
            mvn clean deploy -Dmaven.test.skip=true

            ## 3. 返回根目录
            cd ../../../
        else
            ## 2. 安装部署指定服务
            cd osc-$application_name-service/
            mvn clean deploy -Dmaven.test.skip=true
            
            ## 3. 返回根目录
            cd ../../
        fi

        ## 结束
        echo [INFO] ----------------------------- end --------------------------------------
        echo [INFO] ------------------------------------------------------------------------

    else

        ## 入口
        echo [INFO] ------------------------ 进入整个服务部署 ---------------------------------

        ## 1. 安装所有服务
        ## commons
        cd osc-commons/
        mvn clean install -Dmaven.test.skip=true
        mvn clean deploy -Dmaven.test.skip=true
        ## service
        cd ../osc-service/
        mvn clean install -Dmaven.test.skip=true

        ## 2. 挨个安装部署服务
        ## 注册中心
        cd osc-registry-service/
        mvn clean deploy -Dmaven.test.skip=true
        ## 网关
        cd ../osc-gateway-service/
        mvn clean deploy -Dmaven.test.skip=true
        ## 断路器聚合监控中心
        cd ../osc-turbine-service/
        mvn clean deploy -Dmaven.test.skip=true
        ## 链路跟踪监控中心
        cd ../osc-sleuth-service/
        mvn clean deploy -Dmaven.test.skip=true
        ## 基础工程
        cd ../osc-base-service/osc-base-service-api/
        mvn clean deploy -Dmaven.test.skip=true
        cd ../osc-base-service-core/
        mvn clean deploy -Dmaven.test.skip=true
        ## 日志工程
        cd ../../osc-log-service/osc-log-service-api/
        mvn clean deploy -Dmaven.test.skip=true
        cd ../osc-log-service-core/
        mvn clean deploy -Dmaven.test.skip=true

        ## 3. 返回根目录
        cd ../../../

        ## 结束
        echo [INFO] -------------------------- end -------------------------------------
        echo [INFO] ------------------------------------------------------------------------

    fi
else
    ## 入口
    echo [INFO] ------------------------ 参数不正确 ---------------------------------

    ## 结束
    echo [INFO] -------------------------- end -------------------------------------
    echo [INFO] ------------------------------------------------------------------------
fi



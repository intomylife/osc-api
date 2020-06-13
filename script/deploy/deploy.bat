@echo off

REM ## 开始
echo [INFO] ----------------------------- start --------------------------------------

REM ## 获取入参，应用名称
set application_name=%1%
REM ## 输出看一眼
echo application_name: %application_name%

REM ## 参数是否符合
REM set "is_true=false"
REM ## 输出看一眼
REM echo is_true: %is_true%

REM ## 参数校验
if "%application_name%" == "all" (

    REM ## 入口
    echo [INFO] ------------------------ 进入整个服务部署 ---------------------------------

    REM ## 1. 安装所有服务
    REM ## commons
    cd osc-commons/
    mvn clean install -Dmaven.test.skip=true
    mvn clean deploy -Dmaven.test.skip=true
    REM ## service
    cd ../osc-service/
    mvn clean install -Dmaven.test.skip=true

    REM ## 2. 挨个安装部署服务
    REM ## 注册中心
    cd osc-registry-service/
    mvn clean deploy -Dmaven.test.skip=true
    REM ## 网关
    cd ../osc-gateway-service/
    mvn clean deploy -Dmaven.test.skip=true
    REM ## 断路器聚合监控中心
    cd ../osc-turbine-service/
    mvn clean deploy -Dmaven.test.skip=true
    REM ## 链路跟踪监控中心
    cd ../osc-sleuth-service/
    mvn clean deploy -Dmaven.test.skip=true
    REM ## 基础工程
    cd ../osc-base-service/osc-base-service-api/
    mvn clean deploy -Dmaven.test.skip=true
    cd ../osc-base-service-core/
    mvn clean deploy -Dmaven.test.skip=true
    REM ## 日志工程
    cd ../../osc-log-service/osc-log-service-api/
    mvn clean deploy -Dmaven.test.skip=true
    cd ../osc-log-service-core/
    mvn clean deploy -Dmaven.test.skip=true

    REM ## 3. 返回根目录
    cd ../../../

    REM ## 结束
    echo [INFO] -------------------------- end -------------------------------------
    echo [INFO] ------------------------------------------------------------------------

) else (

    REM ## 入口
    echo [INFO] ------------------------ 进入单个服务部署 ---------------------------------

    REM ## 1. 安装所有服务
    REM ## commons
    cd osc-commons/
    mvn clean install -Dmaven.test.skip=true
    mvn clean deploy -Dmaven.test.skip=true
    REM ## service
    cd ../osc-service/
    mvn clean install -Dmaven.test.skip=true

    REM ## 参数校验
    if "%application_name%" == "registry" (
        
        REM ## 2. 安装部署指定服务
        cd osc-%application_name%-service/
        mvn clean deploy -Dmaven.test.skip=true
        
        REM ## 3. 返回根目录
        cd ../../

    ) else (

        if "%application_name%" == "gateway" (
            
            REM ## 2. 安装部署指定服务
            cd osc-%application_name%-service/
            mvn clean deploy -Dmaven.test.skip=true
            
            REM ## 3. 返回根目录
            cd ../../

        ) else (

            if "%application_name%" == "turbine" (
    
                REM ## 2. 安装部署指定服务
                cd osc-%application_name%-service/
                mvn clean deploy -Dmaven.test.skip=true
                
                REM ## 3. 返回根目录
                cd ../../

            ) else (

                if "%application_name%" == "sleuth" (
                    
                    REM ## 2. 安装部署指定服务
                    cd osc-%application_name%-service/
                    mvn clean deploy -Dmaven.test.skip=true
                    
                    REM ## 3. 返回根目录
                    cd ../../

                ) else (

                    if "%application_name%" == "base" (
                        
                        REM ## 2. 安装部署指定服务
                        cd osc-%application_name%-service/osc-%application_name%-service-api/
                        mvn clean deploy -Dmaven.test.skip=true
                        cd ../osc-%application_name%-service-core/
                        mvn clean deploy -Dmaven.test.skip=true

                        REM ## 3. 返回根目录
                        cd ../../../

                    ) else (

                        if "%application_name%" == "log" (
                            
                            REM ## 2. 安装部署指定服务
                            cd osc-%application_name%-service/osc-%application_name%-service-api/
                            mvn clean deploy -Dmaven.test.skip=true
                            cd ../osc-%application_name%-service-core/
                            mvn clean deploy -Dmaven.test.skip=true

                            REM ## 3. 返回根目录
                            cd ../../../

                        ) else (

                            REM ## 返回根目录
                            cd ../
                            
                            REM ## 入口
                            echo [INFO] ------------------------ 参数不正确 ---------------------------------

                            REM ## 结束
                            echo [INFO] -------------------------- end -------------------------------------
                            echo [INFO] ------------------------------------------------------------------------
                            
                        )

                    )

                )

            )

        )

    )

)

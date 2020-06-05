#!/bin/bash
## $() - 方法，${} - 变量

## 开始
echo [INFO] ----------------------------- start --------------------------------------

## 获取入参，版本号
new_versiont=$1
## 输出看一眼
echo new_versiont: ${new_versiont}

## 获取入参，是否需要备份（true | false）
is_bak=$2
## 输出看一眼
echo is_bak: ${is_bak}

## 非空判断
if [ $new_versiont ];
then

    ## 1. 更新 commons 工程版本号
    cd osc-commons/
    ## 获取当前工程的版本号
    ## old_version=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout) 
    ## 输出看一眼
    ## echo old_version: ${old_version}
    ## 升级
    mvn versions:set -DoldVersion=* -DnewVersion=${new_versiont} -DgenerateBackupPoms=${is_bak} && mvn clean install

    ## 2. 更新 service 工程中的 commons 工程版本号
    cd ../osc-service/
    ## 获取当前工程的版本号
    ## old_version=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout) 
    ## 输出看一眼
    ## echo old_version: ${old_version}
    ## 更新
    mvn versions:update-properties -DincludeProperties={osc.commons.version} -Dproperties=[${new_versiont}] -DgenerateBackupPoms=${is_bak}

    ## 3. 更新 service 工程版本号
    mvn versions:set -DoldVersion=* -DnewVersion=${new_versiont} -DgenerateBackupPoms=${is_bak}

    ## 结束
    echo [INFO] ----------------------------- end --------------------------------------

else

    ## 结束
    echo [INFO] -------------------------- 缺少参数 -------------------------------------

fi

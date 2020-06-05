@echo off

REM ## 开始
echo [INFO] ----------------------------- start --------------------------------------

REM ## 获取入参，版本号
set new_versiont=%1%
REM ## 输出看一眼
echo new_versiont: %new_versiont%

REM ## 获取入参，是否需要备份（true | false）
set is_bak=%2%
REM ## 输出看一眼
echo is_bak: %is_bak%

REM ## 非空判断
if defined new_versiont (
    REM ## 1. 更新 commons 工程版本号
    cd osc-commons/
    REM ## 获取当前工程的版本号
    REM for /f "delims=" %%i in ('..\old-version.bat') do set old_version=%%i
    REM ## 输出看一眼
    REM echo old_version: %old_version%
    REM ## 升级
    mvn versions:set -DoldVersion=* -DnewVersion=%new_versiont% -DgenerateBackupPoms=%is_bak% && mvn clean install

    REM ## 2. 更新 service 工程中的 commons 工程版本号
    cd ../osc-service/
    REM ## 获取当前工程的版本号
    REM for /f "delims=" %%i in ('..\old-version.bat') do set old_version=%%i
    REM ## 输出看一眼
    REM echo old_version: %old_version%
    REM ## 更新
    mvn versions:update-properties -DincludeProperties={osc.commons.version} -Dproperties=[%new_versiont%] -DgenerateBackupPoms=%is_bak%

    REM ## 3. 更新 service 工程版本号
    mvn versions:set -DoldVersion=* -DnewVersion=%new_versiont% -DgenerateBackupPoms=%is_bak%

    REM ## 结束
    echo [INFO] ----------------------------- end --------------------------------------
) else (
    REM ## 结束
    echo [INFO] -------------------------- 缺少参数 -------------------------------------
)

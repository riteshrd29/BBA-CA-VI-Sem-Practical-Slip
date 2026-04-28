@echo off
echo Running database program...
if not exist lib mkdir lib
echo.
echo Checking for database drivers...
if exist lib\mysql-connector-j*.jar (
    echo MySQL driver found
    java -cp "lib\mysql-connector-j*.jar;." %1
) else if exist lib\sqlite-jdbc*.jar (
    echo SQLite driver found
    java -cp "lib\sqlite-jdbc*.jar;." %1
) else (
    echo No database drivers found in lib folder
    echo Please download and place JDBC drivers in lib folder
    echo.
    echo MySQL: https://dev.mysql.com/downloads/connector/j/
    echo SQLite: https://github.com/xerial/sqlite-jdbc/releases
)
pause

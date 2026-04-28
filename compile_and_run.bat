@echo off
echo Compiling Java program...
javac %1.java
if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo Running program...
    java %1
) else (
    echo Compilation failed!
)
pause

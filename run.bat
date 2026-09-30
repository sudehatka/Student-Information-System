@echo off
chcp 65001 > nul
echo ===================================================
echo   Compiling Student Information System...
echo ===================================================
if not exist out mkdir out
javac -encoding UTF-8 -d out src/*.java
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Compilation failed!
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo ===================================================
echo   Running Simulation...
echo ===================================================
java -cp out Main
echo.
pause

# Running Java Programs from Command Line

## 1. Basic Java Setup

### Install Java Development Kit (JDK)
```cmd
# Download JDK from: https://www.oracle.com/java/technologies/downloads/
# Or use OpenJDK: https://adoptium.net/

# Verify installation
java -version
javac -version
```

### Set Environment Variables
```cmd
# Set JAVA_HOME (example for JDK 17)
set JAVA_HOME=C:\Program Files\Java\jdk-17

# Add to PATH
set PATH=%JAVA_HOME%\bin;%PATH%

# Make permanent (run as Administrator):
setx JAVA_HOME "C:\Program Files\Java\jdk-17"
setx PATH "%PATH%;%JAVA_HOME%\bin"
```

## 2. Running Basic Java Programs

### Compile and Run Single File
```cmd
# Navigate to your Java file directory
cd "C:\Users\Ritesh\Desktop\BBA CA VI Sem Practical Slip\BBA-CA-6th-Sem\Advanced-Java\Slip-05\Question 2"

# Compile
javac Q2_ProgramName.java

# Run
java Q2_ProgramName
```

### Compile and Run with Packages
```cmd
# If your file has a package declaration
javac -d . YourProgram.java
java your.package.name.YourProgram
```

### Compile with Classpath
```cmd
# For programs with external JAR files
javac -cp "lib/*.jar;" YourProgram.java
java -cp "lib/*.jar;." YourProgram
```

## 3. Database Programs from CMD

### MySQL Database Setup
```cmd
# Download MySQL Connector J: https://dev.mysql.com/downloads/connector/j/
# Place the JAR file in a lib folder

# Compile with MySQL driver
javac -cp "lib/mysql-connector-j-8.0.33.jar;" DatabaseProgram.java

# Run with MySQL driver
java -cp "lib/mysql-connector-j-8.0.33.jar;." DatabaseProgram
```

### SQLite Database (No installation needed)
```cmd
# Download SQLite JDBC: https://github.com/xerial/sqlite-jdbc/releases
# Place JAR in lib folder

javac -cp "lib/sqlite-jdbc-3.41.2.1.jar;" SQLiteProgram.java
java -cp "lib/sqlite-jdbc-3.41.2.1.jar;." SQLiteProgram
```

### Sample Database Connection Code
```java
import java.sql.*;

public class DatabaseExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "username";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 4. Applet Alternatives (Since Applet is Deprecated)

### Option 1: Swing Applications (Recommended)
```cmd
# Compile Swing program
javac TrafficSignalSwing.java

# Run
java TrafficSignalSwing
```

### Option 2: JavaFX Applications
```cmd
# Need JavaFX SDK: https://gluonhq.com/products/javafx/

javac --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls JavaFXApp.java
java --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls JavaFXApp
```

### Option 3: Web Applications (for browser-like experience)
```cmd
# Use embedded server like Spark Java
# Download: http://sparkjava.com/

javac -cp "spark-core-2.9.3.jar;slf4j-simple-1.7.30.jar;" WebApp.java
java -cp "spark-core-2.9.3.jar;slf4j-simple-1.7.30.jar;." WebApp
```

## 5. Batch Scripts for Easy Execution

### Create compile_and_run.bat
```batch
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
```

### Create database_run.bat
```batch
@echo off
echo Running database program...
java -cp "lib/mysql-connector-j-8.0.33.jar;." %1
pause
```

### Create swing_run.bat
```batch
@echo off
echo Running Swing application...
javac %1.java
if %ERRORLEVEL% EQU 0 (
    echo Starting GUI application...
    java %1
) else (
    echo Compilation failed!
)
pause
```

## 6. Common Issues and Solutions

### "javac is not recognized"
- Solution: Add JDK bin directory to PATH environment variable

### "Could not find or load main class"
- Solution: Check classpath and ensure you're in the correct directory

### Database connection errors
- Solution: Ensure database server is running and credentials are correct
- Solution: Check if JDBC driver JAR is in classpath

### Memory issues
```cmd
# Increase heap size
java -Xmx1024m -Xms512m YourProgram
```

## 7. Advanced Options

### Compile all Java files in directory
```cmd
javac *.java
```

### Run with specific encoding
```cmd
javac -encoding UTF-8 YourProgram.java
```

### Enable assertions during runtime
```cmd
java -ea YourProgram
```

### View JVM options
```cmd
java -X
```

## 8. Project Structure Example

```
YourProject/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── YourProgram.java
│   └── test/
│       └── java/
├── lib/
│   ├── mysql-connector-j-8.0.33.jar
│   └── sqlite-jdbc-3.41.2.1.jar
├── build.bat
└── run.bat
```

This setup allows you to run any Java program from command line without needing an IDE like Windsurf.

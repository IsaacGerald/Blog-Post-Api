# Running a Spring Boot Project in IntelliJ IDEA

## Prerequisites
Before running the project, ensure you have the following installed:

- **Java JDK 17** (or the required version for the project)
- **IntelliJ IDEA** (Ultimate or Community Edition)
- **Maven** (if not bundled with IntelliJ)
- **Spring Boot Project** (Cloned from GitHub or created using Spring Initializr)

## Step-by-Step Guide

### 1. Clone the Project (If not already cloned)
If your project is hosted on GitHub, clone it using:
```sh
git clone  https://github.com/IsaacGerald/Blog-Post-Api.git
```

### 2. Open the Project in IntelliJ IDEA
- Open IntelliJ IDEA.
- Click on **File → Open**.
- Select the project's root folder and click **OK**.
- IntelliJ will detect it as a Maven/Gradle project and import dependencies automatically.

### 3. Configure JDK and Maven
- Go to **File → Project Structure → Project**.
- Set **Project SDK** to your installed JDK (e.g., Java 17).
- Under **Project Structure → Modules**, ensure **Language Level** matches your JDK.
- Under **Build, Execution, Deployment → Build Tools → Maven**, set:
  - **Maven home directory** to the installed Maven version.
  - **JDK for Importer** to the project SDK.

### 4. Build the Project
To ensure everything compiles correctly:
```sh
mvn clean install
```
Or in IntelliJ:
- Open the **Maven** tool window (View → Tool Windows → Maven).
- Click on **Lifecycle → clean**, then **install**.

### 5. Run the Spring Boot Application
There are multiple ways to run the application:
#### Option 1: Using IntelliJ Run Configuration
- Open the `Application` class (the class with `@SpringBootApplication`).
- Right-click inside the class → **Run 'Application'**.
- Alternatively, click the green play button next to the `main` method.

#### Option 2: Using Maven
Run the following command in the terminal:
```sh
mvn spring-boot:run
```

#### Option 3: Using Gradle (If Gradle is used)
```sh
gradlew bootRun
```
For macOS/Linux:
```sh
./gradlew bootRun
```

### 6. Verify the Application is Running
Open a browser and visit:
```sh
http://localhost:8062
```

### 7. Stopping the Application
- Press **Ctrl + C** in the terminal.
- Or click the **Stop** button in IntelliJ.

### 8. Running Tests (Optional)
To run unit tests:
```sh
mvn test
```
Or via IntelliJ:
- Open the **Maven** tool window → Click **test** under Lifecycle.
- Or right-click a test class and select **Run 'Tests'**.

## Troubleshooting
- **Port Already in Use:** Change the port in `application.properties`:
  ```properties
  server.port=8062
  ```
- **Dependency Issues:** Run `mvn clean package` to rebuild the dependencies.
- **JDK Issues:** Ensure the correct JDK is selected under **File → Project Structure**.

---
Now your Spring Boot application should be running successfully in IntelliJ IDEA! 🚀


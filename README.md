# entrata-testing-framework

## Overview

This project is a UI automation testing framework for Entrata.com. It’s designed to validate forms, capture screenshots on failure, and generate detailed execution reports using ExtentReports. The framework uses data-driven techniques with JSON files and leverages popular libraries and tools to ensure maintainability and reliability.

## Tech Stack

- **Java**
- **Selenium**
- **TestNG**
- **Maven**
- **Log4j**
- **ExtentReports**

## Features

- **Data-Driven Testing:** Read test data from JSON files.
- **Screenshot Capture on Failure:** Automatically take and save screenshots when a test fails.
- **Detailed Reports:** Generate comprehensive execution reports with ExtentReports.
- **Logging:** Detailed logging using Log4j.
- **Page Object Model (POM):** Structured code organization for maintainability.
- **Easy Setup:** Simply run the provided TestNG XML file to execute tests.

## Getting Started

### Prerequisites

- **Java 8+**
- **Maven**
- **Browser Drivers:** Drivers for Chrome, Firefox, or Edge are managed via WebDriverManager.
- **IDE:** (e.g., IntelliJ IDEA, Eclipse, etc.)

### Setup Instructions

1. **Clone the repository:**

    ```bash
    git clone <repository-url>
    cd entrata-testing-framework
    ```

2. **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

3. **Configure Test Settings:**
   - Modify the configuration in the `config.properties` file located in `src/test/resources/` if needed.
   - The project uses a `testng.xml` file for test execution.

### Running Tests

- **Using TestNG:**  
  Right-click the `testng.xml` file in your IDE and select “Run as TestNG Suite.”

- **Using Maven:**  
  Run the following command:
  
    ```bash
    mvn test
    ```

## Project Structure

- **src/main/java:**  
  Contains all  page objects, and utilities.
  - **pages:** Contains Page Object Model (POM) classes.
  - **utils:** Contains helper classes (e.g., CommonUtils for screenshot capture, ExtentReports configuration, etc.)
  
  - **src/test/java:**  
   - **testcomponents:** Contains BaseTest and Listeners classes.
   - **tests:** Contains the actual test cases.
   
- **src/test/resources:**  
  - **config.properties:** Project configuration settings.
  - **testdata:** JSON files containing test data.

- **reports:**  
  The folder where ExtentReports HTML output is generated after test execution.

- **screenshots:**  
  Folder where screenshots are saved when tests fail.

## Author

Tejas Gondake

## License

No license provided.

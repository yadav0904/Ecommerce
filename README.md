
# 🛒 Ecommerce UI Test Automation Framework

This is a robust, scalable Selenium-based automation framework built to test the functionality of an ecommerce web application. It uses **Java**, **TestNG**, and **Cucumber BDD** for test design, execution, and reporting. The framework follows the **Page Object Model (POM)** design pattern and is built with modularity and reusability in mind.

---

## 📌 Objectives

- Automate user flows on an ecommerce platform (e.g., add to cart, checkout, login).
- Provide readable, maintainable test code using BDD syntax.
- Support CI/CD integration and flexible browser support.
- Enable parallel execution and reporting through TestNG.

---

## 🔧 Technology Stack

| Tool/Library       | Purpose                                 |
|--------------------|------------------------------------------|
| **Java (17+)**     | Programming language                     |
| **Maven**          | Build automation and dependency management |
| **Selenium 4**     | Web browser automation                   |
| **Cucumber**       | BDD-style test design with Gherkin syntax |
| **TestNG**         | Test orchestration and suite execution    |
| **WebDriverManager** | Automatic browser driver management    |
| **Lombok**         | Boilerplate code reduction (⚠ JDK 24 conflict) |
| **IntelliJ IDEA**  | Preferred IDE with plugin support         |

---

## 📁 Project Structure

```
Ecommerce-main/
├── src/
│   ├── main/java/
│   │   ├── config/           → WebDriver setup and config loading
│   │   ├── pages/            → Page Object classes for UI interaction
│   │   └── utils/            → Generic helpers (e.g., waits)
│   └── test/java/
│       ├── stepdefinitions/  → Step definition bindings for Cucumber
│       ├── runners/          → Test runners for executing Cucumber + TestNG
│       └── utils/            → Test-specific helpers
├── resources/
│   └── features/             → Cucumber `.feature` files
├── pom.xml                   → Maven project descriptor
├── testng.xml                → TestNG suite configuration
```

---

## 🚀 Setup Instructions

### ✅ Prerequisites

- Java JDK 17 or 21 installed (JDK 24 **not yet supported** by Lombok)
- Maven installed (`mvn -v` to verify)
- IntelliJ IDEA with the following plugins:
  - ✅ **Cucumber for Java**
  - ✅ **Gherkin**

### 🧪 Build & Execute Tests

```bash
# Step 1: Use JDK 17 for compiling (Lombok-safe)
export JAVA_HOME=/path/to/jdk-17
mvn clean compile

# Step 2: Run tests (can switch to JDK 24 after compiling)
export JAVA_HOME=/path/to/jdk-24
mvn test
```

---
## 🧠 Key Design Concepts

### 🔁 Page Object Model (POM)
Each UI page or component is modeled as a class with clearly named methods representing user actions.

### 🧪 BDD with Cucumber
Feature files describe test scenarios in human-readable Gherkin format:
```gherkin
Scenario: Add item to cart
  Given I am logged in
  When I add a product to the cart
  Then the cart should contain the product
```

Step definitions link these Gherkin steps to Java methods.

---

## 📄 License

This project is open-source and intended for educational or internal QA use.

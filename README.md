# Selenium Web Automation with Java

This is a Selenium WebDriver automation framework written in Java. It features custom wrapper methods for common actions like clicking, entering text, selecting radio buttons, and waiting for elements.

## 🚀 Features

- Wrapper class for reusable Selenium actions
        Example
        Wrappers wrapper = new Wrappers(driver, 10);
        wrapper.radioButton(driver, "0-2");

- Explicit wait handling using WebDriverWait
- Clean and modular structure
- Easy-to-read and extend test methods
- Click radio buttons by label text (e.g., `"0-2"`)
- Cross-browser compatible (ChromeDriver by default)

## 🧰 Tech Stack

- Java
- Selenium WebDriver
- Maven (optional)
- JUnit / TestNG (if used)

## 📁 Project Structure
project-root/
│
├── src/
│ ├── main/java/utils/ # Wrapper classes (e.g., Wrappers.java)
│ └── test/java/ # Your test classes
│
├── pom.xml (if using Maven)
└── README.md
## ⚙️ Setup Instructions

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/selenium-form-automation-java.git
   cd selenium-form-automation-java

## Author
Praful Kaul
   


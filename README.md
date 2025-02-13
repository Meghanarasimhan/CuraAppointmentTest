# CuraAppointmentTest

## Project Overview
CuraAppointmentTest is an **automation testing project** for the **Cura Healthcare appointment booking system**. It is built using:
- **Selenium WebDriver** for browser automation
- **Cucumber** for Behavior-Driven Development (BDD)
- **Maven** for dependency management
- **JUnit** for test execution

The goal of this project is to automate the process of booking an appointment on the **Cura Healthcare Service** website.

---

## Setup & Installation

### ** Prerequisites**
Ensure you have the following installed:
- **Java (JDK 11 or later)**
- **Maven**
- **Git**
- **Chrome WebDriver (Managed by WebDriverManager)**

### ** Clone the Repository**
```sh
git clone https://github.com/Meghanarasimhan/CuraAppointmentTest.git
cd CuraAppointmentTest
```

### ** Project Structure**
```
CuraAppointmentTest/
│── .idea/                          
│── src/
│   ├── main/                        # (Not used in test projects)
│   ├── test/
│   │   ├── java/
│   │   │   ├── stepdefinitions/     # Step definitions for Cucumber
│   │   │   ├── runners/             # Cucumber TestRunner
│   │   │   ├── hooks/               # Setup & Teardown hooks
│   │   ├── resources/
│   │   │   ├── features/            # Cucumber feature files (BDD scenarios)
│   │   │   ├── configs/             # Configuration files (if needed)
│── pom.xml                           # Maven build configuration
│── README.md                         # Project documentation
│── .gitignore                         # Ignored files 
```

### **Features & Scenarios**

- **Implemented Test Scenarios** : Login Tests , Valid login, Invalid login

- **Appointment Booking Tests**  : Book an appointment successfully, Validate required fields

- **Error Handling** : Verify error messages for missing data

### **Install Dependencies**
```
mvn clean install
```

### **Run the Tests**
```
mvn test
```

### **run tests with specific Cucumber tags**
```
mvn test -Dcucumber.options="--tags @Login"

```

### **Website URL**
```
https://katalon-demo-cura.herokuapp.com
```

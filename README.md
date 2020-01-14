# olx-tests
Automated UI test cases for https://www.olx.ua/ (Cucumber Java)

## Usage:
* [Git](https://git-scm.com/)
* Java 8 or above
* Apache Maven 3.6.0 or above
* [Cucumber plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java/)
* Support 5 browsers, Chrome browser by default

## Installation:
* ``` git clone <repository-url> ```

## Running
* ```mvn -Dbrowser=<browser> clean verify```

## Building Report 
* ```mvn clean test```
* ```mvn allure:serve```

## Author
anastasia.stoianchuk@gmail.com 2019


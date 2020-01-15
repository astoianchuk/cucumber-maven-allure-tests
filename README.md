# tests
Automated UI tests (Cucumber Java)
Tests can be executing parallel using cucumber4 feature

## Usage:
* [Git](https://git-scm.com/)
* Java 8 or above
* Apache Maven 3.6.0 or above
* Cucumber 4 or above
* [Cucumber plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java/)
* Chrome browser by default

## Installation:
* ``` git clone <repository-url> ```

## Running
* ```mvn -Dbrowser=<browser> clean verify```
//supported browsers: chrome, fireFox, edge, opera, InternetExplorer

## Building Report 
* ```mvn clean test```
* ```mvn allure:serve```

## Author
anastasia.stoianchuk@gmail.com 2019


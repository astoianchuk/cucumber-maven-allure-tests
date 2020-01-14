package com.qwertyna.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/qwertyna/tests/features/"}, plugin = {
        "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json"},
        glue = {"parallel"})
public class RunCucumberTest {
}

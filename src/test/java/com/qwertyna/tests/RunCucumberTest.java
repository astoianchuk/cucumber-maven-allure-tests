package com.qwertyna.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/qwertyna/tests/features"}, plugin = {"pretty"})
public class RunCucumberTest {
}
